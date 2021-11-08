/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class ExperienciaLaboralPostulanteResponse {

    //Atributos
    private Long idExperienciaLaboral;

    private String empresaExperienciaLaboral;

    private String periodoinicioExperienciaLaboral;

    private String periodofinExperienciaLaboral;

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
                                                String periodoinicioExperienciaLaboral, String periodofinExperienciaLaboral,
                                                String nombreExperienciaLaboral, ImagenResponse logoEmpresa,
                                                String descripcionExperienciaLaboral, String nombreReferente,
                                                String emailReferente, String telefonoReferente) {
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
        this.periodofinExperienciaLaboral = periodofinExperienciaLaboral;
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

    public String getPeriodoinicioExperienciaLaboral() {
        return periodoinicioExperienciaLaboral;
    }

    public void setPeriodoinicioExperienciaLaboral(String periodoinicioExperienciaLaboral) {
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
    }

    public String getPeriodofinExperienciaLaboral() {
        return periodofinExperienciaLaboral;
    }

    public void setPeriodofinExperienciaLaboral(String periodofinExperienciaLaboral) {
        this.periodofinExperienciaLaboral = periodofinExperienciaLaboral;
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
