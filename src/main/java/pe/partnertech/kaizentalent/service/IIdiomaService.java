/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Idioma;

import java.util.Optional;
import java.util.Set;

public interface IIdiomaService {

    Set<Idioma> ValidarIdiomas(Long id_postulante, String nombre_idioma, String nivel_idioma);

    Set<Idioma> BuscarIdiomas_By_IDPostulante(Long id_postulante);

    Optional<Idioma> BuscarIdioma_By_IDIdioma(Long id_idioma);

    void GuardarIdioma(Idioma idioma);

    void EliminarIdioma(Long id_idioma);
}
