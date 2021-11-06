/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.EducacionPostulanteResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.ExperienciaLaboralPostulanteResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.ReferenciaLaboralPostulanteResponse;
import pe.partnertech.kaizentalent.dto.response.profile.postulante.SkillPostulanteResponse;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.*;

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

    public static Set<SkillPostulanteResponse> SendHabilidades(Long id_postulante, IUsuarioService usuarioService,
                                                               IHabilidadService habilidadService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillPostulanteResponse> list_habilidades = new HashSet<>();

            if (postulante.getHabilidadesUsuario() == null) {
                list_habilidades.add(null);
            } else {
                habilidadService.BuscarHabilidades_By_IDPostulante(id_postulante).forEach(
                        habilidades -> list_habilidades.add(
                                new SkillPostulanteResponse(
                                        habilidades.getIdHabilidad(),
                                        habilidades.getNombreHabilidad(),
                                        habilidades.getNivelHabilidad()
                                )));
            }

            return list_habilidades;
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
                return null;
            } else {
                educacionService.BuscarEducaciones_By_IDPostulante(id_postulante).forEach(
                        educaciones -> list_educaciones.add(
                                new EducacionPostulanteResponse(
                                        educaciones.getIdEducacion(),
                                        educaciones.getInstitucionEducacion(),
                                        educaciones.getMesinicioEducacion(),
                                        educaciones.getAnioinicioEducacion(),
                                        educaciones.getMesfinEducacion(),
                                        educaciones.getAniofinEducacion(),
                                        educaciones.getNombreEducacion(),
                                        educaciones.getNivelEducacion(),
                                        educaciones.getEstadoEducacion()
                                ))
                );
            }

            return list_educaciones;
        } else {
            return null;
        }
    }

    public static Set<ExperienciaLaboralPostulanteResponse> SendExperienciasLaborales(Long id_postulante,
                                                                                      IUsuarioService usuarioService,
                                                                                      IExperienciaLaboralService experienciaLaboralService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<ExperienciaLaboralPostulanteResponse> list_experienciaslaborales = new HashSet<>();

            if (postulante.getExperienciaslaboralesUsuario() == null) {
                return null;
            } else {
                experienciaLaboralService.BuscarExperienciasLaborales_By_IDPostulante(id_postulante).forEach(
                        experienciaslaborales -> list_experienciaslaborales.add(
                                new ExperienciaLaboralPostulanteResponse(
                                        experienciaslaborales.getIdExperienciaLaboral(),
                                        experienciaslaborales.getEmpresaExperienciaLaboral(),
                                        experienciaslaborales.getMesinicioExperienciaLaboral(),
                                        experienciaslaborales.getAnioinicioExperienciaLaboral(),
                                        experienciaslaborales.getMesfinExperienciaLaboral(),
                                        experienciaslaborales.getAniofinExperienciaLaboral(),
                                        experienciaslaborales.getNombreExperienciaLaboral(),
                                        new ImagenResponse(
                                                experienciaslaborales.getImagenExperienciaLaboral().getNombreImagen(),
                                                experienciaslaborales.getImagenExperienciaLaboral().getUrlImagen()
                                        ),
                                        experienciaslaborales.getDescripcionExperienciaLaboral(),
                                        experienciaslaborales.getReferenteReferenciaLaboral(),
                                        experienciaslaborales.getEmailreferenteReferenciaLaboral(),
                                        experienciaslaborales.getTelefonoreferenteReferenciaLaboral()
                                ))
                );
            }

            return list_experienciaslaborales;
        } else {
            return null;
        }
    }

    public static Set<ReferenciaLaboralPostulanteResponse> SendReferenciasLaborales(Long id_postulante,
                                                                                    IUsuarioService usuarioService,
                                                                                    IExperienciaLaboralService experienciaLaboralService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<ReferenciaLaboralPostulanteResponse> list_referenciaslaborales = new HashSet<>();

            if (postulante.getExperienciaslaboralesUsuario() == null) {
                return null;
            } else {
                experienciaLaboralService.BuscarExperienciasLaborales_By_IDPostulante(id_postulante).forEach(
                        referenciaslaborales -> {
                            if (!referenciaslaborales.getReferenteReferenciaLaboral().equals("") ||
                                    !referenciaslaborales.getEmailreferenteReferenciaLaboral().equals("") ||
                                    !referenciaslaborales.getTelefonoreferenteReferenciaLaboral().equals("")) {
                                list_referenciaslaborales.add(
                                        new ReferenciaLaboralPostulanteResponse(
                                                referenciaslaborales.getEmpresaExperienciaLaboral(),
                                                referenciaslaborales.getReferenteReferenciaLaboral(),
                                                referenciaslaborales.getEmailreferenteReferenciaLaboral(),
                                                referenciaslaborales.getTelefonoreferenteReferenciaLaboral(),
                                                referenciaslaborales.getMesinicioExperienciaLaboral(),
                                                referenciaslaborales.getAnioinicioExperienciaLaboral(),
                                                new ImagenResponse(referenciaslaborales.getImagenExperienciaLaboral().getNombreImagen(),
                                                        referenciaslaborales.getImagenExperienciaLaboral().getUrlImagen()),
                                                ConvierteMes(referenciaslaborales.getMesinicioExperienciaLaboral())
                                        ));
                            } else {
                                list_referenciaslaborales.add(null);
                            }
                        }
                );
            }

            return list_referenciaslaborales;
        } else {
            return null;
        }
    }

    private static String ConvierteMes(String mestoconvert) {

        String mesformateado;

        switch (mestoconvert) {
            case "1":
                mesformateado = "Enero";
                break;
            case "2":
                mesformateado = "Febrero";
                break;
            case "3":
                mesformateado = "Marzo";
                break;
            case "4":
                mesformateado = "Abril";
                break;
            case "5":
                mesformateado = "Mayo";
                break;
            case "6":
                mesformateado = "Junio";
                break;
            case "7":
                mesformateado = "Julio";
                break;
            case "8":
                mesformateado = "Agosto";
                break;
            case "9":
                mesformateado = "Septiembre";
                break;
            case "01":
                mesformateado = "Enero";
                break;
            case "02":
                mesformateado = "Febrero";
                break;
            case "03":
                mesformateado = "Marzo";
                break;
            case "04":
                mesformateado = "Abril";
                break;
            case "05":
                mesformateado = "Mayo";
                break;
            case "06":
                mesformateado = "Junio";
                break;
            case "07":
                mesformateado = "Julio";
                break;
            case "08":
                mesformateado = "Agosto";
                break;
            case "09":
                mesformateado = "Septiembre";
                break;
            case "10":
                mesformateado = "Octubre";
                break;
            case "11":
                mesformateado = "Noviembre";
                break;
            case "12":
                mesformateado = "Diciembre";
                break;
            default:
                mesformateado = "";
                break;
        }

        return mesformateado;
    }
}