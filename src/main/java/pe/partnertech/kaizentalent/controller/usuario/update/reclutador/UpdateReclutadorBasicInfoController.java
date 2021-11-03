/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.update.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UpdateReclutadorBasicInfoController {

    final
    IUsuarioService usuarioService;

    public UpdateReclutadorBasicInfoController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PutMapping("/reclutador/{id_reclutador}/update/basicinfo")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> UpdateBasicInfoReclutador(@PathVariable("id_reclutador") Long id_reclutador,
                                                       @RequestBody Usuario usuario) {

        Optional<Usuario> reclutador_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (reclutador_data.isPresent()) {
            Usuario reclutador = reclutador_data.get();

            reclutador.setContactanteempresaUsuario(usuario.getContactanteempresaUsuario());
            reclutador.setTelefonoUsuario(usuario.getTelefonoUsuario());
            reclutador.setDireccionUsuario(usuario.getDireccionUsuario());
            reclutador.setDescripcionUsuario(usuario.getDescripcionUsuario());
            reclutador.setTituloUsuario(usuario.getTituloUsuario());
            reclutador.setCiudadUsuario(usuario.getCiudadUsuario());

            usuarioService.GuardarUsuario(reclutador);

            return new ResponseEntity<>(new MessageResponse("Se ha actualizado sus datos satisfactoriamente"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
