/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Habilidad;

import java.util.Set;

@Repository
public interface IHabilidadDAO extends JpaRepository<Habilidad, Long> {

    @Query("SELECT h FROM Habilidad h JOIN Usuario u ON h.usuarioHabilidad.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND h.nombreHabilidad LIKE ?2 AND h.nivelHabilidad LIKE ?3")
    Set<Habilidad> findHabilidadesToValidate(Long id_postulante, String nombre_habilidad, String nivel_habilidad);

    @Query("SELECT h FROM Habilidad h JOIN Usuario u ON h.usuarioHabilidad.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1")
    Set<Habilidad> findHabilidadesByIdPostulante(Long id_postulante);
}
