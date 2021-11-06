/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class ExperienciaLaboralPostulanteResponse {

    //Atributos
    private Long idExperienciaLaboral;

    private String empresaExperienciaLaboral;

    private String mesinicioExperienciaLaboral;

    private String anioinicioExperienciaLaboral;

    private String mesfinExperienciaLaboral;

    private String aniofinExperienciaLaboral;

    private String nombreExperienciaLaboral;

    private ImagenResponse logoEmpresa;

    private String descripcionExperienciaLaboral;

    private String nombreReferente;

    private String emailReferente;

    private String telefonoReferente;

    //Constructores
    public ExperienciaLaboralPostulanteResponse() {
    }

    public ExperienciaLaboralPostulanteResponse(Long idExperienciaLaboral, String empresaExperienciaLaboral,
                                                String mesinicioExperienciaLaboral, String anioinicioExperienciaLaboral,
                                                String mesfinExperienciaLaboral, String aniofinExperienciaLaboral,
                                                String nombreExperienciaLaboral, ImagenResponse logoEmpresa,
                                                String descripcionExperienciaLaboral, String nombreReferente,
                                                String emailReferente, String telefonoReferente) {
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
        this.logoEmpresa = logoEmpresa;
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
        this.nombreReferente = nombreReferente;
        this.emailReferente = emailReferente;
        this.telefonoReferente = telefonoReferente;
    }

    //Getters y Setters
    public Long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public String getEmpresaExperienciaLaboral() {
        return empresaExperienciaLaboral;
    }

    public void setEmpresaExperienciaLaboral(String empresaExperienciaLaboral) {
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
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

    public String getMesfinExperienciaLaboral() {
        return mesfinExperienciaLaboral;
    }

    public void setMesfinExperienciaLaboral(String mesfinExperienciaLaboral) {
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
    }

    public String getAniofinExperienciaLaboral() {
        return aniofinExperienciaLaboral;
    }

    public void setAniofinExperienciaLaboral(String aniofinExperienciaLaboral) {
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
    }

    public String getNombreExperienciaLaboral() {
        return nombreExperienciaLaboral;
    }

    public void setNombreExperienciaLaboral(String nombreExperienciaLaboral) {
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
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
}
