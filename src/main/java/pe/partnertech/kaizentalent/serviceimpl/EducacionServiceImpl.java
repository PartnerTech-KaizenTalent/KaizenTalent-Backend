/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Educacion;
import pe.partnertech.kaizentalent.repository.IEducacionDAO;
import pe.partnertech.kaizentalent.service.IEducacionService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class EducacionServiceImpl implements IEducacionService {

    final
    IEducacionDAO data;

    public EducacionServiceImpl(IEducacionDAO data) {
        this.data = data;
    }

    @Override
    public Set<Educacion> ValidarEducaciones(Long id_postulante, String institucion_educacion, String mesinicio_educacion,
                                             String anioinicio_educacion, String mesfin_educacion, String aniofin_educacion,
                                             String nombre_educacion, String nivel_educacion, String estado_educacion) {
        return data.findEducacionesToValidate(id_postulante, institucion_educacion, mesinicio_educacion, anioinicio_educacion,
                mesfin_educacion, aniofin_educacion, nombre_educacion, nivel_educacion, estado_educacion);
    }

    @Override
    public Set<Educacion> BuscarEducaciones_By_IDPostulante(Long id_postulante) {
        return data.findEducacionesByIdPostulante(id_postulante);
    }

    @Override
    public Optional<Educacion> BuscarEducacion_By_IDEducacion(Long id_educacion) {
        return data.findById(id_educacion);
    }

    @Override
    public void GuardarEducacion(Educacion educacion) {
        data.save(educacion);
    }

    @Override
    public void EliminarEducacion(Long id_educacion) {
        data.deleteById(id_educacion);
    }
}
