/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.update.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.DocumentoCV;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IDocumentoCVService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UpdateDocumentoCVController {

    final
    IUsuarioService usuarioService;

    final
    IDocumentoCVService documentoCVService;

    public UpdateDocumentoCVController(IUsuarioService usuarioService, IDocumentoCVService documentoCVService) {
        this.usuarioService = usuarioService;
        this.documentoCVService = documentoCVService;
    }

    @PutMapping("/postulante/{id_postulante}/update/cv")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateDocumentoCVPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                  @RequestPart("documentocv") MultipartFile documentocv) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        /*if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Optional<DocumentoCV> imagen_data = imagenService.BuscarImagen_By_ID(postulante.getImagenUsuario().getIdImagen());

            if (imagen_data.isPresent()) {
                try {
                    Imagen foto_perfil = imagen_data.get();

                    if (!foto.isEmpty()) {
                        foto_perfil.setArchivoImagen(foto.getBytes());
                        foto_perfil.setTipoarchivoImagen(foto.getContentType());

                        imagenService.GuardarImagen(foto_perfil);

                        return new ResponseEntity<>(new MessageResponse("Se ha actualizado su foto de perfil " +
                                "satisfactoriamente"),
                                HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(new MessageResponse("No se ha seleccionado un archivo."),
                                HttpStatus.BAD_REQUEST);
                    }
                } catch (Exception e) {
                    return new ResponseEntity<>(new MessageResponse("No se puede subir el archivo " + e),
                            HttpStatus.EXPECTATION_FAILED);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("No se encontró la información requerida."),
                        HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }*/
        return null;
    }
}
