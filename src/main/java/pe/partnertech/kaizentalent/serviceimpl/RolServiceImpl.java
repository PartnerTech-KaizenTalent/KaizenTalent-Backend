/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.enums.RolNombre;
import pe.partnertech.kaizentalent.model.Rol;
import pe.partnertech.kaizentalent.repository.IRolDAO;
import pe.partnertech.kaizentalent.service.IRolService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolServiceImpl implements IRolService {

    final
    IRolDAO data;

    public RolServiceImpl(IRolDAO data) {
        this.data = data;
    }

    @Override
    public Optional<Rol> BuscarRol_Nombre(RolNombre rol) {
        return data.findByNombreRol(rol);
    }
}
