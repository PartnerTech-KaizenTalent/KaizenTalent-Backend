/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IImagenService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Code_UploadFoto {

    public static void AssignImagen(Usuario usuario, InputStream fotoStream, IImagenService imagenService, String path)
            throws IOException {

        String nombre_foto = UUID.randomUUID() + usuario.getIdUsuario().toString() + UUID.randomUUID()
                + ".png";

        String url_foto = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .path(nombre_foto)
                .toUriString();

        assert fotoStream != null;
        byte[] file_foto = IOUtils.toByteArray(fotoStream);

        Imagen imagen = new Imagen(
                nombre_foto,
                "image/png",
                url_foto,
                file_foto,
                usuario
        );

        imagenService.GuardarImagen(imagen);
    }
}
