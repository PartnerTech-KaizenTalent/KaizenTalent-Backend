/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.reclutador;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.profile.reclutador.ActivePostsReclutadorResponse;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ActivePostsController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public ActivePostsController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @GetMapping("/reclutador/{id_reclutador}/profile/posts/active")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> PerfilReclutadorActivePosts(@PathVariable("id_reclutador") Long id_reclutador) {

        Set<ActivePostsReclutadorResponse> active_posts = new HashSet<>();

        usuariosPuestosTrabajoService.BuscarPublicaciones_By_IDReclutadorAndEstadoPublicacion(id_reclutador, "Activo")
                .forEach(
                        posts -> {
                            active_posts.add(
                                    new ActivePostsReclutadorResponse(
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
                                    ));
                        });

        return new ResponseEntity<>(active_posts, HttpStatus.OK);
    }
}
