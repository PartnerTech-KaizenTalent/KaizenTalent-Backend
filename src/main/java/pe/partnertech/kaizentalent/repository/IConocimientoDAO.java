/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Conocimiento;

import java.util.Set;

@Repository
public interface IConocimientoDAO extends JpaRepository<Conocimiento, Long> {

    @Query("SELECT c FROM Conocimiento c JOIN Usuario u ON c.usuarioConocimiento.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND c.nombreConocimiento LIKE ?2 AND c.nivelConocimiento LIKE ?3")
    Set<Conocimiento> findConocimientosToValidate();

    @Query("SELECT c FROM Conocimiento c JOIN Usuario u ON c.usuarioConocimiento.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1")
    Set<Conocimiento> findConocimientosByIdPostulante(Long id_postulante);
}
