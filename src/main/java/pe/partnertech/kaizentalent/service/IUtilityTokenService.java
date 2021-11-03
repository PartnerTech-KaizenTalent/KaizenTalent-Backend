/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.UtilityToken;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface IUtilityTokenService {

    Set<UtilityToken> BuscarUtilityToken_By_ExpiracionAndRazon(LocalDateTime expiracion_utilitytoken,
                                                               String razon_utilitytoken);

    Set<UtilityToken> BuscarUtilityToken_By_IDUsuarioAndRazonUtilityToken(Long id_usuario, String razon_utilitytoken);

    Optional<UtilityToken> BuscarUtilityToken_By_Token(String token_utilitytoken);

    void GuardarUtilityToken(UtilityToken utilitytoken);

    void EliminarUtilityToken(Long id_utilitytoken);
}
