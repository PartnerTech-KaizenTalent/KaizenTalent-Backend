/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting;

public class InstitucionesHeadhuntingResponse {

    //Atributos
    private String institucion;

    //Constructores
    public InstitucionesHeadhuntingResponse() {
    }

    public InstitucionesHeadhuntingResponse(String institucion) {
        this.institucion = institucion;
    }

    //Getters y Setters
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
