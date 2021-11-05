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
import pe.partnertech.kaizentalent.model.Conocimiento;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IConocimientoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.validation.SkillValidation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ConocimientoController {

    final
    IUsuarioService usuarioService;

    final
    IConocimientoService conocimientoService;

    public ConocimientoController(IUsuarioService usuarioService, IConocimientoService conocimientoService) {
        this.usuarioService = usuarioService;
        this.conocimientoService = conocimientoService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/conocimiento")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarConocimientoPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                           @RequestBody Conocimiento conocimiento) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillValidation> list_skills = new HashSet<>();

            conocimientoService.ValidarConocimientos(id_postulante, conocimiento.getNombreConocimiento(),
                    conocimiento.getNivelConocimiento()).forEach(
                    conocimientos -> list_skills.add(
                            new SkillValidation(
                                    id_postulante,
                                    conocimiento.getNombreConocimiento(),
                                    conocimiento.getNivelConocimiento()
                            )));

            if (list_skills.size() < 1) {
                //Asignando Postulante
                conocimiento.setUsuarioConocimiento(postulante);

                conocimientoService.GuardarConocimiento(conocimiento);

                return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                        "Conocimiento."),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado ese Conocimiento."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postulante/{id_postulante}/conocimiento/{id_conocimiento}/update")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateConocimientoPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                          @PathVariable("id_conocimiento") Long id_conocimiento,
                                                          @RequestBody Conocimiento conocimiento) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Set<SkillValidation> list_skills = new HashSet<>();

            conocimientoService.ValidarConocimientos(id_postulante, conocimiento.getNombreConocimiento(),
                    conocimiento.getNivelConocimiento()).forEach(
                    conocimientos -> list_skills.add(
                            new SkillValidation(
                                    id_postulante,
                                    conocimiento.getNombreConocimiento(),
                                    conocimiento.getNivelConocimiento()
                            )));

            if (list_skills.size() < 1) {
                Optional<Conocimiento> conocimiento_data =
                        conocimientoService.BuscarConocimiento_By_IDConocimiento(id_conocimiento);

                if (conocimiento_data.isPresent()) {
                    Conocimiento conocimiento_update = conocimiento_data.get();

                    conocimiento_update.setNombreConocimiento(conocimiento.getNombreConocimiento());
                    conocimiento_update.setNivelConocimiento(conocimiento.getNivelConocimiento());

                    conocimientoService.GuardarConocimiento(conocimiento_update);

                    return new ResponseEntity<>(new MessageResponse("Conocimiento actualizado satisfactoriamente."),
                            HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new MessageResponse("No se encontró información del Conocimiento."),
                            HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado un Conocimiento con dichos datos."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/conocimiento/{id_conocimiento}/delete")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> DeleteConocimiento(@PathVariable("id_conocimiento") Long id_conocimiento) {

        Optional<Conocimiento> conocimiento_data =
                conocimientoService.BuscarConocimiento_By_IDConocimiento(id_conocimiento);

        if (conocimiento_data.isPresent()) {
            conocimientoService.EliminarConocimiento(id_conocimiento);

            return new ResponseEntity<>(new MessageResponse("Se ha eliminado el Conocimiento satisfactoriamente."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al querer eliminar el Conocimiento."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/postulante/{id_postulante}/conocimiento/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> MostrarConocimientosPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendConocimientos(id_postulante, usuarioService, conocimientoService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
