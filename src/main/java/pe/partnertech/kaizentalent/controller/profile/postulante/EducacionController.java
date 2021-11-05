/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SendData;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.Educacion;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IEducacionService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.validation.EducacionValidation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EducacionController {

    final
    IUsuarioService usuarioService;

    final
    IEducacionService educacionService;

    public EducacionController(IUsuarioService usuarioService, IEducacionService educacionService) {
        this.usuarioService = usuarioService;
        this.educacionService = educacionService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/educacion")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarEducacionPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                        @RequestBody Educacion educacion) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            if (ValidateEducacion(id_postulante, educacion) < 1) {
                //Asignando Postulante
                educacion.setUsuarioEducacion(postulante);

                educacionService.GuardarEducacion(educacion);

                return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                        "Educacion."),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado esa Educacion."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postulante/{id_postulante}/educacion/{id_educacion}/update")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateEducacionPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                       @PathVariable("id_educacion") Long id_educacion,
                                                       @RequestBody Educacion educacion) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            if (ValidateEducacion(id_postulante, educacion) < 1) {
                Optional<Educacion> educacion_data = educacionService.BuscarEducacion_By_IDEducacion(id_educacion);

                if (educacion_data.isPresent()) {
                    Educacion educacion_update = educacion_data.get();

                    educacion_update.setInstitucionEducacion(educacion.getInstitucionEducacion());
                    educacion_update.setMesinicioEducacion(educacion.getMesinicioEducacion());
                    educacion_update.setAnioinicioEducacion(educacion.getAnioinicioEducacion());
                    educacion_update.setMesfinEducacion(educacion.getMesfinEducacion());
                    educacion_update.setAniofinEducacion(educacion.getAniofinEducacion());
                    educacion_update.setNombreEducacion(educacion.getNombreEducacion());
                    educacion_update.setNivelEducacion(educacion.getNivelEducacion());
                    educacion_update.setEstadoEducacion(educacion.getEstadoEducacion());

                    educacionService.GuardarEducacion(educacion_update);

                    return new ResponseEntity<>(new MessageResponse("Educación actualizada satisfactoriamente."),
                            HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new MessageResponse("No se encontró información de la Educación."),
                            HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado una Educacion con dichos datos."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    private int ValidateEducacion(Long id_postulante, Educacion educacion) {
        Set<EducacionValidation> list_educaciones = new HashSet<>();

        educacionService.ValidarEducaciones(id_postulante, educacion.getInstitucionEducacion(),
                educacion.getMesinicioEducacion(), educacion.getAnioinicioEducacion(),
                educacion.getMesfinEducacion(), educacion.getAniofinEducacion(), educacion.getNombreEducacion(),
                educacion.getNivelEducacion(), educacion.getEstadoEducacion()).forEach(
                educaciones -> list_educaciones.add(
                        new EducacionValidation(
                                id_postulante,
                                educacion.getInstitucionEducacion(),
                                educacion.getMesinicioEducacion(),
                                educacion.getAnioinicioEducacion(),
                                educacion.getMesfinEducacion(),
                                educacion.getAniofinEducacion(),
                                educacion.getNombreEducacion(),
                                educacion.getNivelEducacion(),
                                educacion.getEstadoEducacion()
                        )));

        return list_educaciones.size();
    }

    @DeleteMapping("/educacion/{id_educacion}/delete")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> DeleteEducacion(@PathVariable("id_educacion") Long id_educacion) {

        Optional<Educacion> educacion_data = educacionService.BuscarEducacion_By_IDEducacion(id_educacion);

        if (educacion_data.isPresent()) {
            educacionService.EliminarEducacion(id_educacion);

            return new ResponseEntity<>(new MessageResponse("Se ha eliminado la Educacion satisfactoriamente."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al eliminar la Educación."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/postulante/{id_postulante}/educacion/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> MostrarEducacionesPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendEducaciones(id_postulante, usuarioService, educacionService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }
}

