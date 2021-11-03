/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Imagen;

import java.util.Optional;

public interface IImagenService {

    Optional<Imagen> BuscarImagen_By_ID(Long id_imagen);

    Optional<Imagen> BuscarImagen_By_Nombre(String nombre_imagen);

    void GuardarImagen(Imagen imagen);
}
