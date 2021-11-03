/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PublicacionController {

    final
    IUsuarioService usuarioService;

    final
    IPuestoTrabajoService puestoTrabajoService;

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public PublicacionController(IUsuarioService usuarioService, IPuestoTrabajoService puestoTrabajoService,
                                 IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuarioService = usuarioService;
        this.puestoTrabajoService = puestoTrabajoService;
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @PostMapping("/reclutador/{id_reclutador}/publicar")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> GuardarPublicacion(@PathVariable("id_reclutador") Long id_reclutador,
                                                @RequestBody PuestoTrabajo puestotrabajo) {

        Optional<Usuario> reclutador_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (reclutador_data.isPresent()) {
            return null;
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al publicar el Puesto de Trabajo."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
