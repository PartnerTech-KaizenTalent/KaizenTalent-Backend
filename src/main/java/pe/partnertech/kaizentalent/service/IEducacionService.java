/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Educacion;

import java.util.Optional;
import java.util.Set;

public interface IEducacionService {

    Set<Educacion> ValidarEducaciones(Long id_postulante, String institucion_educacion, String mesinicio_educacion,
                                      String anioinicio_educacion, String mesfin_educacion, String aniofin_educacion,
                                      String nombre_educacion, String nivel_educacion, String estado_educacion);

    Set<Educacion> BuscarEducaciones_By_IDPostulante(Long id_postulante);

    Optional<Educacion> BuscarEducacion_By_IDEducacion(Long id_educacion);

    void GuardarEducacion(Educacion educacion);

    void EliminarEducacion(Long id_educacion);
}
