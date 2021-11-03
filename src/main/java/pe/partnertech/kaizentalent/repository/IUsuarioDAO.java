/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.Usuario;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsernameUsuario(String username_usuario);

    Optional<Usuario> findByNombreUsuario(String nombre_usuario);

    Optional<Usuario> findByEmailUsuario(String email_usuario);

    @Query("SELECT u FROM Usuario u WHERE u.usernameUsuario LIKE ?1 OR u.emailUsuario LIKE ?1")
    Optional<Usuario> findByUsernameOrEmail(String username_or_email);

    @Query("SELECT u FROM Usuario u JOIN UtilityToken ut ON u.idUsuario = ut.usuarioUtilityToken.idUsuario " +
            "WHERE ut.idUtilityToken = ?1")
    Optional<Usuario> findByIdUtilityToken(Long id_utilitytoken);

    @Query("SELECT u FROM Usuario u WHERE u.tipodocumentoUsuario LIKE 'RUC' ORDER BY u.nombreUsuario ASC")
    Set<Usuario> findUsuariosEmpresa();

    Set<Usuario> findByNombreUsuarioContainingIgnoreCaseOrderByNombreUsuarioAsc(String nombre_usuario);

    boolean existsByUsernameUsuario(String username_usuario);

    boolean existsByNumerodocumentoUsuario(String numerodocumento_usuario);
}
