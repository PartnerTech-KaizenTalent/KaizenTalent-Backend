/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface IPuestoTrabajoDAO extends JpaRepository<PuestoTrabajo, Long> {

    @Query("SELECT pt FROM PuestoTrabajo pt")
    Set<PuestoTrabajo> findPuestosTrabajo();

    @Query("SELECT pt FROM PuestoTrabajo pt WHERE pt.fechacaducidadPuestoTrabajo < ?1")
    Set<PuestoTrabajo> findPuestosTrabajoByFechaCaducidad(LocalDateTime fechacaducidad_puestotrabajo);

    Set<PuestoTrabajo> findByNombrePuestoTrabajoContainingIgnoreCaseOrderByNombrePuestoTrabajoDesc(String nombre_puestotrabajo);
}
