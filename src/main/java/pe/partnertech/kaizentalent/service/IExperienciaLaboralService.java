/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.ExperienciaLaboral;

import java.util.Optional;
import java.util.Set;

public interface IExperienciaLaboralService {

    Set<ExperienciaLaboral> ValidarExperienciasLaborales(Long id_postulante, String nombre_experiencialaboral,
                                                         String empresa_experiencialaboral,
                                                         String mesinicio_experiencialaboral,
                                                         String anioinicio_experiencialaboral,
                                                         String mesfin_experiencialaboral,
                                                         String aniofin_experiencialaboral,
                                                         String descripcion_experiencialaboral,
                                                         String referente_referencialaboral,
                                                         String emailreferente_referencialaboral,
                                                         String telefonoreferente_referencialaboral);

    Set<ExperienciaLaboral> BuscarExperienciasLaborales_By_IDPostulante(Long id_postulante);

    Set<ExperienciaLaboral> BuscarExperienciasLaborales_By_Empresa(String empresa_experiencialaboral);

    Optional<ExperienciaLaboral> BuscarExperienciaLaboral_By_IDExperienciaLaboral(Long id_experiencialaboral);

    void GuardarExperienciaLaboral(ExperienciaLaboral experiencialaboral);

    void EliminarExperienciaLaboral(Long id_experiencialaboral);
}
