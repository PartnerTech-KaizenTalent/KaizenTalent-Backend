/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.profile.reclutador.InactivePostsReclutadorResponse;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NoActivePostsController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public NoActivePostsController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @GetMapping("/reclutador/{id_reclutador}/profile/posts/noactive")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> PerfilReclutadorNoActivePosts(@PathVariable("id_reclutador") Long id_reclutador) {

        Set<InactivePostsReclutadorResponse> noactive_posts = new HashSet<>();

        usuariosPuestosTrabajoService.BuscarPublicaciones_By_IDReclutadorAndEstadoPublicacion(id_reclutador, "No Activo")
                .forEach(
                        posts -> noactive_posts.add(
                                new InactivePostsReclutadorResponse(
                                        posts.getPuestotrabajo().getIdPuestoTrabajo(),
                                        posts.getPuestotrabajo().getNombrePuestoTrabajo(),
                                        posts.getPuestotrabajo().getEstadoPuestoTrabajo(),
                                        posts.getPuestotrabajo().getUsuariosPuestoTrabajo().size() - 1,
                                        posts.getPuestotrabajo().getPeriodoactualPuestoTrabajo()
                                )));

        return new ResponseEntity<>(noactive_posts, HttpStatus.OK);
    }
}
