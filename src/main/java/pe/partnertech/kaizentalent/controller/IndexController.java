/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_Format;
import pe.partnertech.kaizentalent.dto.response.PublicacionesIndexResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class IndexController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public IndexController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @GetMapping("/index/publicaciones")
    public ResponseEntity<?> MostrarPublicaciones_Index() {

        Set<PublicacionesIndexResponse> list_publicaciones = new HashSet<>();

        usuariosPuestosTrabajoService.MostrarPublicaciones().forEach(
                publicaciones -> list_publicaciones.add(
                        new PublicacionesIndexResponse(
                                publicaciones.getPuestotrabajo().getIdPuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getNombrePuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getCiudadPuestoTrabajo(),
                                FormatSueldo(publicaciones.getPuestotrabajo().getSueldoPuestoTrabajo()),
                                publicaciones.getPuestotrabajo().getTipojornadaPuestoTrabajo(),
                                Code_Format.FormatExperienciaLaboral(publicaciones.getPuestotrabajo().getExperienciaPuestoTrabajo()),
                                publicaciones.getUsuario().getNombreUsuario(),
                                publicaciones.getPuestotrabajo().getModalidadPuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getFecharegistroPuestoTrabajo(),
                                new ImagenResponse(
                                        publicaciones.getUsuario().getImagenUsuario().getNombreImagen(),
                                        publicaciones.getUsuario().getImagenUsuario().getUrlImagen())
                        )));

        return new ResponseEntity<>(list_publicaciones, HttpStatus.OK);
    }

    String FormatSueldo(String sueldo) {
        String new_sueldo;

        if (sueldo.equals("")) {
            new_sueldo = "-";
        } else {
            new_sueldo = sueldo + ".00";
        }

        return new_sueldo;
    }
}
