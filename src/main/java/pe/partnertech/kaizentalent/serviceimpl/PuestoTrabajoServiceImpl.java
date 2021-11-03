/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.repository.IPuestoTrabajoDAO;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PuestoTrabajoServiceImpl implements IPuestoTrabajoService {

    final
    IPuestoTrabajoDAO data;

    public PuestoTrabajoServiceImpl(IPuestoTrabajoDAO data) {
        this.data = data;
    }

    @Override
    public Set<PuestoTrabajo> MostrarPuestosTrabajo() {
        return data.findPuestosTrabajo();
    }

    @Override
    public Set<PuestoTrabajo> BuscarPuestosTrabajo_By_Nombre(String nombre_puestotrabajo) {
        return data.findByNombrePuestoTrabajoContainingIgnoreCaseOrderByNombrePuestoTrabajoDesc(nombre_puestotrabajo);
    }

    @Override
    public Set<PuestoTrabajo> BuscarPuestosTrabajo_By_FechaCaducidad(LocalDateTime fechacaducidad_puestotrabajo) {
        return data.findPuestosTrabajoByFechaCaducidad(fechacaducidad_puestotrabajo);
    }

    @Override
    public Optional<PuestoTrabajo> BuscarPuestoTrabajo_By_ID(Long id_puestotrabajo) {
        return data.findById(id_puestotrabajo);
    }

    @Override
    public void GuardarPuestoTrabajo(PuestoTrabajo puestotrabajo) {
        data.save(puestotrabajo);
    }

    @Override
    public void EliminarPuestoTrabajo(Long id_puestotrabajo) {
        data.deleteById(id_puestotrabajo);
    }
}
