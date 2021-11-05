/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Educacion;

import java.util.Set;

@Repository
public interface IEducacionDAO extends JpaRepository<Educacion, Long> {

    @Query("SELECT e FROM Educacion e JOIN Usuario u ON e.usuarioEducacion.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND " +
            "e.institucionEducacion LIKE ?2 AND " +
            "e.mesinicioEducacion LIKE ?3 AND " +
            "e.anioinicioEducacion LIKE ?4 AND " +
            "e.mesfinEducacion LIKE ?5 AND " +
            "e.aniofinEducacion LIKE ?6 AND " +
            "e.nombreEducacion LIKE ?7 AND " +
            "e.nivelEducacion LIKE ?8 AND " +
            "e.estadoEducacion LIKE ?9")
    Set<Educacion> findEducacionesToValidate(Long id_postulante, String institucion_educacion, String mesinicio_educacion,
                                             String anioinicio_educacion, String mesfin_educacion, String aniofin_educacion,
                                             String nombre_educacion, String nivel_educacion, String estado_educacion);

    @Query("SELECT e FROM Educacion e JOIN Usuario u ON e.usuarioEducacion.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1")
    Set<Educacion> findEducacionesByIdPostulante(Long id_postulante);
}