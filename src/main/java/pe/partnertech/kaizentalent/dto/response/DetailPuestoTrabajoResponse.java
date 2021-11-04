/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class DetailPuestoTrabajoResponse {

    //Atributos
    private Long idPuestoTrabajo;

    private String nombrePuestoTrabajo;

    private String descripcionPuestoTrabajo;

    private String sueldoPuestoTrabajo;

    private String experienciaPuestoTrabajo;

    private String tipojornadaPuestoTrabajo;

    private String modalidadPuestoTrabajo;

    private String publicacionPuestoTrabajo;

    private String nombreEmpresa;

    private String direccionEmpresa;

    private String telefonoEmpresa;

    private String emailEmpresa;

    private ImagenResponse logoEmpresa;

    //Constructores
    public DetailPuestoTrabajoResponse() {
    }

    public DetailPuestoTrabajoResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String descripcionPuestoTrabajo,
                                       String sueldoPuestoTrabajo, String experienciaPuestoTrabajo,
                                       String tipojornadaPuestoTrabajo, String modalidadPuestoTrabajo,
                                       String publicacionPuestoTrabajo, String nombreEmpresa, String direccionEmpresa,
                                       String telefonoEmpresa, String emailEmpresa, ImagenResponse logoEmpresa) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
        this.publicacionPuestoTrabajo = publicacionPuestoTrabajo;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.logoEmpresa = logoEmpresa;
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

    public String getDescripcionPuestoTrabajo() {
        return descripcionPuestoTrabajo;
    }

    public void setDescripcionPuestoTrabajo(String descripcionPuestoTrabajo) {
        this.descripcionPuestoTrabajo = descripcionPuestoTrabajo;
    }

    public String getSueldoPuestoTrabajo() {
        return sueldoPuestoTrabajo;
    }

    public void setSueldoPuestoTrabajo(String sueldoPuestoTrabajo) {
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
    }

    public String getExperienciaPuestoTrabajo() {
        return experienciaPuestoTrabajo;
    }

    public void setExperienciaPuestoTrabajo(String experienciaPuestoTrabajo) {
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
    }

    public String getTipojornadaPuestoTrabajo() {
        return tipojornadaPuestoTrabajo;
    }

    public void setTipojornadaPuestoTrabajo(String tipojornadaPuestoTrabajo) {
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
    }

    public String getModalidadPuestoTrabajo() {
        return modalidadPuestoTrabajo;
    }

    public void setModalidadPuestoTrabajo(String modalidadPuestoTrabajo) {
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
    }

    public String getPublicacionPuestoTrabajo() {
        return publicacionPuestoTrabajo;
    }

    public void setPublicacionPuestoTrabajo(String publicacionPuestoTrabajo) {
        this.publicacionPuestoTrabajo = publicacionPuestoTrabajo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }
}
