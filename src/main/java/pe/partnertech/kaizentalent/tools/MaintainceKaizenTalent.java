/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.tools;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pe.partnertech.kaizentalent.model.PuestoTrabajo;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.model.UtilityToken;
import pe.partnertech.kaizentalent.service.IPuestoTrabajoService;
import pe.partnertech.kaizentalent.service.IUsuarioService;
import pe.partnertech.kaizentalent.service.IUtilityTokenService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
public class MaintainceKaizenTalent {

    final
    IUsuarioService usuarioService;

    final
    IPuestoTrabajoService puestoTrabajoService;

    final
    IUtilityTokenService utilityTokenService;

    public MaintainceKaizenTalent(IUsuarioService usuarioService, IPuestoTrabajoService puestoTrabajoService,
                                  IUtilityTokenService utilityTokenService) {
        this.usuarioService = usuarioService;
        this.puestoTrabajoService = puestoTrabajoService;
        this.utilityTokenService = utilityTokenService;
    }

    @Scheduled(fixedRate = 60000)
    public void ActualizarEstadoPublicacion() {

        Set<PuestoTrabajo> lista_publicaciones = puestoTrabajoService.BuscarPuestosTrabajo_By_FechaCaducidad(LocalDateTime.now());

        for (PuestoTrabajo puestotrabajo : lista_publicaciones) {
            puestotrabajo.setEstadoPuestoTrabajo("No Activo");
        }
    }

    @Scheduled(fixedRate = 60000)
    public void EliminarUsuarioVerifyTimedOut() {
        Set<UtilityToken> utilitytoken_list = utilityTokenService.BuscarUtilityToken_By_ExpiracionAndRazon(LocalDateTime.now(),
                "Usuario Verify");

        EliminarUsuario_UtilityToken(utilitytoken_list);
    }

    private void EliminarUsuario_UtilityToken(Set<UtilityToken> utilitytoken_list) {
        for (UtilityToken utilitytoken : utilitytoken_list) {
            Optional<Usuario> usuario_timedout =
                    usuarioService.BuscarUsuario_By_IDUtilityToken(utilitytoken.getIdUtilityToken());

            if (usuario_timedout.isPresent()) {
                Usuario usuario = usuario_timedout.get();

                usuarioService.EliminarUsuario(usuario.getIdUsuario());
            }
        }
    }

    @Scheduled(fixedRate = 60000)
    public void EliminarRestorePasswordUtilityToken() {
        Set<UtilityToken> utilitytoken_list = utilityTokenService.BuscarUtilityToken_By_ExpiracionAndRazon(LocalDateTime.now(),
                "Restore Password");

        for (UtilityToken restoretoken : utilitytoken_list) {
            utilityTokenService.EliminarUtilityToken(restoretoken.getIdUtilityToken());
        }
    }


    //TODO: Actualizar Logo Empresa
}
