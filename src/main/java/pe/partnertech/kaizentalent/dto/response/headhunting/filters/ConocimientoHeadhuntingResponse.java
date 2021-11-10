/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting.filters;

public class ConocimientoHeadhuntingResponse {

    //Atributos
    String conocimiento;

    //Constructores
    public ConocimientoHeadhuntingResponse() {
    }

    public ConocimientoHeadhuntingResponse(String conocimiento) {
        this.conocimiento = conocimiento;
    }

    //Getters y Setters
    public String getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(String conocimiento) {
        this.conocimiento = conocimiento;
    }
}
