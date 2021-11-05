/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.EducacionPostulanteResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.SkillPostulanteResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IConocimientoService;
import pe.partnertech.kaizentalent.service.IEducacionService;
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

    public static Set<EducacionPostulanteResponse> SendEducaciones(Long id_postulante, IUsuarioService usuarioService,
                                                                   IEducacionService educacionService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<EducacionPostulanteResponse> list_educaciones = new HashSet<>();

            if (postulante.getEducacionesUsuario() == null) {
                list_educaciones.add(null);
            } else {
                educacionService.BuscarEducaciones_By_IDPostulante(id_postulante).forEach(
                        educaciones -> {
                            if (educaciones.getMesfinEducacion().equals("") && educaciones.getAniofinEducacion().equals("")) {
                                list_educaciones.add(
                                        new EducacionPostulanteResponse(
                                                educaciones.getIdEducacion(),
                                                educaciones.getInstitucionEducacion(),
                                                ConvierteMes(educaciones.getMesinicioEducacion()) +
                                                        " " + educaciones.getAnioinicioEducacion(),
                                                "En Curso",
                                                educaciones.getNombreEducacion(),
                                                educaciones.getNivelEducacion(),
                                                educaciones.getEstadoEducacion()

                                        ));
                            } else {
                                list_educaciones.add(
                                        new EducacionPostulanteResponse(
                                                educaciones.getIdEducacion(),
                                                educaciones.getInstitucionEducacion(),
                                                ConvierteMes(educaciones.getMesinicioEducacion()) +
                                                        " " + educaciones.getAnioinicioEducacion(),
                                                ConvierteMes(educaciones.getMesfinEducacion()) +
                                                        " " + educaciones.getAniofinEducacion(),
                                                educaciones.getNombreEducacion(),
                                                educaciones.getNivelEducacion(),
                                                educaciones.getEstadoEducacion()

                                        ));
                            }
                        }
                );
            }

            return list_educaciones;
        } else {
            return null;
        }
    }

    static String ConvierteMes(String valor_mes) {

        String mes_formateado;

        switch (valor_mes) {
            case "1":
            case "01":
                mes_formateado = "Enero";
                break;
            case "2":
            case "02":
                mes_formateado = "Febrero";
                break;
            case "3":
            case "03":
                mes_formateado = "Marzo";
                break;
            case "4":
            case "04":
                mes_formateado = "Abril";
                break;
            case "5":
            case "05":
                mes_formateado = "Mayo";
                break;
            case "6":
            case "06":
                mes_formateado = "Junio";
                break;
            case "7":
            case "07":
                mes_formateado = "Julio";
                break;
            case "8":
            case "08":
                mes_formateado = "Agosto";
                break;
            case "9":
            case "09":
                mes_formateado = "Septiembre";
                break;
            case "10":
                mes_formateado = "Octubre";
                break;
            case "11":
                mes_formateado = "Noviembre";
                break;
            case "12":
                mes_formateado = "Diciembre";
                break;
            default:
                mes_formateado = "";
                break;
        }

        return mes_formateado;
    }
}