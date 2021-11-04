/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PostulacionController {

    final
    IUsuarioService usuarioService;

    final
    IPuestoTrabajoService puestotrabajoService;

    final
    IUsuariosPuestosTrabajoService usuariospuestostrabajoService;

    public PostulacionController(IUsuarioService usuarioService, IPuestoTrabajoService puestotrabajoService,
                                 IUsuariosPuestosTrabajoService usuariospuestostrabajoService) {
        this.usuarioService = usuarioService;
        this.puestotrabajoService = puestotrabajoService;
        this.usuariospuestostrabajoService = usuariospuestostrabajoService;
    }

    @PostMapping("/postulante/{id_postulante}/postular/publicacion/{id_publicacion}")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> PostularPuestoTrabajo(@PathVariable("id_postulante") Long id_postulante,
                                                   @PathVariable("id_publicacion") Long id_publicacion) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Optional<PuestoTrabajo> publicacion_data = puestotrabajoService.BuscarPuestoTrabajo_By_ID(id_publicacion);

            if (publicacion_data.isPresent()) {
                PuestoTrabajo publicacion = publicacion_data.get();

                if (usuariospuestostrabajoService.ValidarPostulacion(postulante, publicacion)) {
                    return new ResponseEntity<>(new MessageResponse("Ya se encuentra postulado al Puesto de Trabajo"),
                            HttpStatus.CONFLICT);
                } else {
                    UsuariosPuestosTrabajo usuariosPuestosTrabajo = new UsuariosPuestosTrabajo(
                            postulante,
                            publicacion
                    );
                    usuariospuestostrabajoService.GuardarUsuariosPuestosTrabajo(usuariosPuestosTrabajo);

                    return new ResponseEntity<>(new MessageResponse("Se ha postulado satisfactoriamente a la Publicación."),
                            HttpStatus.OK);
                }

            } else {
                return new ResponseEntity<>(new MessageResponse("Ocurrió un error al procesar los datos de la publicación."),
                        HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al querer postular a la publicación."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
