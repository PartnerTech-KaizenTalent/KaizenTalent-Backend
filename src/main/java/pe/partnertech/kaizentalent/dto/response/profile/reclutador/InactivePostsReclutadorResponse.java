/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.reclutador;

public class InactivePostsReclutadorResponse {

    //Atributos
    private Long idPuestoTrabajo;
    private String nombrePuestoTrabajo;
    private String estadoPuestoTrabajo;
    private int cantidadPostulantes;
    private int periodoactualPuestoTrabajo;

    //Constructores
    public InactivePostsReclutadorResponse() {
    }

    public InactivePostsReclutadorResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String estadoPuestoTrabajo,
                                           int cantidadPostulantes, int periodoactualPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.estadoPuestoTrabajo = estadoPuestoTrabajo;
        this.cantidadPostulantes = cantidadPostulantes;
        this.periodoactualPuestoTrabajo = periodoactualPuestoTrabajo;
    }

    //Getters y Setters
    public Long getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Long idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    public String getEstadoPuestoTrabajo() {
        return estadoPuestoTrabajo;
    }

    public void setEstadoPuestoTrabajo(String estadoPuestoTrabajo) {
        this.estadoPuestoTrabajo = estadoPuestoTrabajo;
    }

    public int getCantidadPostulantes() {
        return cantidadPostulantes;
    }

    public void setCantidadPostulantes(int cantidadPostulantes) {
        this.cantidadPostulantes = cantidadPostulantes;
    }

    public int getPeriodoactualPuestoTrabajo() {
        return periodoactualPuestoTrabajo;
    }

    public void setPeriodoactualPuestoTrabajo(int periodoactualPuestoTrabajo) {
        this.periodoactualPuestoTrabajo = periodoactualPuestoTrabajo;
    }
}
