/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.ExperienciaLaboral;
import pe.partnertech.kaizentalent.repository.IExperienciaLaboralDAO;
import pe.partnertech.kaizentalent.service.IExperienciaLaboralService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ExperienciaLaboralServiceImpl implements IExperienciaLaboralService {

    final
    IExperienciaLaboralDAO data;

    public ExperienciaLaboralServiceImpl(IExperienciaLaboralDAO data) {
        this.data = data;
    }

    @Override
    public Set<ExperienciaLaboral> ValidarExperienciasLaborales(Long id_postulante, String nombre_experiencialaboral,
                                                                String empresa_experiencialaboral,
                                                                String mesinicio_experiencialaboral,
                                                                String anioinicio_experiencialaboral,
                                                                String mesfin_experiencialaboral,
                                                                String aniofin_experiencialaboral,
                                                                String descripcion_experiencialaboral,
                                                                String referente_referencialaboral,
                                                                String emailreferente_referencialaboral,
                                                                String telefonoreferente_referencialaboral) {

        return data.findExperienciasLaboralesToValidate(id_postulante, nombre_experiencialaboral,
                empresa_experiencialaboral, mesinicio_experiencialaboral, anioinicio_experiencialaboral,
                mesfin_experiencialaboral, aniofin_experiencialaboral, descripcion_experiencialaboral,
                referente_referencialaboral, emailreferente_referencialaboral, telefonoreferente_referencialaboral);
    }

    @Override
    public Set<ExperienciaLaboral> BuscarExperienciasLaborales_By_IDPostulante(Long id_postulante) {

        return data.findExperienciasLaboralesByIdPostulante(id_postulante);
    }

    @Override
    public Set<ExperienciaLaboral> BuscarExperienciasLaborales_By_Empresa(String empresa_experiencialaboral) {
        return data.findByEmpresaExperienciaLaboral(empresa_experiencialaboral);
    }

    @Override
    public Optional<ExperienciaLaboral> BuscarExperienciaLaboral_By_IDExperienciaLaboral(Long id_experiencialaboral) {
        return data.findById(id_experiencialaboral);
    }

    @Override
    public void GuardarExperienciaLaboral(ExperienciaLaboral experiencialaboral) {
        data.save(experiencialaboral);
    }

    @Override
    public void EliminarExperienciaLaboral(Long id_experiencialaboral) {
        data.deleteById(id_experiencialaboral);
    }
}
