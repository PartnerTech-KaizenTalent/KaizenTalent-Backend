/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;
import pe.partnertech.kaizentalent.repository.IUsuariosPuestosTrabajoDAO;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuariosPuestosTrabajoServiceImpl implements IUsuariosPuestosTrabajoService {

    final
    IUsuariosPuestosTrabajoDAO data;

    public UsuariosPuestosTrabajoServiceImpl(IUsuariosPuestosTrabajoDAO data) {
        this.data = data;
    }

    @Override
    public Set<UsuariosPuestosTrabajo> ValidarPublicaciones(Long id_reclutador, String nombre_puestotrabajo,
                                                            String ciudad_puestotrabajo, String categoria_puestotrabajo,
                                                            String modalidad_puestotrabajo, String tipojornada_puestotrabajo,
                                                            String sueldo_puestotrabajo, int experiencia_puestotrabajo,
                                                            int periodoinicio_puestotrabajo, String descripcion_puestotrabajo) {
        return data.findPublicacionesToValidate(id_reclutador, nombre_puestotrabajo, ciudad_puestotrabajo,
                categoria_puestotrabajo, modalidad_puestotrabajo, tipojornada_puestotrabajo, sueldo_puestotrabajo,
                experiencia_puestotrabajo, periodoinicio_puestotrabajo, descripcion_puestotrabajo);
    }

    @Override
    public Set<UsuariosPuestosTrabajo> MostrarPublicaciones() {
        return data.findPublicaciones();
    }

    @Override
    public Set<UsuariosPuestosTrabajo> BuscarPublicaciones_By_TipoJornada(String tipojornada_publicacion) {
        return data.findPublicacionesByTipoJornada(tipojornada_publicacion);
    }

    @Override
    public Set<UsuariosPuestosTrabajo> BuscarPublicaciones_By_IDReclutadorAndEstadoPublicacion(Long id_reclutador,
                                                                                               String estado_publicacion) {
        return data.findPublicacionesByIdReclutadorAndEstadoPublicacion(id_reclutador, estado_publicacion);
    }

    @Override
    public Set<UsuariosPuestosTrabajo> BuscarPostulaciones_By_IDPostulante(Long id_postulante) {
        return data.findPostulacionesByIdPostulante(id_postulante);
    }

    @Override
    public Set<UsuariosPuestosTrabajo> BuscarPostulantes_By_IDPublicacion(Long id_publicacion) {
        return data.findPostulantesByIdPublicacion(id_publicacion);

    }

    @Override
    public Optional<UsuariosPuestosTrabajo> BuscarPublicacion_By_IDPublicacion(Long id_publicacion) {
        return data.findPublicacionByIdPublicacion(id_publicacion);
    }

    @Override
    public Boolean ValidarPostulacion(Usuario postulante, PuestoTrabajo publicacion) {
        return data.existsByUsuarioAndPuestotrabajo(postulante, publicacion);
    }

    @Override
    public void GuardarUsuariosPuestosTrabajo(UsuariosPuestosTrabajo usuariospuestostrabajo) {
        data.save(usuariospuestostrabajo);
    }

    @Override
    public void EliminarUsuariosPuestosTrabajoByPuestoTrabajo(PuestoTrabajo publicacion) {
        data.deleteByPuestotrabajo(publicacion);
    }
}
