/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.profile.postulante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    IIdiomaService iIdiomaService;

    public IdiomaController(IUsuarioService usuarioService, IIdiomaService iIdiomaService) {
        this.usuarioService = usuarioService;
        this.iIdiomaService = iIdiomaService;
    }

    @PostMapping("/postulante/{id_postulante}/agregar/idioma")
    @PreAuthorize("hasRole('ROLE_POSTULANTE')")
    public ResponseEntity<?> AgregarIdiomaPostulante(@PathVariable("id_postulante") Long id_postulante,
                                                     @RequestBody Idioma idioma) {

        Optional<Usuario> postulante_data = usuarioService.BuscarUsuario_By_IDUsuario(id_postulante);

        if (postulante_data.isPresent()) {
            Usuario postulante = postulante_data.get();

            Set<SkillValidation> list_idiomas = new HashSet<>();

            iIdiomaService.ValidarIdiomas(id_postulante, idioma.getNombreIdioma(), idioma.getNivelIdioma()).forEach(
                    idiomas -> list_idiomas.add(
                            new SkillValidation(
                                    id_postulante,
                                    idioma.getNombreIdioma(),
                                    idioma.getNivelIdioma()
                            )));

            if (list_idiomas.size() < 1) {
                //Asignando Postulante
                idioma.setUsuarioIdioma(postulante);

                iIdiomaService.GuardarIdioma(idioma);

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
}
