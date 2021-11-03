/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.update.postulante;

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
public class UpdatePostulanteBasicInfoController {

    final
    IUsuarioService usuarioService;

    public UpdatePostulanteBasicInfoController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PutMapping("/postulante/{id_postulante}/update/basicinfo")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateBasicInfoPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                       @RequestBody Usuario usuario) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            postulante.setTelefonoUsuario(usuario.getTelefonoUsuario());
            postulante.setDireccionUsuario(usuario.getDireccionUsuario());
            postulante.setDescripcionUsuario(usuario.getDescripcionUsuario());
            postulante.setTituloUsuario(usuario.getTituloUsuario());
            postulante.setSueldoUsuario(usuario.getSueldoUsuario());
            postulante.setCiudadUsuario(usuario.getCiudadUsuario());

            usuarioService.GuardarUsuario(postulante);

            return new ResponseEntity<>(new MessageResponse("Se ha actualizado sus datos satisfactoriamente"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
