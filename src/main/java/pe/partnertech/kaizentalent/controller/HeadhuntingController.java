/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.headhunting.ListHeadHuntingResponse;
import pe.partnertech.kaizentalent.model.Conocimiento;
import pe.partnertech.kaizentalent.model.Educacion;
import pe.partnertech.kaizentalent.model.Habilidad;
import pe.partnertech.kaizentalent.model.Idioma;
import pe.partnertech.kaizentalent.service.IExperienciaLaboralService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeadhuntingController {

    final
    IUsuarioService usuarioService;

    final
    IExperienciaLaboralService experienciaLaboralService;

    public HeadhuntingController(IUsuarioService usuarioService, IExperienciaLaboralService experienciaLaboralService) {
        this.usuarioService = usuarioService;
        this.experienciaLaboralService = experienciaLaboralService;
    }

    @GetMapping("/headhunting/display")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> Headhunting() {

        Set<ListHeadHuntingResponse> list_headhunting = new HashSet<>();

        usuarioService.MostrarPostulantes().forEach(
                postulantes -> {
                    list_headhunting.add(
                            new ListHeadHuntingResponse(
                                    postulantes.getIdUsuario(),
                                    new ImagenResponse(
                                            postulantes.getImagenUsuario().getNombreImagen(),
                                            postulantes.getImagenUsuario().getUrlImagen()
                                    ),
                                    postulantes.getSueldoUsuario(),
                                    postulantes.getNombreUsuario() + " " + postulantes.getApellidoUsuario(),
                                    postulantes.getTituloUsuario(),
                                    postulantes.getTelefonoUsuario(),
                                    postulantes.getCiudadUsuario(),
                                    postulantes.getEducacionesUsuario(),
                                    SendInstituciones(postulantes.getEducacionesUsuario()),
                                    postulantes.getConocimientosUsuario(),
                                    SendConocimientos(postulantes.getConocimientosUsuario()),
                                    postulantes.getHabilidadesUsuario(),
                                    SendHabilidades(postulantes.getHabilidadesUsuario()),
                                    postulantes.getIdiomasUsuario(),
                                    SendIdiomas(postulantes.getIdiomasUsuario()),
                                    postulantes.getFechanacimientoUsuario(),
                                    0
                            ));
                }
        );

        return new ResponseEntity<>(list_headhunting, HttpStatus.OK);
    }

    String SendInstituciones(Set<Educacion> list_educaciones) {

        if (list_educaciones.size() == 0) {
            return null;
        } else {
            Set<String> instituciones = list_educaciones.stream()
                    .map(Educacion::getInstitucionEducacion)
                    .collect(Collectors.toSet());

            return String.join(", ", instituciones);
        }
    }

    String SendConocimientos(Set<Conocimiento> list_conocimientos) {

        if (list_conocimientos.size() == 0) {
            return null;
        } else {
            Set<String> conocimientos = list_conocimientos.stream()
                    .map(Conocimiento::getNombreConocimiento)
                    .collect(Collectors.toSet());

            return String.join(", ", conocimientos);
        }
    }

    String SendHabilidades(Set<Habilidad> list_habilidades) {

        if (list_habilidades.size() == 0) {
            return null;
        } else {
            Set<String> habilidades = list_habilidades.stream()
                    .map(Habilidad::getNombreHabilidad)
                    .collect(Collectors.toSet());

            return String.join(", ", habilidades);
        }
    }

    String SendIdiomas(Set<Idioma> list_idiomas) {

        if (list_idiomas.size() == 0) {
            return null;
        } else {
            Set<String> idiomas = list_idiomas.stream()
                    .map(Idioma::getNombreIdioma)
                    .collect(Collectors.toSet());

            return String.join(", ", idiomas);
        }
    }
}
