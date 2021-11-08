/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.controller.util.util_code.Code_SendData;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.model.Idioma;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.service.IIdiomaService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.validation.SkillValidation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class IdiomaController {

    final
    IUsuarioService usuarioService;

    final
    IIdiomaService idiomaService;

    public IdiomaController(IUsuarioService usuarioService, IIdiomaService idiomaService) {
        this.usuarioService = usuarioService;
        this.idiomaService = idiomaService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/idioma")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarIdiomaPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                     @RequestBody Idioma idioma) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillValidation> list_idiomas = new HashSet<>();

            idiomaService.ValidarIdiomas(id_postulante, idioma.getNombreIdioma(), idioma.getNivelIdioma()).forEach(
                    idiomas -> list_idiomas.add(
                            new SkillValidation(
                                    id_postulante,
                                    idioma.getNombreIdioma(),
                                    idioma.getNivelIdioma()
                            )));

            if (list_idiomas.size() < 1) {
                //Asignando Postulante
                idioma.setUsuarioIdioma(postulante);

                idiomaService.GuardarIdioma(idioma);

                return new ResponseEntity<>(new MessageResponse("Se ha guardado satisfactoriamente su información de " +
                        "Idioma."),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado ese Idioma."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postulante/{id_postulante}/idioma/{id_idioma}/update")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> UpdateIdiomaPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                    @PathVariable("id_idioma") Long id_idioma,
                                                    @RequestBody Idioma idioma) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Set<SkillValidation> list_idiomas = new HashSet<>();

            idiomaService.ValidarIdiomas(id_postulante, idioma.getNombreIdioma(),
                    idioma.getNivelIdioma()).forEach(
                    idiomas -> list_idiomas.add(
                            new SkillValidation(
                                    id_postulante,
                                    idioma.getNombreIdioma(),
                                    idioma.getNivelIdioma()
                            )));

            if (list_idiomas.size() < 1) {
                Optional<Idioma> idioma_data =
                        idiomaService.BuscarIdioma_By_IDIdioma(id_idioma);

                if (idioma_data.isPresent()) {
                    Idioma idioma_update = idioma_data.get();

                    idioma_update.setNombreIdioma(idioma.getNombreIdioma());
                    idioma_update.setNivelIdioma(idioma.getNivelIdioma());

                    idiomaService.GuardarIdioma(idioma_update);

                    return new ResponseEntity<>(new MessageResponse("Idioma actualizada satisfactoriamente."),
                            HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new MessageResponse("No se encontró información del Idioma."),
                            HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new MessageResponse("Ya se encuentra registrado un Idioma con dichos datos."),
                        HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new MessageResponse("No se encuentra la información del Usuario."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/idioma/{id_idioma}/delete")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> DeleteIdioma(@PathVariable("id_idioma") Long id_idioma) {

        Optional<Idioma> idioma_data =
                idiomaService.BuscarIdioma_By_IDIdioma(id_idioma);

        if (idioma_data.isPresent()) {
            idiomaService.EliminarIdioma(id_idioma);

            return new ResponseEntity<>(new MessageResponse("Se ha eliminado el Idioma satisfactoriamente."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al querer eliminar la Idioma."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/postulante/{id_postulante}/idioma/show")
    @PreAuthorize("hasRole('ROLE_POSTULANTE') or hasRole('ROLE_RECLUTADOR')")
    public ResponseEntity<?> MostrarConocimientosPostulante(@PathVariable("id_postulante") Long id_postulante) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            return new ResponseEntity<>(Code_SendData.SendIdiomas(id_postulante, usuarioService, idiomaService),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageResponse("Ocurrió un error al cargar la información solicitada del " +
                    "postulante"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
