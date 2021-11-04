/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.reclutador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UsuariosPuestosTrabajo;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUsuariosPuestosTrabajoService;
import pe.partnertech.kaizentalent.validation.PublicacionValidation;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PublicacionController {

    final
    IUsuarioService usuarioService;

    final
    IPuestoTrabajoService puestoTrabajoService;

    final
    IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService;

    public PublicacionController(IUsuarioService usuarioService, IPuestoTrabajoService puestoTrabajoService,
                                 IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {
        this.usuarioService = usuarioService;
        this.puestoTrabajoService = puestoTrabajoService;
        this.usuariosPuestosTrabajoService = usuariosPuestosTrabajoService;
    }

    @PostMapping("/reclutador/{id_reclutador}/publicar")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> GuardarPublicacion(@PathVariable("id_reclutador") Long id_reclutador,
                                                @RequestBody PuestoTrabajo puestotrabajo) {

        Optional<Usuario> reclutador_data = usuarioService.BuscarUsuario_By_IDUsuario(id_reclutador);

        if (reclutador_data.isPresent()) {
            if (ValidarPublicacion(id_reclutador, puestotrabajo, usuariosPuestosTrabajoService) < 1) {
                Usuario reclutador = reclutador_data.get();

                //Datos de Publicacion
                //Asignando Fecha de Registro Actual
                puestotrabajo.setFecharegistroPuestoTrabajo(LocalDateTime.now());

                //Asignando Fecha de Caducidad
                puestotrabajo.setFechacaducidadPuestoTrabajo(
                        puestotrabajo.getFecharegistroPuestoTrabajo().plusDays(puestotrabajo.getPeriodoinicioPuestoTrabajo())
                );

                //Asignando Periodo Actual = Periodo Inicio
                puestotrabajo.setPeriodoactualPuestoTrabajo(puestotrabajo.getPeriodoinicioPuestoTrabajo());

                //Asignando Estado: Activo
                puestotrabajo.setEstadoPuestoTrabajo("Activo");

                puestoTrabajoService.GuardarPuestoTrabajo(puestotrabajo);

                UsuariosPuestosTrabajo usuariosPuestosTrabajo = new UsuariosPuestosTrabajo(
                        reclutador,
                        puestotrabajo
                );
                usuariosPuestosTrabajoService.GuardarUsuariosPuestosTrabajo(usuariosPuestosTrabajo);

                return new ResponseEntity<>(new MessageResponse("Se ha publicado el Puesto de Trabajo satisfactoriamente"),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado el Puesto de Trabajo"),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al publicar el Puesto de Trabajo."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reclutador/{id_reclutador}/publicacion/{id_publicacion}/update")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> UpdatePuestoTrabajo(@PathVariable("id_reclutador") Long id_reclutador,
                                                 @PathVariable("id_publicacion") Long id_publicacion,
                                                 @RequestBody PuestoTrabajo puestotrabajo) {

        if (ValidarPublicacion(id_reclutador, puestotrabajo, usuariosPuestosTrabajoService) < 1) {
            Optional<PuestoTrabajo> publicacion_data = puestoTrabajoService.BuscarPuestoTrabajo_By_ID(id_publicacion);

            if (publicacion_data.isPresent()) {
                PuestoTrabajo publicacion = publicacion_data.get();

                publicacion.setNombrePuestoTrabajo(puestotrabajo.getNombrePuestoTrabajo());
                publicacion.setCiudadPuestoTrabajo(puestotrabajo.getCiudadPuestoTrabajo());
                publicacion.setCategoriaPuestoTrabajo(puestotrabajo.getCategoriaPuestoTrabajo());
                publicacion.setModalidadPuestoTrabajo(puestotrabajo.getModalidadPuestoTrabajo());
                publicacion.setTipojornadaPuestoTrabajo(puestotrabajo.getTipojornadaPuestoTrabajo());
                publicacion.setSueldoPuestoTrabajo(puestotrabajo.getSueldoPuestoTrabajo());
                publicacion.setExperienciaPuestoTrabajo(puestotrabajo.getExperienciaPuestoTrabajo());
                publicacion.setDescripcionPuestoTrabajo(puestotrabajo.getDescripcionPuestoTrabajo());

                puestoTrabajoService.GuardarPuestoTrabajo(publicacion);

                return new ResponseEntity<>(new MessageResponse("Publicacion actualizada satisfactoriamente"),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("No se encontró información de la publicacion"),
                        HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("Ya se publicó un Puesto de Trabajo con dichos datos"),
                    HttpStatus.CONFLICT);
        }
    }

    private static int ValidarPublicacion(@PathVariable("id_reclutador") Long id_reclutador,
                                   @RequestBody PuestoTrabajo puestotrabajo,
                                   IUsuariosPuestosTrabajoService usuariosPuestosTrabajoService) {

        Set<PublicacionValidation> list_publicaciones = new HashSet<>();

        usuariosPuestosTrabajoService.ValidarPublicaciones(id_reclutador,
                puestotrabajo.getNombrePuestoTrabajo(),
                puestotrabajo.getCiudadPuestoTrabajo(),
                puestotrabajo.getCategoriaPuestoTrabajo(),
                puestotrabajo.getModalidadPuestoTrabajo(),
                puestotrabajo.getTipojornadaPuestoTrabajo(),
                puestotrabajo.getSueldoPuestoTrabajo(),
                puestotrabajo.getExperienciaPuestoTrabajo(),
                puestotrabajo.getPeriodoinicioPuestoTrabajo(),
                puestotrabajo.getDescripcionPuestoTrabajo()).forEach(
                publicacion_validate -> list_publicaciones.add(
                        new PublicacionValidation(
                                id_reclutador,
                                puestotrabajo.getNombrePuestoTrabajo(),
                                puestotrabajo.getCiudadPuestoTrabajo(),
                                puestotrabajo.getCategoriaPuestoTrabajo(),
                                puestotrabajo.getModalidadPuestoTrabajo(),
                                puestotrabajo.getTipojornadaPuestoTrabajo(),
                                puestotrabajo.getSueldoPuestoTrabajo(),
                                puestotrabajo.getExperienciaPuestoTrabajo(),
                                puestotrabajo.getPeriodoinicioPuestoTrabajo(),
                                puestotrabajo.getDescripcionPuestoTrabajo()
                        )));

        return list_publicaciones.size();
    }

    @PutMapping("/publicacion/{id_publicacion}/update/estado/activo")
    @PreAuthorize("hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> UpdateEstadoPublicacionToActive(@PathVariable("id_publicacion") Long id_publicacion) {

        Optional<PuestoTrabajo> publicacion_data = puestoTrabajoService.BuscarPuestoTrabajo_By_ID(id_publicacion);

        if (publicacion_data.isPresent()) {

            PuestoTrabajo publicacion = publicacion_data.get();

            publicacion.setFechacaducidadPuestoTrabajo(
                    LocalDateTime.now().plusDays(publicacion.getPeriodoactualPuestoTrabajo()));

            publicacion.setEstadoPuestoTrabajo("Activo");

            puestoTrabajoService.GuardarPuestoTrabajo(publicacion);

            return new ResponseEntity<>(new MessageResponse("Estado del Puesto de Trabajo actualizada satisfactoriamente"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encontró información de la publicacion"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
