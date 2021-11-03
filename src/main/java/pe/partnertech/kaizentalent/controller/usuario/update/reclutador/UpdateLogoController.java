/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.update.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IImagenService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UpdateLogoController {

    final
    IUsuarioService usuarioService;

    final
    IImagenService imagenService;

    public UpdateLogoController(IUsuarioService usuarioService, IImagenService imagenService) {
        this.usuarioService = usuarioService;
        this.imagenService = imagenService;
    }

    @PutMapping("/reclutador/{id_reclutador}/update/logo")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> UpdateLogoReclutador(@PathVariable("id_reclutador") Long id_reclutador,
                                                  @RequestPart("logo") MultipartFile logo) {

        Optional<Usuario> reclutador_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (reclutador_data.isPresent()) {
            Usuario reclutador = reclutador_data.get();

            Optional<Imagen> imagen_data = imagenService.BuscarImagen_By_ID(reclutador.getImagenUsuario().getIdImagen());

            if (imagen_data.isPresent()) {
                try {
                    Imagen logo_empresa = imagen_data.get();

                    if (!logo.isEmpty()) {
                        logo_empresa.setArchivoImagen(logo.getBytes());
                        logo_empresa.setTipoarchivoImagen(logo.getContentType());

                        imagenService.GuardarImagen(logo_empresa);

                        return new ResponseEntity<>(new MessageResponse("Se ha actualizado su logo de empresa " +
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
    }
}
