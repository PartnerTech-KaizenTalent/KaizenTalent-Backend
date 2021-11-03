/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "puestotrabajo")
public class PuestoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puestotrabajo")
    private Long idPuestoTrabajo;

    @Column(name = "nombre_puestotrabajo", length = 150)
    private String nombrePuestoTrabajo;

    @Column(name = "ciudad_puestotrabajo", length = 50)
    private String ciudadPuestoTrabajo;

    @Column(name = "categoria_puestotrabajo", length = 50)
    private String categoriaPuestoTrabajo;

    @Column(name = "modalidad_puestotrabajo", length = 50)
    private String modalidadPuestoTrabajo;

    @Column(name = "tipojornada_puestotrabajo", length = 50)
    private String tipojornadaPuestoTrabajo;

    @Column(name = "sueldo_puestotrabajo", length = 50)
    private String sueldoPuestoTrabajo;

    @Column(name = "experiencia_puestotrabajo")
    private int experienciaPuestoTrabajo;

    @Column(name = "fecharegistro_puestotrabajo")
    private LocalDateTime fecharegistroPuestoTrabajo;

    @Column(name = "fechacaducidad_puestotrabajo")
    private LocalDateTime fechacaducidadPuestoTrabajo;

    @Column(name = "periodoinicio_puestotrabajo")
    private int periodoinicioPuestoTrabajo;

    @Column(name = "periodoactual_puestotrabajo")
    private int periodoactualPuestoTrabajo;

    @Column(name = "descripcion_puestotrabajo", columnDefinition = "text")
    private String descripcionPuestoTrabajo;

    @Column(name = "estado_puestotrabajo")
    private String estadoPuestoTrabajo;

    @OneToMany(mappedBy = "puestotrabajo")
    private Set<UsuariosPuestosTrabajo> usuariosPuestoTrabajo;

    //Constructores
    public PuestoTrabajo() {
    }

    public PuestoTrabajo(String nombrePuestoTrabajo, String ciudadPuestoTrabajo, String categoriaPuestoTrabajo,
                         String modalidadPuestoTrabajo, String tipojornadaPuestoTrabajo, String sueldoPuestoTrabajo,
                         int experienciaPuestoTrabajo, int periodoinicioPuestoTrabajo, String descripcionPuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.ciudadPuestoTrabajo = ciudadPuestoTrabajo;
        this.categoriaPuestoTrabajo = categoriaPuestoTrabajo;
        this.modalidadPuestoTrabajo = modalidadPuestoTrabajo;
        this.tipojornadaPuestoTrabajo = tipojornadaPuestoTrabajo;
        this.sueldoPuestoTrabajo = sueldoPuestoTrabajo;
        this.experienciaPuestoTrabajo = experienciaPuestoTrabajo;
        this.periodoinicioPuestoTrabajo = periodoinicioPuestoTrabajo;
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

    public LocalDateTime getFecharegistroPuestoTrabajo() {
        return fecharegistroPuestoTrabajo;
    }

    public void setFecharegistroPuestoTrabajo(LocalDateTime fecharegistroPuestoTrabajo) {
        this.fecharegistroPuestoTrabajo = fecharegistroPuestoTrabajo;
    }

    public LocalDateTime getFechacaducidadPuestoTrabajo() {
        return fechacaducidadPuestoTrabajo;
    }

    public void setFechacaducidadPuestoTrabajo(LocalDateTime fechacaducidadPuestoTrabajo) {
        this.fechacaducidadPuestoTrabajo = fechacaducidadPuestoTrabajo;
    }

    public int getPeriodoinicioPuestoTrabajo() {
        return periodoinicioPuestoTrabajo;
    }

    public void setPeriodoinicioPuestoTrabajo(int periodoinicioPuestoTrabajo) {
        this.periodoinicioPuestoTrabajo = periodoinicioPuestoTrabajo;
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

    public String getEstadoPuestoTrabajo() {
        return estadoPuestoTrabajo;
    }

    public void setEstadoPuestoTrabajo(String estadoPuestoTrabajo) {
        this.estadoPuestoTrabajo = estadoPuestoTrabajo;
    }

    public Set<UsuariosPuestosTrabajo> getUsuariosPuestoTrabajo() {
        return usuariosPuestoTrabajo;
    }

    public void setUsuariosPuestoTrabajo(Set<UsuariosPuestosTrabajo> usuariosPuestoTrabajo) {
        this.usuariosPuestoTrabajo = usuariosPuestoTrabajo;
    }
}
