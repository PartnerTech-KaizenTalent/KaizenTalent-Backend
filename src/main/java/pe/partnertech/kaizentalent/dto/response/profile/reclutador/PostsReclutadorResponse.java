/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.reclutador;

public class PostsReclutadorResponse {

    //Atributos
    private Long idPuestoTrabajo;
    private String nombrePuestoTrabajo;
    private String estadoPuestoTrabajo;
    private int cantidadPostulantes;
    private String ciudadPuestoTrabajo;
    private String categoriaPuestoTrabajo;
    private String modalidadPuestoTrabajo;
    private String tipojornadaPuestoTrabajo;
    private String sueldoPuestoTrabajo;
    private int experienciaPuestoTrabajo;
    private int periodoactualPuestoTrabajo;
    private String descripcionPuestoTrabajo;

    //Constructores
    public PostsReclutadorResponse() {
    }

    public PostsReclutadorResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String estadoPuestoTrabajo,
                                   int cantidadPostulantes, String ciudadPuestoTrabajo, String categoriaPuestoTrabajo,
                                   String modalidadPuestoTrabajo, String tipojornadaPuestoTrabajo,
                                   String sueldoPuestoTrabajo, int experienciaPuestoTrabajo,
                                   int periodoactualPuestoTrabajo, String descripcionPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.estadoPuestoTrabajo = estadoPuestoTrabajo;
        this.cantidadPostulantes = cantidadPostulantes;
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
        this.categoriaPuestoTrabajo = categoriaPuestoTrabajo;
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
        this.periodoactualPuestoTrabajo = periodoactualPuestoTrabajo;
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
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

    public String getCiudadPuestoTrabajo() {
        return ciudadPuestoTrabajo;
    }

    public void setCiudadPuestoTrabajo(String ciudadPuestoTrabajo) {
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
    }

    public String getCategoriaPuestoTrabajo() {
        return categoriaPuestoTrabajo;
    }

    public void setCategoriaPuestoTrabajo(String categoriaPuestoTrabajo) {
        this.categoriaPuestoTrabajo = categoriaPuestoTrabajo;
    }

    public String getModalidadPuestoTrabajo() {
        return modalidadPuestoTrabajo;
    }

    public void setModalidadPuestoTrabajo(String modalidadPuestoTrabajo) {
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
    }

    public String getTipojornadaPuestoTrabajo() {
        return tipojornadaPuestoTrabajo;
    }

    public void setTipojornadaPuestoTrabajo(String tipojornadaPuestoTrabajo) {
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
    }

    public String getSueldoPuestoTrabajo() {
        return sueldoPuestoTrabajo;
    }

    public void setSueldoPuestoTrabajo(String sueldoPuestoTrabajo) {
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
    }

    public int getExperienciaPuestoTrabajo() {
        return experienciaPuestoTrabajo;
    }

    public void setExperienciaPuestoTrabajo(int experienciaPuestoTrabajo) {
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
    }

    public int getPeriodoactualPuestoTrabajo() {
        return periodoactualPuestoTrabajo;
    }

    public void setPeriodoactualPuestoTrabajo(int periodoactualPuestoTrabajo) {
        this.periodoactualPuestoTrabajo = periodoactualPuestoTrabajo;
    }

    public String getDescripcionPuestoTrabajo() {
        return descripcionPuestoTrabajo;
    }

    public void setDescripcionPuestoTrabajo(String descripcionPuestoTrabajo) {
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
    }
}
