/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.Usuario;

import java.util.Optional;
import java.util.Set;

public interface IUsuarioService {

    Set<Usuario> MostrarEmpresas();

    Set<Usuario> BuscarEmpresas_By_Nombre(String nombre_empresa);

    Set<Usuario> MostrarPostulantes();

    Optional<Usuario> BuscarUsuario_By_IDUsuario(Long id_usuario);

    Optional<Usuario> BuscarUsuario_By_NombreUsuario(String nombre_usuario);

    Optional<Usuario> BuscarUsuario_By_EmailUsuario(String email_usuario);

    Optional<Usuario> BuscarUsuario_By_UsernameOrEmail(String username_or_email);

    Optional<Usuario> BuscarUsuario_By_IDUtilityToken(Long id_utilitytoken);

    Boolean ValidarUsername(String username_usuario);

    Boolean ValidarNumeroDocumento(String numerodocumento_usuario);

    void GuardarUsuario(Usuario usuario);

    void EliminarUsuario(Long id_usuario);
}
