/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.tools;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pe.partnertech.kaizentalent.model.*;
import pe.partnertech.kaizentalent.service.*;

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

    final
    IExperienciaLaboralService experienciaLaboralService;

    final
    IImagenService imagenService;

    public MaintainceKaizenTalent(IUsuarioService usuarioService, IPuestoTrabajoService puestoTrabajoService,
                                  IUtilityTokenService utilityTokenService,
                                  IExperienciaLaboralService experienciaLaboralService, IImagenService imagenService) {
        this.usuarioService = usuarioService;
        this.puestoTrabajoService = puestoTrabajoService;
        this.utilityTokenService = utilityTokenService;
        this.experienciaLaboralService = experienciaLaboralService;
        this.imagenService = imagenService;
    }

    @Scheduled(fixedRate = 60000)
    public void ActualizarEstadoPublicacion() {

        Set<PuestoTrabajo> lista_publicaciones = puestoTrabajoService.BuscarPuestosTrabajo_By_FechaCaducidad(LocalDateTime.now());

        for (PuestoTrabajo puestotrabajo : lista_publicaciones) {
            puestotrabajo.setEstadoPuestoTrabajo("No Activo");

            puestoTrabajoService.GuardarPuestoTrabajo(puestotrabajo);
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

    @Scheduled(fixedRate = 60000)
    public void ActualizarLogoEmpresa() {
        Set<Usuario> list_empresas = usuarioService.MostrarEmpresas();

        for (Usuario empresa : list_empresas) {
            String nombre_empresa = empresa.getNombreUsuario();

            Set<ExperienciaLaboral> list_experienciaslaborales =
                    experienciaLaboralService.BuscarExperienciasLaborales_By_Empresa(nombre_empresa);

            for (ExperienciaLaboral experiencialaboral : list_experienciaslaborales) {
                Optional<Imagen> logo_data =
                        imagenService.BuscarImagen_By_ID(experiencialaboral.getImagenExperienciaLaboral().getIdImagen());

                if (logo_data.isPresent()) {
                    Imagen logo_empresa = logo_data.get();

                    logo_empresa.setArchivoImagen(empresa.getImagenUsuario().getArchivoImagen());
                    imagenService.GuardarImagen(logo_empresa);
                }
            }
        }
    }
}