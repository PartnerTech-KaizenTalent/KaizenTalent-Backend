/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;

import java.util.Optional;
import java.util.Set;

public interface IUsuariosPuestosTrabajoService {

    Set<UsuariosPuestosTrabajo> MostrarPublicaciones();

    Set<UsuariosPuestosTrabajo> BuscarPublicaciones_By_TipoJornada(String tipojornada_publicacion);

    Set<UsuariosPuestosTrabajo> BuscarPublicaciones_By_IDReclutadorAndEstadoPublicacion(Long id_reclutador,
                                                                                        String estado_publicacion);

    Set<UsuariosPuestosTrabajo> BuscarPostulaciones_By_IDPostulante(Long id_postulante);

    Set<UsuariosPuestosTrabajo> BuscarPostulantes_By_IDPublicacion(Long id_publicacion);

    Optional<UsuariosPuestosTrabajo> BuscarPublicacion_By_IDPublicacion(Long id_publicacion);

    Boolean ValidarPostulacion(Usuario postulante, PuestoTrabajo publicacion);

    void GuardarUsuariosPuestosTrabajo(UsuariosPuestosTrabajo usuariospuestostrabajo);

    void EliminarUsuariosPuestosTrabajo(Long id_usuariospuestostrabajo);
}
