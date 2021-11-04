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
import pe.partnertech.kaizentalent.dto.response.PublicacionesEmpleosResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmpleosController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public EmpleosController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @GetMapping("/empleos/publicaciones")
    public ResponseEntity<?> MostrarPublicaciones_Empleos() {

        Set<PublicacionesEmpleosResponse> list_publicaciones = new HashSet<>();

        usuariosPuestosTrabajoService.MostrarPublicaciones().forEach(
                publicaciones -> list_publicaciones.add(
                        new PublicacionesEmpleosResponse(
                                publicaciones.getPuestotrabajo().getIdPuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getNombrePuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getTipojornadaPuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getFecharegistroPuestoTrabajo(),
                                publicaciones.getUsuario().getNombreUsuario(),
                                publicaciones.getUsuario().getDireccionUsuario(),
                                publicaciones.getPuestotrabajo().getCiudadPuestoTrabajo(),
                                publicaciones.getPuestotrabajo().getCategoriaPuestoTrabajo(),
                                DiferenciaPeriodoPublicacion_Horas(publicaciones.getPuestotrabajo().getFecharegistroPuestoTrabajo()),
                                publicaciones.getPuestotrabajo().getExperienciaPuestoTrabajo(),
                                new ImagenResponse(
                                        publicaciones.getUsuario().getImagenUsuario().getNombreImagen(),
                                        publicaciones.getUsuario().getImagenUsuario().getUrlImagen())
                        )));

        return new ResponseEntity<>(list_publicaciones, HttpStatus.OK);
    }

    int DiferenciaPeriodoPublicacion_Horas(LocalDateTime fecha_registro) {

        long horas_transcurridas = fecha_registro.until(LocalDateTime.now(), ChronoUnit.HOURS);

        return Math.toIntExact(horas_transcurridas);
    }
}
