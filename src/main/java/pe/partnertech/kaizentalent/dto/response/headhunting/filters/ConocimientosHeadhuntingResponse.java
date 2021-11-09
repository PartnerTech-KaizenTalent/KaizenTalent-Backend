/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting.filters;

public class ConocimientosHeadhuntingResponse {

    //Atributos
    private String conocimiento;

    //Constructores
    public ConocimientosHeadhuntingResponse() {
    }

    public ConocimientosHeadhuntingResponse(String conocimiento) {
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
