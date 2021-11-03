/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.enums.RolNombre;
import pe.partnertech.kaizentalent.model.Rol;

import java.util.Optional;

@Repository
public interface IRolDAO extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreRol(RolNombre rol);
}
