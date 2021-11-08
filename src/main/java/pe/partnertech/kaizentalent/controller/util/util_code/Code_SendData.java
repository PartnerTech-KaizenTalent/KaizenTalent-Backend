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

    public static Set<SkillPostulanteResponse> SendIdiomas(Long id_postulante, IUsuarioService usuarioService,
                                                           IIdiomaService idiomaService) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillPostulanteResponse> list_idiomas = new HashSet<>();

            if (postulante.getIdiomasUsuario() == null) {
                list_idiomas.add(null);
            } else {
                idiomaService.BuscarIdiomas_By_IDPostulante(id_postulante).forEach(
                        idiomas -> list_idiomas.add(
                                new SkillPostulanteResponse(
                                        idiomas.getIdIdioma(),
                                        idiomas.getNombreIdioma(),
                                        idiomas.getNivelIdioma()
                                )));
            }

            return list_idiomas;
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
                        educaciones -> {
                            if (educaciones.getMesfinEducacion().equals("") && educaciones.getAniofinEducacion().equals("")) {
                                list_educaciones.add(
                                        new EducacionPostulanteResponse(
                                                educaciones.getIdEducacion(),
                                                educaciones.getInstitucionEducacion(),
                                                ConvierteMes(educaciones.getMesinicioEducacion()) + " " + educaciones.getAnioinicioEducacion(),
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
                                                ConvierteMes(educaciones.getMesinicioEducacion()) + " " + educaciones.getAnioinicioEducacion(),
                                                ConvierteMes(educaciones.getMesfinEducacion()) + " " + educaciones.getAniofinEducacion(),
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
                        experienciaslaborales -> {
                            if (experienciaslaborales.getMesfinExperienciaLaboral().equals("") &&
                                    experienciaslaborales.getAniofinExperienciaLaboral().equals("")) {
                                list_experienciaslaborales.add(
                                        new ExperienciaLaboralPostulanteResponse(
                                                experienciaslaborales.getIdExperienciaLaboral(),
                                                experienciaslaborales.getEmpresaExperienciaLaboral(),
                                                ConvierteMes(experienciaslaborales.getMesinicioExperienciaLaboral()) + " " +
                                                        experienciaslaborales.getAnioinicioExperienciaLaboral(),
                                                "En Curso",
                                                experienciaslaborales.getNombreExperienciaLaboral(),
                                                new ImagenResponse(
                                                        experienciaslaborales.getImagenExperienciaLaboral().getNombreImagen(),
                                                        experienciaslaborales.getImagenExperienciaLaboral().getUrlImagen()
                                                ),
                                                experienciaslaborales.getDescripcionExperienciaLaboral(),
                                                experienciaslaborales.getReferenteReferenciaLaboral(),
                                                experienciaslaborales.getEmailreferenteReferenciaLaboral(),
                                                experienciaslaborales.getTelefonoreferenteReferenciaLaboral()
                                        ));
                            } else {
                                list_experienciaslaborales.add(
                                        new ExperienciaLaboralPostulanteResponse(
                                                experienciaslaborales.getIdExperienciaLaboral(),
                                                experienciaslaborales.getEmpresaExperienciaLaboral(),
                                                ConvierteMes(experienciaslaborales.getMesinicioExperienciaLaboral()) + " " +
                                                        experienciaslaborales.getAnioinicioExperienciaLaboral(),
                                                ConvierteMes(experienciaslaborales.getMesfinExperienciaLaboral()) + " " +
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
                                        ));
                            }
                        }
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
                                                ConvierteMes(referenciaslaborales.getMesinicioExperienciaLaboral()) + " " +
                                                        referenciaslaborales.getAnioinicioExperienciaLaboral(),
                                                new ImagenResponse(referenciaslaborales.getImagenExperienciaLaboral().getNombreImagen(),
                                                        referenciaslaborales.getImagenExperienciaLaboral().getUrlImagen())
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

    private static String ConvierteMes(String valor_mes) {

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