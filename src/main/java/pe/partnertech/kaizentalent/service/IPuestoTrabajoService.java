/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.PuestoTrabajo;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface IPuestoTrabajoService {

    Set<PuestoTrabajo> MostrarPuestosTrabajo();

    Set<PuestoTrabajo> BuscarPuestosTrabajo_By_Nombre(String nombre_puestotrabajo);

    Set<PuestoTrabajo> BuscarPuestosTrabajo_By_FechaCaducidad(LocalDateTime fechacaducidad_puestotrabajo);

    Optional<PuestoTrabajo> BuscarPuestoTrabajo_By_ID(Long id_puestotrabajo);

    void GuardarPuestoTrabajo(PuestoTrabajo puestotrabajo);

    void EliminarPuestoTrabajo(Long id_puestotrabajo);
}
