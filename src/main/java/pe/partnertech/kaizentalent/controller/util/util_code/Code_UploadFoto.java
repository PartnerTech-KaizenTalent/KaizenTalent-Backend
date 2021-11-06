/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.partnertech.kaizentalent.model.ExperienciaLaboral;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IImagenService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

public class Code_UploadFoto {

    public static void AssignImagenToUser(Usuario usuario, InputStream fotoStream, IImagenService imagenService, String path)
            throws IOException {

        String nombre_imagen = UUID.randomUUID() + usuario.getIdUsuario().toString() + UUID.randomUUID()
                + ".png";

        String url_imagen = SendImageUrl(path, nombre_imagen);

        assert fotoStream != null;
        byte[] file_imagen = IOUtils.toByteArray(fotoStream);

        Imagen imagen = new Imagen(
                nombre_imagen,
                "image/png",
                url_imagen,
                file_imagen,
                usuario
        );

        imagenService.GuardarImagen(imagen);
    }

    public static void AssignImagenToExperienciaLaboral(ExperienciaLaboral experiencialaboral, IUsuarioService usuarioService,
                                                        InputStream fotoStream, IImagenService imagenService, String path)
            throws IOException {

        String nombre_imagen = UUID.randomUUID() + "" + UUID.randomUUID() + ".png";
        String url_imagen = SendImageUrl(path, nombre_imagen);

        //Buscando Empresa para asignar su logo
        Optional<Usuario> empresa_data =
                usuarioService.BuscarUsuario_By_NombreUsuario(experiencialaboral.getEmpresaExperienciaLaboral());

        if (empresa_data.isPresent()) {
            Usuario empresa = empresa_data.get();

            Optional<Imagen> logoempresa_data = imagenService.BuscarImagen_By_ID(empresa.getImagenUsuario().getIdImagen());

            if (logoempresa_data.isPresent()) {
                Imagen logo_empresa = logoempresa_data.get();

                Imagen imagen = new Imagen(
                        nombre_imagen,
                        logo_empresa.getTipoarchivoImagen(),
                        url_imagen,
                        logo_empresa.getArchivoImagen(),
                        experiencialaboral
                );
                imagenService.GuardarImagen(imagen);
            }
        } else {
            assert fotoStream != null;
            byte[] file_imagen = IOUtils.toByteArray(fotoStream);

            Imagen imagen = new Imagen(
                    nombre_imagen,
                    "image/png",
                    url_imagen,
                    file_imagen,
                    experiencialaboral
            );

            imagenService.GuardarImagen(imagen);
        }
    }

    public static String SendImageUrl(String path, String nombre_imagen) {

        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(path)
                .path(nombre_imagen)
                .toUriString();
    }
}
