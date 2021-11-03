/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;
import pe.partnertech.kaizentalent.security.dto.JwtResponse;
import pe.partnertech.kaizentalent.serviceimpl.UserDetailsImpl;

public class Code_SigninValidations {

    public static ResponseEntity<?> SigninUsuario(String jwt, UserDetailsImpl userDetails) {
        switch (userDetails.getEstadoUsuario()) {
            case "PENDIENTE":
                return new ResponseEntity<>(new MessageResponse("Tiene un proceso de registro pendiente por " +
                        "culminar."), HttpStatus.BAD_REQUEST);
            case "BLOQUEADO":
                return new ResponseEntity<>(new MessageResponse("Se ha bloqueado el acceso al sistema por " +
                        "tener un proceso pendiente en su cuenta."), HttpStatus.BAD_REQUEST);
            case "ACTIVO":
                return new ResponseEntity<>(new JwtResponse(
                        jwt,
                        userDetails.getIdUsuario(),
                        userDetails.getNombreUsuario(),
                        userDetails.getUsername(),
                        userDetails.getAuthorities()
                ), HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
