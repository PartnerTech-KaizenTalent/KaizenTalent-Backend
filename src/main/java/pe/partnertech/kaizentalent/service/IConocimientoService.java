/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Conocimiento;

import java.util.Optional;
import java.util.Set;

public interface IConocimientoService {

    Set<Conocimiento> ValidarConocimientos(Long id_postulante, String nombre_conocimiento, String nivel_conocimiento);

    Set<Conocimiento> BuscarConocimientos_By_IDPostulante(Long id_postulante);

    Optional<Conocimiento> BuscarConocimiento_By_IDConocimiento(Long id_conocimiento);

    void GuardarConocimiento(Conocimiento conocimiento);

    void EliminarConocimiento(Long id_conocimiento);
}
