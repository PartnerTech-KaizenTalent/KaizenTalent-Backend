/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.SkillPostulanteResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IConocimientoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Code_SendData {

    public static DocumentoCVResponse SendDocumentoCV(Long id_postulante, IUsuarioService usuarioService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            DocumentoCVResponse documentocv = new DocumentoCVResponse();

            if (postulante.getDocumentoCVUsuario() == null) {
                documentocv.setNombreDocumentoCV(null);
                documentocv.setUrlDocumentoCV(null);

            } else {
                documentocv.setNombreDocumentoCV(postulante.getDocumentoCVUsuario().getNombreDocumentoCV());
                documentocv.setUrlDocumentoCV(postulante.getDocumentoCVUsuario().getUrlDocumentoCV());

            }
            return documentocv;
        } else {
            return null;
        }
    }

    public static Set<SkillPostulanteResponse> SendConocimientos(Long id_postulante, IUsuarioService usuarioService,
                                                                 IConocimientoService conocimientoService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillPostulanteResponse> list_conocimientos = new HashSet<>();

            if (postulante.getConocimientosUsuario() == null) {
                list_conocimientos.add(null);
            } else {
                conocimientoService.BuscarConocimientos_By_IDPostulante(id_postulante).forEach(
                        conocimiento -> list_conocimientos.add(
                                new SkillPostulanteResponse(
                                        conocimiento.getIdConocimiento(),
                                        conocimiento.getNombreConocimiento(),
                                        conocimiento.getNivelConocimiento()
                                )));
            }

            return list_conocimientos;
        } else {
            return null;
        }
    }
}