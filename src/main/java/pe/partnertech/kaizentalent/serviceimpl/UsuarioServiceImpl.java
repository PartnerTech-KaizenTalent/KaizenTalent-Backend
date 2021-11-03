/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Usuario;
import pe.partnertech.kaizentalent.repository.IUsuarioDAO;
import pe.partnertech.kaizentalent.service.IUsuarioService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

    final
    IUsuarioDAO data;

    public UsuarioServiceImpl(IUsuarioDAO data) {
        this.data = data;
    }

    @Override
    public Set<Usuario> MostrarEmpresas() {
        return data.findUsuariosEmpresa();
    }

    @Override
    public Set<Usuario> BuscarEmpresas_By_Nombre(String nombre_empresa) {
        return data.findByNombreUsuarioContainingIgnoreCaseOrderByNombreUsuarioAsc(nombre_empresa);
    }

    @Override
    public Set<Usuario> MostrarPostulantes() {
        //TODO: DAO DE Headhunting
        return null;
    }

    @Override
    public Optional<Usuario> BuscarUsuario_By_IDUsuario(Long id_usuario) {
        return data.findById(id_usuario);
    }

    @Override
    public Optional<Usuario> BuscarUsuario_By_NombreUsuario(String nombre_usuario) {
        return data.findByNombreUsuario(nombre_usuario);
    }

    @Override
    public Optional<Usuario> BuscarUsuario_By_EmailUsuario(String email_usuario) {
        return data.findByEmailUsuario(email_usuario);
    }

    @Override
    public Optional<Usuario> BuscarUsuario_By_UsernameOrEmail(String username_or_email) {
        return data.findByUsernameOrEmail(username_or_email);
    }

    @Override
    public Optional<Usuario> BuscarUsuario_By_IDUtilityToken(Long id_utilitytoken) {
        return data.findByIdUtilityToken(id_utilitytoken);
    }

    @Override
    public Boolean ValidarUsername(String username_usuario) {
        return data.existsByUsernameUsuario(username_usuario);
    }

    @Override
    public Boolean ValidarNumeroDocumento(String numerodocumento_usuario) {
        return data.existsByNumerodocumentoUsuario(numerodocumento_usuario);
    }

    @Override
    public void GuardarUsuario(Usuario usuario) {
        data.save(usuario);
    }

    @Override
    public void EliminarUsuario(Long id_usuario) {
        data.deleteById(id_usuario);
    }
}
