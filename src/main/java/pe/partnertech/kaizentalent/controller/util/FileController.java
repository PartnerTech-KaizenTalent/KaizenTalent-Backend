
/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.DocumentoCV;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.service.IDocumentoCVService;
import pe.partnertech.kaizentalent.service.IImagenService;

import java.util.Optional;

@Controller
@CrossOrigin
public class FileController {

    final
    IImagenService imagenService;

    final
    IDocumentoCVService documentoCVService;

    public FileController(IImagenService imagenService, IDocumentoCVService documentoCVService) {
        this.imagenService = imagenService;
        this.documentoCVService = documentoCVService;
    }

    @GetMapping("/photos/{nombre_archivo}")
    public ResponseEntity<?> DescargarFoto(@PathVariable String nombre_archivo) {

        Optional<Imagen> imagen_data = imagenService.BuscarImagen_By_Nombre(nombre_archivo);

        if (imagen_data.isPresent()) {

            Imagen imagen = imagen_data.get();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; nombre_archivo=\"" +
                            imagen.getNombreImagen() + "\"")
                    .body(imagen.getArchivoImagen());
        } else {
            return new ResponseEntity<>(new MessageResponse("Error al cargar la imagen"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logos/{nombre_archivo}")
    public ResponseEntity<?> DescargarLogo(@PathVariable String nombre_archivo) {

        Optional<Imagen> imagen_data = imagenService.BuscarImagen_By_Nombre(nombre_archivo);

        if (imagen_data.isPresent()) {

            Imagen imagen = imagen_data.get();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; nombre_archivo=\"" +
                            imagen.getNombreImagen() + "\"")
                    .body(imagen.getArchivoImagen());
        } else {
            return new ResponseEntity<>(new MessageResponse("Error al cargar la imagen"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cvfiles/{nombre_archivo}")
    public ResponseEntity<?> DescargarDocumentoCV(@PathVariable String nombre_archivo) {

        Optional<DocumentoCV> documentocv_data = documentoCVService.BuscarDocumentoCV_By_Nombre(nombre_archivo);

        if (documentocv_data.isPresent()) {

            DocumentoCV documentocv = documentocv_data.get();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; nombre_archivo=\"" +
                            documentocv.getNombreDocumentoCV() + "\"")
                    .body(documentocv.getArchivoDocumentoCV());
        } else {
            return new ResponseEntity<>(new MessageResponse("Error al cargar el documento"), HttpStatus.BAD_REQUEST);
        }
    }
}
