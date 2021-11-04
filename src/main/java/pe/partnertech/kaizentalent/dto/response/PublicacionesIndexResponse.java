/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response;

import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

import java.time.LocalDateTime;

public class PublicacionesIndexResponse {

    //Atributos
    private Long idPuestoTrabajo;

    private String nombrePuestoTrabajo;

    private String ciudadPuestoTrabajo;

    private String sueldoPuestoTrabajo;

    private String tipojornadaPuestoTrabajo;

    private String experienciaPuestoTrabajo;

    private String empresaPuestoTrabajo;

    private String modalidadPuestoTrabajo;

    private LocalDateTime fechapublicacionPuestoTrabajo;

    private ImagenResponse logoEmpresa;

    //Constructores
    public PublicacionesIndexResponse() {
    }

    public PublicacionesIndexResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String ciudadPuestoTrabajo,
                                      String sueldoPuestoTrabajo, String tipojornadaPuestoTrabajo,
                                      String experienciaPuestoTrabajo, String empresaPuestoTrabajo,
                                      String modalidadPuestoTrabajo, LocalDateTime fechapublicacionPuestoTrabajo,
                                      ImagenResponse logoEmpresa) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
        this.empresaPuestoTrabajo = empresaPuestoTrabajo;
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
        this.fechapublicacionPuestoTrabajo = fechapublicacionPuestoTrabajo;
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

    public String getCiudadPuestoTrabajo() {
        return ciudadPuestoTrabajo;
    }

    public void setCiudadPuestoTrabajo(String ciudadPuestoTrabajo) {
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
    }

    public String getSueldoPuestoTrabajo() {
        return sueldoPuestoTrabajo;
    }

    public void setSueldoPuestoTrabajo(String sueldoPuestoTrabajo) {
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
    }

    public String getTipojornadaPuestoTrabajo() {
        return tipojornadaPuestoTrabajo;
    }

    public void setTipojornadaPuestoTrabajo(String tipojornadaPuestoTrabajo) {
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
    }

    public String getExperienciaPuestoTrabajo() {
        return experienciaPuestoTrabajo;
    }

    public void setExperienciaPuestoTrabajo(String experienciaPuestoTrabajo) {
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
    }

    public String getEmpresaPuestoTrabajo() {
        return empresaPuestoTrabajo;
    }

    public void setEmpresaPuestoTrabajo(String empresaPuestoTrabajo) {
        this.empresaPuestoTrabajo = empresaPuestoTrabajo;
    }

    public String getModalidadPuestoTrabajo() {
        return modalidadPuestoTrabajo;
    }

    public void setModalidadPuestoTrabajo(String modalidadPuestoTrabajo) {
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
    }

    public LocalDateTime getFechapublicacionPuestoTrabajo() {
        return fechapublicacionPuestoTrabajo;
    }

    public void setFechapublicacionPuestoTrabajo(LocalDateTime fechapublicacionPuestoTrabajo) {
        this.fechapublicacionPuestoTrabajo = fechapublicacionPuestoTrabajo;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }
}
