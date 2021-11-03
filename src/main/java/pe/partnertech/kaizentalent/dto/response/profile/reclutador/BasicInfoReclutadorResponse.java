/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.reclutador;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class BasicInfoReclutadorResponse {

    //Atributos
    private String nombreReclutador;
    private String tituloReclutador;
    private String descripcionReclutador;
    private String direccionReclutador;
    private String emailReclutador;
    private String telefonoReclutador;
    private String ciudadReclutador;
    private String nombrecontactanteReclutador;
    private ImagenResponse logoempresaReclutador;

    //Constructores
    public BasicInfoReclutadorResponse() {
    }

    public BasicInfoReclutadorResponse(String nombreReclutador, String tituloReclutador, String descripcionReclutador,
                                       String direccionReclutador, String emailReclutador, String telefonoReclutador,
                                       String ciudadReclutador, String nombrecontactanteReclutador,
                                       ImagenResponse logoempresaReclutador) {
        this.nombreReclutador = nombreReclutador;
        this.tituloReclutador = tituloReclutador;
        this.descripcionReclutador = descripcionReclutador;
        this.direccionReclutador = direccionReclutador;
        this.emailReclutador = emailReclutador;
        this.telefonoReclutador = telefonoReclutador;
        this.ciudadReclutador = ciudadReclutador;
        this.nombrecontactanteReclutador = nombrecontactanteReclutador;
        this.logoempresaReclutador = logoempresaReclutador;
    }

    //Getters y Setters
    public String getNombreReclutador() {
        return nombreReclutador;
    }

    public void setNombreReclutador(String nombreReclutador) {
        this.nombreReclutador = nombreReclutador;
    }

    public String getTituloReclutador() {
        return tituloReclutador;
    }

    public void setTituloReclutador(String tituloReclutador) {
        this.tituloReclutador = tituloReclutador;
    }

    public String getDescripcionReclutador() {
        return descripcionReclutador;
    }

    public void setDescripcionReclutador(String descripcionReclutador) {
        this.descripcionReclutador = descripcionReclutador;
    }

    public String getDireccionReclutador() {
        return direccionReclutador;
    }

    public void setDireccionReclutador(String direccionReclutador) {
        this.direccionReclutador = direccionReclutador;
    }

    public String getEmailReclutador() {
        return emailReclutador;
    }

    public void setEmailReclutador(String emailReclutador) {
        this.emailReclutador = emailReclutador;
    }

    public String getTelefonoReclutador() {
        return telefonoReclutador;
    }

    public void setTelefonoReclutador(String telefonoReclutador) {
        this.telefonoReclutador = telefonoReclutador;
    }

    public String getCiudadReclutador() {
        return ciudadReclutador;
    }

    public void setCiudadReclutador(String ciudadReclutador) {
        this.ciudadReclutador = ciudadReclutador;
    }

    public String getNombrecontactanteReclutador() {
        return nombrecontactanteReclutador;
    }

    public void setNombrecontactanteReclutador(String nombrecontactanteReclutador) {
        this.nombrecontactanteReclutador = nombrecontactanteReclutador;
    }

    public ImagenResponse getLogoempresaReclutador() {
        return logoempresaReclutador;
    }

    public void setLogoempresaReclutador(ImagenResponse logoempresaReclutador) {
        this.logoempresaReclutador = logoempresaReclutador;
    }
}
