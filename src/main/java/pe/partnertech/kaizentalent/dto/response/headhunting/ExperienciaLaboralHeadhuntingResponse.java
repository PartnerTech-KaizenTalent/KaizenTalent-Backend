/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting;

public class ExperienciaLaboralHeadhuntingResponse {

    //Atributos
    private String puestoExperienciaLaboral;
    private String empresaExperienciaLaboral;
    private String periodoinicioExperienciaLaboral;
    private String periodofinExperienciaLaboral;
    private String descripcionExperienciaLaboral;

    //Constructores
    public ExperienciaLaboralHeadhuntingResponse() {
    }

    public ExperienciaLaboralHeadhuntingResponse(String puestoExperienciaLaboral, String empresaExperienciaLaboral,
                                                 String periodoinicioExperienciaLaboral,
                                                 String periodofinExperienciaLaboral, String descripcionExperienciaLaboral) {
        this.puestoExperienciaLaboral = puestoExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.periodoinicioExperienciaLaboral = periodoinicioExperienciaLaboral;
        this.periodofinExperienciaLaboral = periodofinExperienciaLaboral;
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }

    //Getters y Setters
    public String getPuestoExperienciaLaboral() {
        return puestoExperienciaLaboral;
    }

    public void setPuestoExperienciaLaboral(String puestoExperienciaLaboral) {
        this.puestoExperienciaLaboral = puestoExperienciaLaboral;
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

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }
}
