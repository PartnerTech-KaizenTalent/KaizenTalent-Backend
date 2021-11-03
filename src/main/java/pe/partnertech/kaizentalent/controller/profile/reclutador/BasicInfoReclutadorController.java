/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.dto.response.profile.reclutador.BasicInfoReclutadorResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BasicInfoReclutadorController {

    final
    IUsuarioService usuarioService;

    public BasicInfoReclutadorController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/reclutador/{id_reclutador}/profile/basicinfo")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> BasicInfoReclutador(@PathVariable("id_reclutador") Long id_reclutador) {

        Optional<Usuario> reclutador_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (reclutador_data.isPresent()) {
            Usuario reclutador = reclutador_data.get();

            return new ResponseEntity<>(new BasicInfoReclutadorResponse(
                    reclutador.getNombreUsuario(),
                    reclutador.getTituloUsuario(),
                    reclutador.getDescripcionUsuario(),
                    reclutador.getDireccionUsuario(),
                    reclutador.getEmailUsuario(),
                    reclutador.getTelefonoUsuario(),
                    reclutador.getCiudadUsuario(),
                    reclutador.getContactanteempresaUsuario(),
                    new ImagenResponse(reclutador.getImagenUsuario().getNombreImagen(),
                            reclutador.getImagenUsuario().getUrlImagen())
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra información del perfil del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
