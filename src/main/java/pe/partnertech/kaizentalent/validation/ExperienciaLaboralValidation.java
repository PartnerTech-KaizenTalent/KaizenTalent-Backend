/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.validation;

public class ExperienciaLaboralValidation {

    //Atributos
    private Long idPostulante;

    private String nombreExperienciaLaboral;

    private String empresaExperienciaLaboral;

    private String mesinicioExperienciaLaboral;

    private String anioinicioExperienciaLaboral;

    private String mesfinExperienciaLaboral;

    private String aniofinExperienciaLaboral;

    private String descripcionExperienciaLaboral;

    private String referenteReferenciaLaboral;

    private String emailreferenteReferenciaLaboral;

    private String telefonoreferenteReferenciaLaboral;

    //Constructores
    public ExperienciaLaboralValidation() {
    }

    public ExperienciaLaboralValidation(Long idPostulante, String nombreExperienciaLaboral,
                                        String empresaExperienciaLaboral, String mesinicioExperienciaLaboral,
                                        String anioinicioExperienciaLaboral, String mesfinExperienciaLaboral,
                                        String aniofinExperienciaLaboral, String descripcionExperienciaLaboral,
                                        String referenteReferenciaLaboral, String emailreferenteReferenciaLaboral,
                                        String telefonoreferenteReferenciaLaboral) {
        this.idPostulante = idPostulante;
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
        this.referenteReferenciaLaboral = referenteReferenciaLaboral;
        this.emailreferenteReferenciaLaboral = emailreferenteReferenciaLaboral;
        this.telefonoreferenteReferenciaLaboral = telefonoreferenteReferenciaLaboral;
    }

    //Getters y Setters
    public Long getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Long idPostulante) {
        this.idPostulante = idPostulante;
    }

    public String getNombreExperienciaLaboral() {
        return nombreExperienciaLaboral;
    }

    public void setNombreExperienciaLaboral(String nombreExperienciaLaboral) {
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
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

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }

    public String getReferenteReferenciaLaboral() {
        return referenteReferenciaLaboral;
    }

    public void setReferenteReferenciaLaboral(String referenteReferenciaLaboral) {
        this.referenteReferenciaLaboral = referenteReferenciaLaboral;
    }

    public String getEmailreferenteReferenciaLaboral() {
        return emailreferenteReferenciaLaboral;
    }

    public void setEmailreferenteReferenciaLaboral(String emailreferenteReferenciaLaboral) {
        this.emailreferenteReferenciaLaboral = emailreferenteReferenciaLaboral;
    }

    public String getTelefonoreferenteReferenciaLaboral() {
        return telefonoreferenteReferenciaLaboral;
    }

    public void setTelefonoreferenteReferenciaLaboral(String telefonoreferenteReferenciaLaboral) {
        this.telefonoreferenteReferenciaLaboral = telefonoreferenteReferenciaLaboral;
    }
}
