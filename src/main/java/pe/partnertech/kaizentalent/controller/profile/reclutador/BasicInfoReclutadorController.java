/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.BasicInfoPostulanteResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IImagenService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BasicInfoReclutadorController {

    final
    IUsuarioService usuarioService;

    final
    IImagenService imagenService;

    public BasicInfoReclutadorController(IUsuarioService usuarioService, IImagenService imagenService) {
        this.usuarioService = usuarioService;
        this.imagenService = imagenService;
    }

    @GetMapping("/reclutador/{id_reclutador}/profile/basicinfo")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> BasicInfoPostulante(@PathVariable("id_reclutador") Long id_reclutador) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            DocumentoCVResponse documentocv = new DocumentoCVResponse();

            if (postulante.getDocumentoCVUsuario() == null) {
                documentocv.setNombreDocumentoCV(null);
                documentocv.setUrlDocumentoCV(null);
            } else {
                documentocv.setNombreDocumentoCV(postulante.getDocumentoCVUsuario().getNombreDocumentoCV());
                documentocv.setUrlDocumentoCV(postulante.getDocumentoCVUsuario().getUrlDocumentoCV());
            }

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
                    documentocv
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra información del perfil del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}
