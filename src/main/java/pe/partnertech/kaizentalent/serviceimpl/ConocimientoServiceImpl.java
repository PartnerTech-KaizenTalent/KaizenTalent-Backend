/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Conocimiento;
import pe.partnertech.kaizentalent.repository.IConocimientoDAO;
import pe.partnertech.kaizentalent.service.IConocimientoService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ConocimientoServiceImpl implements IConocimientoService {

    final
    IConocimientoDAO data;

    public ConocimientoServiceImpl(IConocimientoDAO data) {
        this.data = data;
    }

    @Override
    public Set<Conocimiento> ValidarConocimientos(Long id_postulante, String nombre_conocimiento, String nivel_conocimiento) {
        return data.findConocimientosToValidate(id_postulante, nombre_conocimiento, nivel_conocimiento);
    }

    @Override
    public Set<Conocimiento> BuscarConocimientos_By_IDPostulante(Long id_postulante) {
        return data.findConocimientosByIdPostulante(id_postulante);
    }

    @Override
    public Optional<Conocimiento> BuscarConocimiento_By_IDConocimiento(Long id_conocimiento) {
        return data.findById(id_conocimiento);
    }

    @Override
    public void GuardarConocimiento(Conocimiento conocimiento) {
        data.save(conocimiento);
    }

    @Override
    public void EliminarConocimiento(Long id_conocimiento) {
        data.deleteById(id_conocimiento);
    }
}
