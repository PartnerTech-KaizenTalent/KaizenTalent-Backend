/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Idioma;

import java.util.Set;

@Repository
public interface IIdiomaDAO extends JpaRepository<Idioma, Long> {

    @Query("SELECT i FROM Idioma i JOIN Usuario u ON i.usuarioIdioma.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND i.nombreIdioma LIKE ?2 AND i.nivelIdioma LIKE ?3")
    Set<Idioma> findIdiomasToValidate(Long id_postulante, String nombre_idioma, String nivel_idioma);

    @Query("SELECT i FROM Idioma i JOIN Usuario u ON i.usuarioIdioma.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1")
    Set<Idioma> findIdiomasByIdPostulante(Long id_postulante);
}
