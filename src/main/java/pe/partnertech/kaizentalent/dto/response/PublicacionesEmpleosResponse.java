/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

import java.time.LocalDateTime;

public class PublicacionesEmpleosResponse {

    //Atributos
    private Long idPuestoTrabajo;

    private String nombrePuestoTrabajo;

    private String tipojornadaPuestoTrabajo;

    @JsonIgnore
    private LocalDateTime fecharegistroPuestoTrabajo;

    private String empresaPuestoTrabajo;

    private String direccionEmpresa;

    private String ciudadPuestoTrabajo;

    private String categoriaEmpresa;

    private int periodotranscurridoPuestoTrabajo;

    private int experienciaPuestoTrabajo;

    private ImagenResponse logoEmpresa;

    //Constructores
    public PublicacionesEmpleosResponse() {
    }

    public PublicacionesEmpleosResponse(Long idPuestoTrabajo, String nombrePuestoTrabajo, String tipojornadaPuestoTrabajo,
                                        LocalDateTime fecharegistroPuestoTrabajo, String empresaPuestoTrabajo,
                                        String direccionEmpresa, String ciudadPuestoTrabajo, String categoriaEmpresa,
                                        int periodotranscurridoPuestoTrabajo, int experienciaPuestoTrabajo,
                                        ImagenResponse logoEmpresa) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
        this.fecharegistroPuestoTrabajo = fecharegistroPuestoTrabajo;
        this.empresaPuestoTrabajo = empresaPuestoTrabajo;
        this.direccionEmpresa = direccionEmpresa;
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
        this.categoriaEmpresa = categoriaEmpresa;
        this.periodotranscurridoPuestoTrabajo = periodotranscurridoPuestoTrabajo;
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
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

    public String getTipojornadaPuestoTrabajo() {
        return tipojornadaPuestoTrabajo;
    }

    public void setTipojornadaPuestoTrabajo(String tipojornadaPuestoTrabajo) {
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
    }

    public LocalDateTime getFecharegistroPuestoTrabajo() {
        return fecharegistroPuestoTrabajo;
    }

    public void setFecharegistroPuestoTrabajo(LocalDateTime fecharegistroPuestoTrabajo) {
        this.fecharegistroPuestoTrabajo = fecharegistroPuestoTrabajo;
    }

    public String getEmpresaPuestoTrabajo() {
        return empresaPuestoTrabajo;
    }

    public void setEmpresaPuestoTrabajo(String empresaPuestoTrabajo) {
        this.empresaPuestoTrabajo = empresaPuestoTrabajo;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCiudadPuestoTrabajo() {
        return ciudadPuestoTrabajo;
    }

    public void setCiudadPuestoTrabajo(String ciudadPuestoTrabajo) {
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
    }

    public String getCategoriaEmpresa() {
        return categoriaEmpresa;
    }

    public void setCategoriaEmpresa(String categoriaEmpresa) {
        this.categoriaEmpresa = categoriaEmpresa;
    }

    public int getPeriodotranscurridoPuestoTrabajo() {
        return periodotranscurridoPuestoTrabajo;
    }

    public void setPeriodotranscurridoPuestoTrabajo(int periodotranscurridoPuestoTrabajo) {
        this.periodotranscurridoPuestoTrabajo = periodotranscurridoPuestoTrabajo;
    }

    public int getExperienciaPuestoTrabajo() {
        return experienciaPuestoTrabajo;
    }

    public void setExperienciaPuestoTrabajo(int experienciaPuestoTrabajo) {
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
    }

    public ImagenResponse getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(ImagenResponse logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }
}
