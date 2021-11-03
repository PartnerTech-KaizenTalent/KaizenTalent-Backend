/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.enums.RolNombre;
import pe.partnertech.kaizentalent.model.Rol;

import java.util.Optional;

public interface IRolService {

    Optional<Rol> BuscarRol_Nombre(RolNombre rol);
}
