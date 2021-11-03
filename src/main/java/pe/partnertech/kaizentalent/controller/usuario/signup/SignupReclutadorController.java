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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import pe.partnertech.kaizentalent.controller.util.util_code.*;
import pe.partnertech.kaizentalent.dto.request.usuario.general.UtilityTokenRequest;
import pe.partnertech.kaizentalent.dto.request.usuario.signup.ReclutadorSignupRequest;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SignupReclutadorController {

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
    private String mail_kaizen;

    @Value("${front.baseurl}")
    private String baseurl;

    @Value("${image.logo.url}")
    private String img_logo;

    @Value("${image.check.url}")
    private String img_check;

    public SignupReclutadorController(PasswordEncoder passwordEncoder, IUsuarioService usuarioService,
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

    @PostMapping("/reclutador/signup")
    public ResponseEntity<?> SignupReclutador(@RequestBody ReclutadorSignupRequest reclutadorSignupRequest,
                                              HttpServletRequest request) {

        Optional<Usuario> usuario_data =
                usuarioService.BuscarUsuario_By_EmailUsuario(reclutadorSignupRequest.getEmailUsuario());

        if (usuario_data.isPresent()) {
            return Code_SignupValidations.SignupValidationResponse(usuario_data);
        } else {
            Optional<Rol> rol_data = rolService.BuscarRol_Nombre(RolNombre.ROLE_RECLUTADOR);

            if (rol_data.isPresent()) {
                try {
                    if (usuarioService.ValidarNumeroDocumento(reclutadorSignupRequest.getNumerodocumentoUsuario())) {
                        return new ResponseEntity<>(new MessageResponse("El Número de Documento ya se encuentra en uso."),
                                HttpStatus.CONFLICT);
                    } else if (usuarioService.ValidarUsername(reclutadorSignupRequest.getUsernameUsuario())) {
                        return new ResponseEntity<>(new MessageResponse("El Usuario ya se encuentra en uso."),
                                HttpStatus.CONFLICT);
                    } else {
                        Usuario usuario = new Usuario(
                                reclutadorSignupRequest.getNombreUsuario(),
                                reclutadorSignupRequest.getCiudadUsuario(),
                                reclutadorSignupRequest.getEmailUsuario(),
                                reclutadorSignupRequest.getNumerodocumentoUsuario(),
                                reclutadorSignupRequest.getUsernameUsuario(),
                                passwordEncoder.encode(reclutadorSignupRequest.getPasswordUsuario()),
                                reclutadorSignupRequest.getContactanteempresaUsuario(),
                                reclutadorSignupRequest.getTamanioempresaUsuario()
                        );
                        usuarioService.GuardarUsuario(usuario);

                        Optional<Usuario> reclutador_data =
                                usuarioService.BuscarUsuario_By_EmailUsuario(reclutadorSignupRequest.getEmailUsuario());

                        if (reclutador_data.isPresent()) {
                            Usuario reclutador = reclutador_data.get();

                            //Asignando Rol: Reclutador
                            Code_SetUserRol.SetUserRol(reclutador, rol_data);

                            //Asignando TipoDocumento: RUC
                            reclutador.setTipodocumentoUsuario("RUC");

                            //Asignando Fecha de Registro Actual
                            reclutador.setFecharegistroUsuario(LocalDate.now());

                            //Asignando Estado de Cuenta: PENDIENTE
                            reclutador.setEstadoUsuario("PENDIENTE");

                            //Asignando Foto por Defecto: Reclutador
                            InputStream fotoStream = getClass().getResourceAsStream("/static/img/ReclutadorUser.png");
                            Code_UploadFoto.AssignImagen(reclutador, fotoStream, imagenService, "/logos/");

                            String token = RandomString.make(50);

                            //Generando Token: Verificación
                            UtilityToken utilityToken = new UtilityToken(
                                    token,
                                    "Usuario Verify",
                                    LocalDateTime.now().plusHours(72),
                                    reclutador
                            );
                            utilityTokenService.GuardarUtilityToken(utilityToken);

                            String url = UtilityKaizenTalent.GenerarUrl(request) + "/api/reclutador_verify_gateway?token=" + token;

                            EnviarCorreo(reclutadorSignupRequest.getEmailUsuario(), url);

                            usuarioService.GuardarUsuario(reclutador);

                            return new ResponseEntity<>(new MessageResponse("Se ha registrado satisfactoriamente. " +
                                    "Revise su bandeja de entrada para verificar su cuenta. Recuerde que dispone de no " +
                                    "más de 72 horas para culminar dicho proceso. De lo contrario, deberá rellenar el " +
                                    "formulario nuevamente."),
                                    HttpStatus.OK);
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

    @GetMapping("/reclutador_verify_gateway")
    void RedirectReclutadorVerify(HttpServletResponse response, @Param(value = "token") String token) throws IOException {

        Optional<UtilityToken> utilitytoken_data = utilityTokenService.BuscarUtilityToken_By_Token(token);

        if (utilitytoken_data.isPresent()) {
            response.sendRedirect(baseurl + "/signup/reclutador/verify/" + token);
        } else {
            response.sendRedirect(baseurl + "/error/403");
        }
    }

    @PutMapping("/reclutador/signup/verify")
    public ResponseEntity<?> SignupReclutadorVerify(@RequestBody UtilityTokenRequest utilityTokenRequest) {

        return Code_VerifyUser.VerifyUser(utilityTokenRequest, utilityTokenService, usuarioService);
    }

    private void EnviarCorreo(String email, String url) throws MessagingException, UnsupportedEncodingException {

        Code_SendEmail.VerifyEmail(email, url, mailSender, mail_kaizen, img_logo, img_check, templateEngine);
    }
}
