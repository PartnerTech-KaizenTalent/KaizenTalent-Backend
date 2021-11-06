/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class ReferenciaLaboralPostulanteResponse {

    //Atributos
    private String empresaReferente;

    private String nombreReferente;

    private String emailReferente;

    private String telefonoReferente;

    private String mesinicioExperienciaLaboral;

    private String anioinicioExperienciaLaboral;

    private ImagenResponse logoEmpresa;

    private String mesInicio;

    //Constructores
    public ReferenciaLaboralPostulanteResponse() {
    }

    public ReferenciaLaboralPostulanteResponse(String empresaReferente, String nombreReferente, String emailReferente,
                                               String telefonoReferente, String mesinicioExperienciaLaboral,
                                               String anioinicioExperienciaLaboral, ImagenResponse logoEmpresa,
                                               String mesInicio) {
        this.empresaReferente = empresaReferente;
        this.nombreReferente = nombreReferente;
        this.emailReferente = emailReferente;
        this.telefonoReferente = telefonoReferente;
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
        this.logoEmpresa = logoEmpresa;
        this.mesInicio = mesInicio;
    }

    //Getters y Setters
    public String getEmpresaReferente() {
        return empresaReferente;
    }

    public void setEmpresaReferente(String empresaReferente) {
        this.empresaReferente = empresaReferente;
    }

    public String getNombreReferente() {
        return nombreReferente;
    }

    public void setNombreReferente(String nombreReferente) {
        this.nombreReferente = nombreReferente;
    }

    public String getEmailReferente() {
        return emailReferente;
    }

    public void setEmailReferente(String emailReferente) {
        this.emailReferente = emailReferente;
    }

    public String getTelefonoReferente() {
        return telefonoReferente;
    }

    public void setTelefonoReferente(String telefonoReferente) {
        this.telefonoReferente = telefonoReferente;
    }

    public String getMesinicioExperienciaLaboral() {
        return mesinicioExperienciaLaboral;
    }

    public void setMesinicioExperienciaLaboral(String mesinicioExperienciaLaboral) {
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
    }

    public String getAnioinicioExperienciaLaboral() {
        return anioinicioExperienciaLaboral;
    }

    public void setAnioinicioExperienciaLaboral(String anioinicioExperienciaLaboral) {
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }
}
