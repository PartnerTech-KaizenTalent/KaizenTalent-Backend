/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

public class EducacionPostulanteResponse {

    //Atributos
    private Long idEducacion;

    private String institucionEducacion;

    private String periodoinicioEducacion;

    private String periodofinEducacion;

    private String nombreEducacion;

    private String nivelEducacion;

    private String estadoEducacion;

    //Constructores
    public EducacionPostulanteResponse() {
    }

    public EducacionPostulanteResponse(Long idEducacion, String institucionEducacion, String periodoinicioEducacion,
                                       String periodofinEducacion, String nombreEducacion, String nivelEducacion,
                                       String estadoEducacion) {
        this.idEducacion = idEducacion;
        this.institucionEducacion = institucionEducacion;
        this.periodoinicioEducacion = periodoinicioEducacion;
        this.periodofinEducacion = periodofinEducacion;
        this.nombreEducacion = nombreEducacion;
        this.nivelEducacion = nivelEducacion;
        this.estadoEducacion = estadoEducacion;
    }

    //Getters y Setters
    public Long getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Long idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucionEducacion() {
        return institucionEducacion;
    }

    public void setInstitucionEducacion(String institucionEducacion) {
        this.institucionEducacion = institucionEducacion;
    }

    public String getPeriodoinicioEducacion() {
        return periodoinicioEducacion;
    }

    public void setPeriodoinicioEducacion(String periodoinicioEducacion) {
        this.periodoinicioEducacion = periodoinicioEducacion;
    }

    public String getPeriodofinEducacion() {
        return periodofinEducacion;
    }

    public void setPeriodofinEducacion(String periodofinEducacion) {
        this.periodofinEducacion = periodofinEducacion;
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
