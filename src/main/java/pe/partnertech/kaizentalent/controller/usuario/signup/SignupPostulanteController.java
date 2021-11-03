/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.signup;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SendVerifyEmail;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SetUserRol;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SignupValidations;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_UploadFoto;
import pe.partnertech.kaizentalent.dto.request.usuario.general.UtilityTokenRequest;
import pe.partnertech.kaizentalent.dto.request.usuario.signup.PostulanteSignupRequest;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.enums.RolNombre;
import pe.partnertech.kaizentalent.model.Rol;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UtilityToken;
import pe.partnertech.kaizentalent.service.IImagenService;
import pe.partnertech.kaizentalent.service.IRolService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUtilityTokenService;
import pe.partnertech.kaizentalent.tools.UtilityKaizenTalent;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SignupPostulanteController {

    final
    PasswordEncoder passwordEncoder;

    final
    IUsuarioService usuarioService;

    final
    IRolService rolService;

    final
    IImagenService imagenService;

    final
    IUtilityTokenService utilityTokenService;

    final
    JavaMailSender mailSender;

    final
    TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String mail;

    @Value("${front.baseurl}")
    private String baseurl;

    @Value("${image.logo.url}")
    private String img_logo;

    @Value("${image.check.url}")
    private String img_check;

    public SignupPostulanteController(PasswordEncoder passwordEncoder, IUsuarioService usuarioService,
                                      IRolService rolService, IImagenService imagenService,
                                      IUtilityTokenService utilityTokenService, JavaMailSender mailSender,
                                      TemplateEngine templateEngine) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.imagenService = imagenService;
        this.utilityTokenService = utilityTokenService;
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @PostMapping("/postulante/signup")
    public ResponseEntity<?> SignupPostulante(@RequestBody PostulanteSignupRequest postulanteSignupRequest,
                                              HttpServletRequest request) {

        Optional<Usuario> usuario_data =
                usuarioService.BuscarUsuario_By_EmailUsuario(postulanteSignupRequest.getEmailUsuario());

        if (usuario_data.isPresent()) {
            return Code_SignupValidations.SignupValidationResponse(usuario_data);
        } else {
            Optional<Rol> rol_data = rolService.BuscarRol_Nombre(RolNombre.ROLE_POSTULANTE);

            if (rol_data.isPresent()) {
                try {
                    if (usuarioService.ValidarNumeroDocumento(postulanteSignupRequest.getNumerodocumentoUsuario())) {
                        return new ResponseEntity<>(new MessageResponse("El Número de Documento ya se encuentra en uso."),
                                HttpStatus.CONFLICT);
                    } else if (usuarioService.ValidarUsername(postulanteSignupRequest.getUsernameUsuario())) {
                        return new ResponseEntity<>(new MessageResponse("El Usuario ya se encuentra en uso."),
                                HttpStatus.CONFLICT);
                    } else {

                        //Formateando Fecha de Nacimiento
                        String pattern = "dd-MM-yyyy";
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                        LocalDate fechanacimiento = LocalDate.parse(postulanteSignupRequest.getFechanacimientoUsuario(),
                                formatter);

                        Usuario usuario = new Usuario(
                                postulanteSignupRequest.getNombreUsuario(),
                                postulanteSignupRequest.getApellidoUsuario(),
                                postulanteSignupRequest.getCiudadUsuario(),
                                postulanteSignupRequest.getEmailUsuario(),
                                postulanteSignupRequest.getTipodocumentoUsuario(),
                                postulanteSignupRequest.getNumerodocumentoUsuario(),
                                postulanteSignupRequest.getUsernameUsuario(),
                                passwordEncoder.encode(postulanteSignupRequest.getPasswordUsuario()),
                                postulanteSignupRequest.getGeneroUsuario(),
                                fechanacimiento
                        );
                        usuarioService.GuardarUsuario(usuario);

                        Optional<Usuario> postulante_data =
                                usuarioService.BuscarUsuario_By_EmailUsuario(postulanteSignupRequest.getEmailUsuario());

                        if (postulante_data.isPresent()) {
                            Usuario postulante = postulante_data.get();

                            //Asignando Rol: Postulante
                            Code_SetUserRol.SetUserRol(postulante, rol_data);

                            //Asignando Fecha de Registro Actual
                            postulante.setFecharegistroUsuario(LocalDate.now());

                            //Asignando Estado de Cuenta: PENDIENTE
                            postulante.setEstadoUsuario("PENDIENTE");

                            //Asignando Foto por Defecto: Postulante
                            InputStream fotoStream = getClass().getResourceAsStream("/static/img/PostulanteUser.png");
                            Code_UploadFoto.AssignFoto(postulante, fotoStream, imagenService);

                            String token = RandomString.make(50);

                            //Generando Token: Verificación
                            UtilityToken utilityToken = new UtilityToken(
                                    token,
                                    "Usuario Verify",
                                    LocalDateTime.now().plusHours(72),
                                    postulante
                            );
                            utilityTokenService.GuardarUtilityToken(utilityToken);

                            String url = UtilityKaizenTalent.GenerarUrl(request) + "/api/postulante_verify_gateway?token=" + token;

                            EnviarCorreo(postulanteSignupRequest.getEmailUsuario(), url);

                            usuarioService.GuardarUsuario(postulante);

                            return new ResponseEntity<>(new MessageResponse("Se ha registrado satisfactoriamente. " +
                                    "Revise su bandeja de entrada para verificar su cuenta. Recuerde que dispone de no " +
                                    "más de 72 horas para culminar dicho proceso. De lo contrario, deberá rellenar el " +
                                    "formulario nuevamente."),
                                    HttpStatus.OK);

                            //TODO: Conocimiento, Educacion, Experiencia Laboral

                        } else {
                            return new ResponseEntity<>(new MessageResponse("Ocurrió un error durante el proceso " +
                                    "de registro de datos."),
                                    HttpStatus.NOT_FOUND);
                        }
                    }
                } catch (Exception e) {
                    return new ResponseEntity<>(new MessageResponse("Ocurrió un error al asignar la foto de perfil " +
                            "por defecto." + e),
                            HttpStatus.EXPECTATION_FAILED);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ocurrió un error al otorgar sus permisos " +
                        "correspondientes."),
                        HttpStatus.NOT_FOUND);
            }
        }
    }

    @GetMapping("/postulante_verify_gateway")
    void RedirectPostulanteVerify(HttpServletResponse response, @Param(value = "token") String token) throws IOException {

        Optional<UtilityToken> utilitytoken_data = utilityTokenService.BuscarUtilityToken_By_Token(token);

        if (utilitytoken_data.isPresent()) {
            response.sendRedirect(baseurl + "/signup/postulante/verify/" + token);
        } else {
            response.sendRedirect(baseurl + "/error/403");
        }
    }

    @PutMapping("/postulante/signup/verify")
    public ResponseEntity<?> SignupPostulanteVerify(@RequestBody UtilityTokenRequest utilityTokenRequest) {

        Optional<UtilityToken> utilitytoken_data =
                utilityTokenService.BuscarUtilityToken_By_Token(utilityTokenRequest.getUtilityToken());

        if (utilitytoken_data.isPresent()) {
            UtilityToken utilitytoken = utilitytoken_data.get();

            Optional<Usuario> postulante_data =
                    usuarioService.BuscarUsuario_By_IDUtilityToken(utilitytoken.getIdUtilityToken());

            if (postulante_data.isPresent()) {
                Usuario postulante = postulante_data.get();

                postulante.setEstadoUsuario("ACTIVO");
                usuarioService.GuardarUsuario(postulante);

                utilityTokenService.EliminarUtilityToken(utilitytoken.getIdUtilityToken());

                return new ResponseEntity<>(new MessageResponse("Se ha verificado el usuario satisfactoriamente."),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ocurrió un error durante la búsqueda del usuario."),
                        HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error en el proceso de verificación."),
                    HttpStatus.NOT_FOUND);
        }
    }

    private void EnviarCorreo(String email, String url) throws MessagingException, UnsupportedEncodingException {

        Code_SendVerifyEmail.EnviarCorreo(email, url, mailSender, mail, img_logo, img_check, templateEngine);
    }
}
