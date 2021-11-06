/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Habilidad;
import pe.partnertech.kaizentalent.repository.IHabilidadDAO;
import pe.partnertech.kaizentalent.service.IHabilidadService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class HabilidadServiceImpl implements IHabilidadService {

    final
    IHabilidadDAO data;

    public HabilidadServiceImpl(IHabilidadDAO data) {
        this.data = data;
    }

    @Override
    public Set<Habilidad> ValidarHabilidades(Long id_postulante, String nombre_habilidad, String nivel_habilidad) {
        return data.findHabilidadesToValidate(id_postulante, nombre_habilidad, nivel_habilidad);
    }

    @Override
    public Set<Habilidad> BuscarHabilidades_By_IDPostulante(Long id_postulante) {
        return data.findHabilidadesByIdPostulante(id_postulante);
    }

    @Override
    public Optional<Habilidad> BuscarHabilidad_By_IDHabilidad(Long id_habilidad) {
        return data.findById(id_habilidad);
    }

    @Override
    public void GuardarHabilidad(Habilidad habilidad) {
        data.save(habilidad);
    }

    @Override
    public void EliminarHabilidad(Long id_habilidad) {
        data.deleteById(id_habilidad);
    }
}
