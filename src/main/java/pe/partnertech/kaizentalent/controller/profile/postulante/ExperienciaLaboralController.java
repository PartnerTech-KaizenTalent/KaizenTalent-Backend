/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SendData;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_UploadFoto;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.ExperienciaLaboral;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IExperienciaLaboralService;
import pe.partnertech.kaizentalent.service.IImagenService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.validation.ExperienciaLaboralValidation;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ExperienciaLaboralController {

    final
    IUsuarioService usuarioService;

    final
    IExperienciaLaboralService experienciaLaboralService;

    final
    IImagenService imagenService;

    public ExperienciaLaboralController(IUsuarioService usuarioService, IExperienciaLaboralService experienciaLaboralService,
                                        IImagenService imagenService) {
        this.usuarioService = usuarioService;
        this.experienciaLaboralService = experienciaLaboralService;
        this.imagenService = imagenService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/experiencialaboral")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarConocimientoPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                           @RequestBody ExperienciaLaboral experiencialaboral) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            if (ValidateExperienciaLaboral(id_postulante, experiencialaboral) < 1) {
                try {
                    //Asignando Postulante
                    experiencialaboral.setUsuarioExperienciaLaboral(postulante);
                    experienciaLaboralService.GuardarExperienciaLaboral(experiencialaboral);

                    //Asignando Logo Empresa
                    InputStream fotoStream = getClass().getResourceAsStream("/static/img/DefaultLogo.png");
                    Code_UploadFoto.AssignImagenToExperienciaLaboral(experiencialaboral, usuarioService, fotoStream,
                            imagenService, "/logos/");

                    experienciaLaboralService.GuardarExperienciaLaboral(experiencialaboral);

                    return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                            "Experiencia Laboral."),
                            HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(new MessageResponse("Ocurrió un error al asignar el logo por defecto." + e),
                            HttpStatus.EXPECTATION_FAILED);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado esa Experiencia Laboral."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postulante/{id_postulante}/experiencialaboral/{id_experiencialaboral}/update")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateExperienciaLaboralPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                                @PathVariable("id_experiencialaboral") Long id_experiencialaboral,
                                                                @RequestBody ExperienciaLaboral experiencialaboral) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            if (ValidateExperienciaLaboral(id_postulante, experiencialaboral) < 1) {
                Optional<ExperienciaLaboral> experiencialaboral_data =
                        experienciaLaboralService.BuscarExperienciaLaboral_By_IDExperienciaLaboral(id_experiencialaboral);

                if (experiencialaboral_data.isPresent()) {
                    ExperienciaLaboral experiencialaboral_update = experiencialaboral_data.get();

                    Optional<Imagen> logoempresa_data =
                            imagenService.BuscarImagen_By_ID(experiencialaboral_update.getImagenExperienciaLaboral().getIdImagen());

                    if (logoempresa_data.isPresent()) {
                        experiencialaboral_update.setNombreExperienciaLaboral(experiencialaboral.getNombreExperienciaLaboral());
                        experiencialaboral_update.setEmpresaExperienciaLaboral(experiencialaboral.getEmpresaExperienciaLaboral());
                        experiencialaboral_update.setMesinicioExperienciaLaboral(experiencialaboral.getMesinicioExperienciaLaboral());
                        experiencialaboral_update.setAnioinicioExperienciaLaboral(experiencialaboral.getAnioinicioExperienciaLaboral());
                        experiencialaboral_update.setMesfinExperienciaLaboral(experiencialaboral.getMesfinExperienciaLaboral());
                        experiencialaboral_update.setAniofinExperienciaLaboral(experiencialaboral.getAniofinExperienciaLaboral());
                        experiencialaboral_update.setDescripcionExperienciaLaboral(experiencialaboral.getDescripcionExperienciaLaboral());
                        experiencialaboral_update.setReferenteReferenciaLaboral(experiencialaboral.getReferenteReferenciaLaboral());
                        experiencialaboral_update.setEmailreferenteReferenciaLaboral(experiencialaboral.getEmailreferenteReferenciaLaboral());
                        experiencialaboral_update.setTelefonoreferenteReferenciaLaboral(experiencialaboral.getTelefonoreferenteReferenciaLaboral());

                        experienciaLaboralService.GuardarExperienciaLaboral(experiencialaboral_update);

                        Imagen logoempresa = logoempresa_data.get();

                        String nombre_logo =
                                UUID.randomUUID() + experiencialaboral_update.getIdExperienciaLaboral().toString() +
                                        UUID.randomUUID() + ".png";

                        String url_logo = Code_UploadFoto.SendImageUrl("/logos/", nombre_logo);

                        logoempresa.setNombreImagen(nombre_logo);
                        logoempresa.setUrlImagen(url_logo);

                        //Asignando Logo Empresa
                        //-----Buscando Empresa para asignar su logo
                        Optional<Usuario> empresa_data =
                                usuarioService.BuscarUsuario_By_NombreUsuario(experiencialaboral.getEmpresaExperienciaLaboral());

                        if (empresa_data.isPresent()) {
                            Usuario empresa = empresa_data.get();

                            logoempresa.setTipoarchivoImagen(empresa.getImagenUsuario().getTipoarchivoImagen());
                            logoempresa.setArchivoImagen(empresa.getImagenUsuario().getArchivoImagen());
                        }
                        imagenService.GuardarImagen(logoempresa);

                        return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                                "Experiencia Laboral."),
                                HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(new MessageResponse("No se encontró la información requerida."),
                                HttpStatus.NOT_FOUND);
                    }
                } else {
                    return new ResponseEntity<>(new MessageResponse("No se encontró información de la Experiencia Laboral."),
                            HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado una Experiencia Laboral con " +
                        "dichos datos."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    private int ValidateExperienciaLaboral(Long id_postulante, ExperienciaLaboral experiencialaboral) {

        Set<ExperienciaLaboralValidation> list_experienciaslaborales = new HashSet<>();

        experienciaLaboralService.ValidarExperienciasLaborales(id_postulante,
                experiencialaboral.getNombreExperienciaLaboral(),
                experiencialaboral.getEmpresaExperienciaLaboral(),
                experiencialaboral.getMesinicioExperienciaLaboral(),
                experiencialaboral.getAnioinicioExperienciaLaboral(),
                experiencialaboral.getMesfinExperienciaLaboral(),
                experiencialaboral.getAniofinExperienciaLaboral(),
                experiencialaboral.getDescripcionExperienciaLaboral(),
                experiencialaboral.getReferenteReferenciaLaboral(),
                experiencialaboral.getEmailreferenteReferenciaLaboral(),
                experiencialaboral.getTelefonoreferenteReferenciaLaboral()).forEach(
                experienciaslaborales -> list_experienciaslaborales.add(
                        new ExperienciaLaboralValidation(
                                id_postulante,
                                experiencialaboral.getNombreExperienciaLaboral(),
                                experiencialaboral.getEmpresaExperienciaLaboral(),
                                experiencialaboral.getMesinicioExperienciaLaboral(),
                                experiencialaboral.getAnioinicioExperienciaLaboral(),
                                experiencialaboral.getMesfinExperienciaLaboral(),
                                experiencialaboral.getAniofinExperienciaLaboral(),
                                experiencialaboral.getDescripcionExperienciaLaboral(),
                                experiencialaboral.getReferenteReferenciaLaboral(),
                                experiencialaboral.getEmailreferenteReferenciaLaboral(),
                                experiencialaboral.getTelefonoreferenteReferenciaLaboral()
                        )));

        return list_experienciaslaborales.size();
    }

    @DeleteMapping("/experiencialaboral/{id_experiencialaboral}/delete")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> DeleteExperienciaLaboral(@PathVariable("id_experiencialaboral") Long id_experiencialaboral) {

        Optional<ExperienciaLaboral> experiencialaboral_data =
                experienciaLaboralService.BuscarExperienciaLaboral_By_IDExperienciaLaboral(id_experiencialaboral);

        if (experiencialaboral_data.isPresent()) {

            experienciaLaboralService.EliminarExperienciaLaboral(id_experiencialaboral);

            return new ResponseEntity<>(new MessageResponse("Se ha eliminado la Experiencia Laboral satisfactoriamente."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al eliminar la Experiencia Laboral."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/postulante/{id_postulante}/experiencialaboral/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> MostrarExperienciasLaboralesPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendExperienciasLaborales(id_postulante, usuarioService, experienciaLaboralService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/postulante/{id_postulante}/referencialaboral/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> MostrarReferenciasLaboralesPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendReferenciasLaborales(id_postulante, usuarioService, experienciaLaboralService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
