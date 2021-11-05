/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.validation;

public class PublicacionValidation {

    //Atributos
    private Long id_reclutador;

    private String nombre_puestotrabajo;

    private String ciudad_puestotrabajo;

    private String categoria_puestotrabajo;

    private String modalidad_puestotrabajo;

    private String tipojornada_puestotrabajo;

    private String sueldo_puestotrabajo;

    private int experiencia_puestotrabajo;

    private int periodoinicio_puestotrabajo;

    private String descripcion_puestotrabajo;

    //Constructores
    public PublicacionValidation() {
    }

    public PublicacionValidation(Long id_reclutador, String nombre_puestotrabajo, String ciudad_puestotrabajo,
                                 String categoria_puestotrabajo, String modalidad_puestotrabajo,
                                 String tipojornada_puestotrabajo, String sueldo_puestotrabajo,
                                 int experiencia_puestotrabajo, int periodoinicio_puestotrabajo,
                                 String descripcion_puestotrabajo) {
        this.id_reclutador = id_reclutador;
        this.nombre_puestotrabajo = nombre_puestotrabajo;
        this.ciudad_puestotrabajo = ciudad_puestotrabajo;
        this.categoria_puestotrabajo = categoria_puestotrabajo;
        this.modalidad_puestotrabajo = modalidad_puestotrabajo;
        this.tipojornada_puestotrabajo = tipojornada_puestotrabajo;
        this.sueldo_puestotrabajo = sueldo_puestotrabajo;
        this.experiencia_puestotrabajo = experiencia_puestotrabajo;
        this.periodoinicio_puestotrabajo = periodoinicio_puestotrabajo;
        this.descripcion_puestotrabajo = descripcion_puestotrabajo;
    }

    //Getters y Setters
    public Long getId_reclutador() {
        return id_reclutador;
    }

    public void setId_reclutador(Long id_reclutador) {
        this.id_reclutador = id_reclutador;
    }

    public String getNombre_puestotrabajo() {
        return nombre_puestotrabajo;
    }

    public void setNombre_puestotrabajo(String nombre_puestotrabajo) {
        this.nombre_puestotrabajo = nombre_puestotrabajo;
    }

    public String getCiudad_puestotrabajo() {
        return ciudad_puestotrabajo;
    }

    public void setCiudad_puestotrabajo(String ciudad_puestotrabajo) {
        this.ciudad_puestotrabajo = ciudad_puestotrabajo;
    }

    public String getCategoria_puestotrabajo() {
        return categoria_puestotrabajo;
    }

    public void setCategoria_puestotrabajo(String categoria_puestotrabajo) {
        this.categoria_puestotrabajo = categoria_puestotrabajo;
    }

    public String getModalidad_puestotrabajo() {
        return modalidad_puestotrabajo;
    }

    public void setModalidad_puestotrabajo(String modalidad_puestotrabajo) {
        this.modalidad_puestotrabajo = modalidad_puestotrabajo;
    }

    public String getTipojornada_puestotrabajo() {
        return tipojornada_puestotrabajo;
    }

    public void setTipojornada_puestotrabajo(String tipojornada_puestotrabajo) {
        this.tipojornada_puestotrabajo = tipojornada_puestotrabajo;
    }

    public String getSueldo_puestotrabajo() {
        return sueldo_puestotrabajo;
    }

    public void setSueldo_puestotrabajo(String sueldo_puestotrabajo) {
        this.sueldo_puestotrabajo = sueldo_puestotrabajo;
    }

    public int getExperiencia_puestotrabajo() {
        return experiencia_puestotrabajo;
    }

    public void setExperiencia_puestotrabajo(int experiencia_puestotrabajo) {
        this.experiencia_puestotrabajo = experiencia_puestotrabajo;
    }

    public int getPeriodoinicio_puestotrabajo() {
        return periodoinicio_puestotrabajo;
    }

    public void setPeriodoinicio_puestotrabajo(int periodoinicio_puestotrabajo) {
        this.periodoinicio_puestotrabajo = periodoinicio_puestotrabajo;
    }

    public String getDescripcion_puestotrabajo() {
        return descripcion_puestotrabajo;
    }

    public void setDescripcion_puestotrabajo(String descripcion_puestotrabajo) {
        this.descripcion_puestotrabajo = descripcion_puestotrabajo;
    }
}
