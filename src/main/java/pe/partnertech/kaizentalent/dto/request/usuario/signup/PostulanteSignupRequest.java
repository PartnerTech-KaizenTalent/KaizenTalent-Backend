/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.request.usuario.signup;

public class PostulanteSignupRequest {

    //Atributos
    private String nombreUsuario;
    private String apellidoUsuario;
    private String ciudadUsuario;
    private String emailUsuario;
    private String tipodocumentoUsuario;
    private String numerodocumentoUsuario;
    private String usernameUsuario;
    private String passwordUsuario;
    private String generoUsuario;
    private String fechanacimientoUsuario;

    //Constructores
    public PostulanteSignupRequest() {
    }

    public PostulanteSignupRequest(String nombreUsuario, String apellidoUsuario, String ciudadUsuario,
                                   String emailUsuario, String tipodocumentoUsuario, String numerodocumentoUsuario,
                                   String usernameUsuario, String passwordUsuario, String generoUsuario,
                                   String fechanacimientoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.emailUsuario = emailUsuario;
        this.tipodocumentoUsuario = tipodocumentoUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.generoUsuario = generoUsuario;
        this.fechanacimientoUsuario = fechanacimientoUsuario;
    }

    //Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
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

    public String getTipodocumentoUsuario() {
        return tipodocumentoUsuario;
    }

    public void setTipodocumentoUsuario(String tipodocumentoUsuario) {
        this.tipodocumentoUsuario = tipodocumentoUsuario;
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

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public String getFechanacimientoUsuario() {
        return fechanacimientoUsuario;
    }

    public void setFechanacimientoUsuario(String fechanacimientoUsuario) {
        this.fechanacimientoUsuario = fechanacimientoUsuario;
    }
}
