/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.request.usuario.signup;

public class ReclutadorSignupRequest {

    //Atributos
    private String nombreUsuario;
    private String ciudadUsuario;
    private String emailUsuario;
    private String numerodocumentoUsuario;
    private String usernameUsuario;
    private String passwordUsuario;
    private String contactanteempresaUsuario;
    private String tamanioempresaUsuario;

    //Constructores
    public ReclutadorSignupRequest() {
    }

    public ReclutadorSignupRequest(String nombreUsuario, String ciudadUsuario, String emailUsuario,
                                   String numerodocumentoUsuario, String usernameUsuario, String passwordUsuario,
                                   String contactanteempresaUsuario, String tamanioempresaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.emailUsuario = emailUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.contactanteempresaUsuario = contactanteempresaUsuario;
        this.tamanioempresaUsuario = tamanioempresaUsuario;
    }

    //Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCiudadUsuario() {
        return ciudadUsuario;
    }

    public void setCiudadUsuario(String ciudadUsuario) {
        this.ciudadUsuario = ciudadUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNumerodocumentoUsuario() {
        return numerodocumentoUsuario;
    }

    public void setNumerodocumentoUsuario(String numerodocumentoUsuario) {
        this.numerodocumentoUsuario = numerodocumentoUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getContactanteempresaUsuario() {
        return contactanteempresaUsuario;
    }

    public void setContactanteempresaUsuario(String contactanteempresaUsuario) {
        this.contactanteempresaUsuario = contactanteempresaUsuario;
    }

    public String getTamanioempresaUsuario() {
        return tamanioempresaUsuario;
    }

    public void setTamanioempresaUsuario(String tamanioempresaUsuario) {
        this.tamanioempresaUsuario = tamanioempresaUsuario;
    }
}
