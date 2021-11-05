/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.validation;

public class EducacionValidation {

    //Atributos
    private Long idPostulante;

    private String institucionEducacion;

    private String mesinicioEducacion;

    private String anioinicioEducacion;

    private String mesfinEducacion;

    private String aniofinEducacion;

    private String nombreEducacion;

    private String nivelEducacion;

    private String estadoEducacion;

    //Constructores
    public EducacionValidation() {
    }

    public EducacionValidation(Long idPostulante, String institucionEducacion, String mesinicioEducacion,
                               String anioinicioEducacion, String mesfinEducacion, String aniofinEducacion,
                               String nombreEducacion, String nivelEducacion, String estadoEducacion) {
        this.idPostulante = idPostulante;
        this.institucionEducacion = institucionEducacion;
        this.mesinicioEducacion = mesinicioEducacion;
        this.anioinicioEducacion = anioinicioEducacion;
        this.mesfinEducacion = mesfinEducacion;
        this.aniofinEducacion = aniofinEducacion;
        this.nombreEducacion = nombreEducacion;
        this.nivelEducacion = nivelEducacion;
        this.estadoEducacion = estadoEducacion;
    }

    //Getters y Setters
    public Long getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Long idPostulante) {
        this.idPostulante = idPostulante;
    }

    public String getInstitucionEducacion() {
        return institucionEducacion;
    }

    public void setInstitucionEducacion(String institucionEducacion) {
        this.institucionEducacion = institucionEducacion;
    }

    public String getMesinicioEducacion() {
        return mesinicioEducacion;
    }

    public void setMesinicioEducacion(String mesinicioEducacion) {
        this.mesinicioEducacion = mesinicioEducacion;
    }

    public String getAnioinicioEducacion() {
        return anioinicioEducacion;
    }

    public void setAnioinicioEducacion(String anioinicioEducacion) {
        this.anioinicioEducacion = anioinicioEducacion;
    }

    public String getMesfinEducacion() {
        return mesfinEducacion;
    }

    public void setMesfinEducacion(String mesfinEducacion) {
        this.mesfinEducacion = mesfinEducacion;
    }

    public String getAniofinEducacion() {
        return aniofinEducacion;
    }

    public void setAniofinEducacion(String aniofinEducacion) {
        this.aniofinEducacion = aniofinEducacion;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getEstadoEducacion() {
        return estadoEducacion;
    }

    public void setEstadoEducacion(String estadoEducacion) {
        this.estadoEducacion = estadoEducacion;
    }
}
