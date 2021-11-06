/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Habilidad;

import java.util.Optional;
import java.util.Set;

public interface IHabilidadService {

    Set<Habilidad> ValidarHabilidades(Long id_postulante, String nombre_habilidad, String nivel_habilidad);

    Set<Habilidad> BuscarHabilidades_By_IDPostulante(Long id_postulante);

    Optional<Habilidad> BuscarHabilidad_By_IDHabilidad(Long id_habilidad);

    void GuardarHabilidad(Habilidad habilidad);

    void EliminarHabilidad(Long id_habilidad);
}
