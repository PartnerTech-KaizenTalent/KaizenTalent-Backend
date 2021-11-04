/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.profile.reclutador.PostsReclutadorResponse;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PausedPostsController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public PausedPostsController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @GetMapping("/reclutador/{id_reclutador}/profile/posts/paused")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> PerfilReclutadorAllPosts(@PathVariable("id_reclutador") Long id_reclutador) {

        Set<PostsReclutadorResponse> paused_posts = new HashSet<>();

        usuariosPuestosTrabajoService.BuscarPublicaciones_By_IDReclutadorAndEstadoPublicacion(id_reclutador, "En Pausa")
                .forEach(
                        posts -> paused_posts.add(
                                new PostsReclutadorResponse(
                                        posts.getPuestotrabajo().getIdPuestoTrabajo(),
                                        posts.getPuestotrabajo().getNombrePuestoTrabajo(),
                                        posts.getPuestotrabajo().getEstadoPuestoTrabajo(),
                                        posts.getPuestotrabajo().getUsuariosPuestoTrabajo().size() - 1,
                                        posts.getPuestotrabajo().getCiudadPuestoTrabajo(),
                                        posts.getPuestotrabajo().getCategoriaPuestoTrabajo(),
                                        posts.getPuestotrabajo().getModalidadPuestoTrabajo(),
                                        posts.getPuestotrabajo().getTipojornadaPuestoTrabajo(),
                                        posts.getPuestotrabajo().getSueldoPuestoTrabajo(),
                                        posts.getPuestotrabajo().getExperienciaPuestoTrabajo(),
                                        posts.getPuestotrabajo().getPeriodoactualPuestoTrabajo(),
                                        posts.getPuestotrabajo().getDescripcionPuestoTrabajo()
                                )));

        return new ResponseEntity<>(paused_posts, HttpStatus.OK);
    }
}
