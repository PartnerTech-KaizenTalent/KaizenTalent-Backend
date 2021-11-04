/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.postulante;

public class PostulacionesResponse {

    //Atributos
    private Long idPuestoTrabajo;
    private String nombrePuestoTrabajo;
    private String nombreEmpresa;

    //Constructores
    public PostulacionesResponse() {
    }

    public PostulacionesResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String nombreEmpresa) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.nombreEmpresa = nombreEmpresa;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
