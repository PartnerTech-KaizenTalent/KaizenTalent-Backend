/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IUsuariosPuestosTrabajoDAO extends JpaRepository<UsuariosPuestosTrabajo, Long> {

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "JOIN Imagen i ON u.imagenUsuario.idImagen = i.idImagen " +
            "JOIN DocumentoCV dcv ON u.documentoCVUsuario.idDocumentoCV = dcv.idDocumentoCV " +
            "WHERE pt.estadoPuestoTrabajo LIKE 'Activo' " +
            "AND upt.usuario.idUsuario = u.idUsuario " +
            "AND u.tipodocumentoUsuario LIKE 'RUC' " +
            "ORDER BY pt.fecharegistroPuestoTrabajo DESC")
    Set<UsuariosPuestosTrabajo> findPublicaciones();

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "JOIN Imagen i ON u.imagenUsuario.idImagen = i.idImagen " +
            "JOIN DocumentoCV dcv ON u.documentoCVUsuario.idDocumentoCV = dcv.idDocumentoCV " +
            "WHERE pt.estadoPuestoTrabajo LIKE 'Activo' " +
            "AND upt.usuario.idUsuario = u.idUsuario " +
            "AND u.tipodocumentoUsuario LIKE 'RUC' " +
            "AND pt.tipojornadaPuestoTrabajo LIKE ?1" +
            "ORDER BY pt.fecharegistroPuestoTrabajo DESC")
    Set<UsuariosPuestosTrabajo> findPublicacionesByTipoJornada(String tipojornada_publicacion);

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND pt.estadoPuestoTrabajo LIKE ?2 " +
            "ORDER BY pt.fecharegistroPuestoTrabajo DESC")
    Set<UsuariosPuestosTrabajo> findPublicacionesByIdReclutadorAndEstadoPublicacion(Long id_reclutador,
                                                                                    String estado_publicacion);

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "WHERE u.tipodocumentoUsuario LIKE 'RUC' AND pt.idPuestoTrabajo IN " +
            "(SELECT pt.idPuestoTrabajo FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1)")
    Set<UsuariosPuestosTrabajo> findPostulacionesByIdPostulante(Long id_postulante);

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "JOIN Imagen i ON u.imagenUsuario.idImagen = i.idImagen " +
            "JOIN DocumentoCV dcv ON u.documentoCVUsuario.idDocumentoCV = dcv.idDocumentoCV " +
            "WHERE u.tipodocumentoUsuario NOT LIKE 'RUC' AND pt.idPuestoTrabajo = ?1")
    Set<UsuariosPuestosTrabajo> findPostulantesByIdPublicacion(Long id_publicacion);

    @Query("SELECT upt FROM UsuariosPuestosTrabajo upt " +
            "JOIN PuestoTrabajo pt ON upt.puestotrabajo.idPuestoTrabajo = pt.idPuestoTrabajo " +
            "JOIN Usuario u ON upt.usuario.idUsuario = u.idUsuario " +
            "JOIN Imagen i ON u.imagenUsuario.idImagen = i.idImagen " +
            "JOIN DocumentoCV dcv ON u.documentoCVUsuario.idDocumentoCV = dcv.idDocumentoCV " +
            "WHERE pt.idPuestoTrabajo = ?1 AND u.tipodocumentoUsuario LIKE 'RUC'")
    Optional<UsuariosPuestosTrabajo> findPublicacionByIdPublicacion(Long id_publicacion);

    boolean existsByUsuarioAndPuestotrabajo(Usuario postulante, PuestoTrabajo publicacion);
}
