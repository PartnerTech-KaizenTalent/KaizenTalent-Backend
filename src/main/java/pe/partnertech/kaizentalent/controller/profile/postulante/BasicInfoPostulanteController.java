/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SendData;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.BasicInfoPostulanteResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BasicInfoPostulanteController {

    final
    IUsuarioService usuarioService;

    public BasicInfoPostulanteController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/postulante/{id_postulante}/profile/basicinfo")
    @PreAuthorize("hasRole('ROLE_POSTULANTE') or hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> BasicInfoPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            return new ResponseEntity<>(new BasicInfoPostulanteResponse(
                    postulante.getNombreUsuario(),
                    postulante.getApellidoUsuario(),
                    postulante.getDireccionUsuario(),
                    postulante.getEmailUsuario(),
                    postulante.getTelefonoUsuario(),
                    postulante.getCiudadUsuario(),
                    postulante.getDescripcionUsuario(),
                    postulante.getTituloUsuario(),
                    new ImagenResponse(postulante.getImagenUsuario().getNombreImagen(),
                            postulante.getImagenUsuario().getUrlImagen()),
                    Code_SendData.SendDocumentoCV(id_postulante, usuarioService)
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra información del perfil del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
