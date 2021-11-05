/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_Format;
import pe.partnertech.kaizentalent.dto.response.DetailPuestoTrabajoResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DetailPublicacionController {

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    final
    IUsuarioService usuarioService;


    public DetailPublicacionController(IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService,
                                       IUsuarioService usuarioService) {
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/publicacion/{id_publicacion}/detail")
    ResponseEntity<?> FindDetailPuestoTrabajo(@PathVariable("id_publicacion") Long id_publicacion) {

        Optional<UsuariosPuestosTrabajo> publicacion_data =
                usuariosPuestosTrabajoService.BuscarPublicacion_By_IDPublicacion(id_publicacion);

        if (publicacion_data.isPresent()) {
            UsuariosPuestosTrabajo detalle_publicacion = publicacion_data.get();

            LocalDateTime fecha_registro = detalle_publicacion.getPuestotrabajo().getFecharegistroPuestoTrabajo();
            int fecha_publicacion = fecha_registro.getDayOfMonth();

            String fechapublicacion = "Publicado en " + fecha_publicacion + " de " +
                    ConvierteValorMesToText(fecha_registro.getMonthValue());

            return new ResponseEntity<>(new DetailPuestoTrabajoResponse(
                    detalle_publicacion.getPuestotrabajo().getIdPuestoTrabajo(),
                    detalle_publicacion.getPuestotrabajo().getNombrePuestoTrabajo(),
                    detalle_publicacion.getPuestotrabajo().getDescripcionPuestoTrabajo(),
                    FormatSueldo(detalle_publicacion.getPuestotrabajo().getSueldoPuestoTrabajo()),
                    Code_Format.FormatExperienciaLaboral(detalle_publicacion.getPuestotrabajo().getExperienciaPuestoTrabajo()),
                    detalle_publicacion.getPuestotrabajo().getTipojornadaPuestoTrabajo(),
                    detalle_publicacion.getPuestotrabajo().getModalidadPuestoTrabajo(),
                    fechapublicacion,
                    detalle_publicacion.getUsuario().getNombreUsuario(),
                    detalle_publicacion.getUsuario().getDireccionUsuario(),
                    detalle_publicacion.getUsuario().getTelefonoUsuario(),
                    detalle_publicacion.getUsuario().getEmailUsuario(),
                    new ImagenResponse(
                            detalle_publicacion.getUsuario().getImagenUsuario().getNombreImagen(),
                            detalle_publicacion.getUsuario().getImagenUsuario().getUrlImagen()
                    )
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información detallada de la Publicación."),
                    HttpStatus.NOT_FOUND);
        }
    }

    String ConvierteValorMesToText(int valor_mes) {

        String mes;

        switch (valor_mes) {
            case 1:
                mes = "Enero";
                break;
            case 2:
                mes = "Febrero";
                break;
            case 3:
                mes = "Marzo";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Mayo";
                break;
            case 6:
                mes = "Junio";
                break;
            case 7:
                mes = "Julio";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Septiembre";
                break;
            case 10:
                mes = "Octubre";
                break;
            case 11:
                mes = "Noviembre";
                break;
            case 12:
                mes = "Diciembre";
                break;
            default:
                mes = "";
                break;
        }

        return mes;
    }

    String FormatSueldo(String sueldo) {
        String new_sueldo;

        if (sueldo.equals("")) {
            new_sueldo = "S/ -";
        } else {
            new_sueldo = "S/ " + sueldo + ".00";
        }

        return new_sueldo;
    }
}
