/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.dto.response.reclutador.PostulantesPublicacionResponse;
import pe.partnertech.kaizentalent.dto.response.reclutador.PublicacionResponse;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PostulantesPublicacionController {

    final
    IPuestoTrabajoService puestotrabajoService;

    final
    IUsuariosPuestosTrabajoService usuariospuestostrabajoService;

    public PostulantesPublicacionController(IPuestoTrabajoService puestotrabajoService,
                                            IUsuariosPuestosTrabajoService usuariospuestostrabajoService) {
        this.puestotrabajoService = puestotrabajoService;
        this.usuariospuestostrabajoService = usuariospuestostrabajoService;
    }

    @GetMapping("/publicacion/{id_publicacion}/show/postulantes")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> MostrarPostulantesPublicacion(@PathVariable("id_publicacion") Long id_publicacion) {

        Optional<PuestoTrabajo> publicacion_data = puestotrabajoService.BuscarPuestoTrabajo_By_ID(id_publicacion);

        if (publicacion_data.isPresent()) {

            PuestoTrabajo publicacion = publicacion_data.get();

            Set<PostulantesPublicacionResponse> list_postulantes = new HashSet<>();

            usuariospuestostrabajoService.BuscarPostulantes_By_IDPublicacion(id_publicacion).forEach(
                    publicaciones -> {
                        if (publicaciones.getUsuario().getDocumentoCVUsuario() != null) {
                            list_postulantes.add(
                                    new PostulantesPublicacionResponse(
                                            publicaciones.getUsuario().getIdUsuario(),
                                            publicaciones.getUsuario().getNombreUsuario() + " " +
                                                    publicaciones.getUsuario().getApellidoUsuario(),
                                            publicaciones.getUsuario().getTituloUsuario(),
                                            publicaciones.getUsuario().getCiudadUsuario(),
                                            new ImagenResponse(
                                                    publicaciones.getUsuario().getImagenUsuario().getNombreImagen(),
                                                    publicaciones.getUsuario().getImagenUsuario().getUrlImagen()
                                            ),
                                            new DocumentoCVResponse(
                                                    publicaciones.getUsuario().getDocumentoCVUsuario().getNombreDocumentoCV(),
                                                    publicaciones.getUsuario().getDocumentoCVUsuario().getUrlDocumentoCV()
                                            )));
                        } else {
                            list_postulantes.add(
                                    new PostulantesPublicacionResponse(
                                            publicaciones.getUsuario().getIdUsuario(),
                                            publicaciones.getUsuario().getNombreUsuario() + " " +
                                                    publicaciones.getUsuario().getApellidoUsuario(),
                                            publicaciones.getUsuario().getTituloUsuario(),
                                            publicaciones.getUsuario().getCiudadUsuario(),
                                            new ImagenResponse(
                                                    publicaciones.getUsuario().getImagenUsuario().getNombreImagen(),
                                                    publicaciones.getUsuario().getImagenUsuario().getUrlImagen()
                                            ),
                                            new DocumentoCVResponse(
                                                    null,
                                                    null
                                            )));
                        }
                    });

            return new ResponseEntity<>(new PublicacionResponse(publicacion.getNombrePuestoTrabajo(), list_postulantes),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información de la publicación."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
