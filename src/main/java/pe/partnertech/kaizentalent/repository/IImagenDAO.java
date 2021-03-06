/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Imagen;

import java.util.Optional;

@Repository
public interface IImagenDAO extends JpaRepository<Imagen, Long> {

    Optional<Imagen> findByNombreImagen(String nombre_imagen);
}
