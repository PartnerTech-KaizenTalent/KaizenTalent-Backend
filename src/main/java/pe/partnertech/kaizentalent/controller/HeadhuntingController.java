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
import pe.partnertech.kaizentalent.dto.response.headhunting.InstitucionesHeadhuntingResponse;
import pe.partnertech.kaizentalent.dto.response.headhunting.ListHeadHuntingResponse;
import pe.partnertech.kaizentalent.model.Educacion;
import pe.partnertech.kaizentalent.service.IExperienciaLaboralService;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
                                    null,
                                    postulantes.getHabilidadesUsuario(),
                                    null,
                                    postulantes.getIdiomasUsuario(),
                                    null,
                                    postulantes.getFechanacimientoUsuario(),
                                    0
                            ));
                }
        );

        return new ResponseEntity<>(list_headhunting, HttpStatus.OK);
    }

    List<String> SendInstituciones(Set<Educacion> list_educaciones) {

        return list_educaciones.stream()
                .map(Educacion::getInstitucionEducacion)
                .collect(Collectors.toList());
    }
}
