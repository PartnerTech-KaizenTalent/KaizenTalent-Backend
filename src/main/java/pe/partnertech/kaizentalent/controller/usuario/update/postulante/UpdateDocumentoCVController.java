/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.usuario.update.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.DocumentoCV;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IDocumentoCVService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

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
                                                         @RequestPart("cv") MultipartFile cv) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            if (postulante.getDocumentoCVUsuario() == null) {
                try {
                    String separador_cv = Pattern.quote(".");
                    String[] formato_cv = Objects.requireNonNull(cv.getOriginalFilename()).split(separador_cv);
                    String nombre_cv = UUID.randomUUID() + postulante.getIdUsuario().toString() +
                            UUID.randomUUID() + "." + formato_cv[formato_cv.length - 1];

                    String url_cv = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/cvfiles/")
                            .path(nombre_cv)
                            .toUriString();

                    DocumentoCV documento_cv = new DocumentoCV(
                            nombre_cv,
                            cv.getContentType(),
                            url_cv,
                            cv.getBytes(),
                            LocalDateTime.now(),
                            postulante
                    );
                    documentoCVService.GuardarDocumentoCV(documento_cv);

                    return new ResponseEntity<>(new MessageResponse("Se ha actualizado su documento cv satisfactoriamente."),
                            HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(new MessageResponse("No se puede subir el archivo " + e),
                            HttpStatus.EXPECTATION_FAILED);
                }
            } else {
                Optional<DocumentoCV> documentocv_data =
                        documentoCVService.BuscarDocumentoCV_By_ID(postulante.getDocumentoCVUsuario().getIdDocumentoCV());

                if (documentocv_data.isPresent()) {
                    try {
                        DocumentoCV documentocv = documentocv_data.get();

                        if (!cv.isEmpty()) {
                            documentocv.setArchivoDocumentoCV(cv.getBytes());
                            documentocv.setTipoarchivoDocumentoCV(cv.getContentType());
                            documentocv.setFechasubidaDocumentoCV(LocalDateTime.now());

                            documentoCVService.GuardarDocumentoCV(documentocv);

                            return new ResponseEntity<>(new MessageResponse("Se ha actualizado su documento cv " +
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
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información del usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }
}







