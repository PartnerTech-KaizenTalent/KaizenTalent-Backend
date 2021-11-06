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
import pe.partnertech.kaizentalent.model.Habilidad;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IHabilidadService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.validation.SkillValidation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HabilidadController {

    final
    IUsuarioService usuarioService;

    final
    IHabilidadService habilidadService;

    public HabilidadController(IUsuarioService usuarioService, IHabilidadService habilidadService) {
        this.usuarioService = usuarioService;
        this.habilidadService = habilidadService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/habilidad")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarHabilidadPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                        @RequestBody Habilidad habilidad) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillValidation> list_habilidades = new HashSet<>();

            habilidadService.ValidarHabilidades(id_postulante, habilidad.getNombreHabilidad(),
                    habilidad.getNivelHabilidad()).forEach(
                    habilidades -> list_habilidades.add(
                            new SkillValidation(
                                    id_postulante,
                                    habilidad.getNombreHabilidad(),
                                    habilidad.getNivelHabilidad()
                            )));

            if (list_habilidades.size() < 1) {
                //Asignando Postulante
                habilidad.setUsuarioHabilidad(postulante);

                habilidadService.GuardarHabilidad(habilidad);

                return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                        "Habilidad."),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado esa Habilidad."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postulante/{id_postulante}/habilidad/{id_habilidad}/update")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateHabilidadPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                       @PathVariable("id_habilidad") Long id_habilidad,
                                                       @RequestBody Habilidad habilidad) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Set<SkillValidation> list_habilidades = new HashSet<>();

            habilidadService.ValidarHabilidades(id_postulante, habilidad.getNombreHabilidad(),
                    habilidad.getNivelHabilidad()).forEach(
                    habilidades -> list_habilidades.add(
                            new SkillValidation(
                                    id_postulante,
                                    habilidad.getNombreHabilidad(),
                                    habilidad.getNivelHabilidad()
                            )));

            if (list_habilidades.size() < 1) {
                Optional<Habilidad> habilidad_data =
                        habilidadService.BuscarHabilidad_By_IDHabilidad(id_habilidad);

                if (habilidad_data.isPresent()) {
                    Habilidad habilidad_update = habilidad_data.get();

                    habilidad_update.setNombreHabilidad(habilidad.getNombreHabilidad());
                    habilidad_update.setNivelHabilidad(habilidad.getNivelHabilidad());

                    habilidadService.GuardarHabilidad(habilidad_update);

                    return new ResponseEntity<>(new MessageResponse("Habilidad actualizada satisfactoriamente."),
                            HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new MessageResponse("No se encontró información de la Habilidad."),
                            HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado un Habilidad con dichos datos."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/habilidad/{id_habilidad}/delete")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> DeleteHabilidad(@PathVariable("id_habilidad") Long id_habilidad) {

        Optional<Habilidad> habilidad_data =
                habilidadService.BuscarHabilidad_By_IDHabilidad(id_habilidad);

        if (habilidad_data.isPresent()) {
            habilidadService.EliminarHabilidad(id_habilidad);

            return new ResponseEntity<>(new MessageResponse("Se ha eliminado la Habilidad satisfactoriamente."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al querer eliminar la Habilidad."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/postulante/{id_postulante}/habilidad/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> MostrarHabilidadesPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendHabilidades(id_postulante, usuarioService, habilidadService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
