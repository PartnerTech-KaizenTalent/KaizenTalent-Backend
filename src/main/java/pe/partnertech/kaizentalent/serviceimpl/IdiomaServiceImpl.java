/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Idioma;
import pe.partnertech.kaizentalent.repository.IIdiomaDAO;
import pe.partnertech.kaizentalent.service.IIdiomaService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class IdiomaServiceImpl implements IIdiomaService {

    final
    IIdiomaDAO data;

    public IdiomaServiceImpl(IIdiomaDAO data) {
        this.data = data;
    }

    @Override
    public Set<Idioma> ValidarIdiomas(Long id_postulante, String nombre_idioma, String nivel_idioma) {
        return data.findIdiomasToValidate(id_postulante, nombre_idioma, nivel_idioma);
    }

    @Override
    public Set<Idioma> BuscarIdiomas_By_IDPostulante(Long id_postulante) {
        return data.findIdiomasByIdPostulante(id_postulante);
    }

    @Override
    public Optional<Idioma> BuscarIdioma_By_IDIdioma(Long id_idioma) {
        return data.findById(id_idioma);
    }

    @Override
    public void GuardarIdioma(Idioma idioma) {
        data.save(idioma);
    }

    @Override
    public void EliminarIdioma(Long id_idioma) {
        data.deleteById(id_idioma);
    }
}
