/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conocimiento")
public class Conocimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conocimiento")
    private Long idConocimiento;

    @Column(name = "nombre_conocimiento", length = 50)
    private String nombreConocimiento;

    @Column(name = "nivel_conocimiento", length = 20)
    private String nivelConocimiento;

    @ManyToOne
    @JoinTable(name = "usuario_conocimientos",
            joinColumns = @JoinColumn(name = "id_conocimiento", referencedColumnName = "id_conocimiento"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioConocimiento;

    //Constructores
    public Conocimiento() {
    }

    public Conocimiento(String nombreConocimiento, String nivelConocimiento, Usuario usuarioConocimiento) {
        this.nombreConocimiento = nombreConocimiento;
        this.nivelConocimiento = nivelConocimiento;
        this.usuarioConocimiento = usuarioConocimiento;
    }

    //Getters y Setters
    public Long getIdConocimiento() {
        return idConocimiento;
    }

    public void setIdConocimiento(Long idConocimiento) {
        this.idConocimiento = idConocimiento;
    }

    public String getNombreConocimiento() {
        return nombreConocimiento;
    }

    public void setNombreConocimiento(String nombreConocimiento) {
        this.nombreConocimiento = nombreConocimiento;
    }

    public String getNivelConocimiento() {
        return nivelConocimiento;
    }

    public void setNivelConocimiento(String nivelConocimiento) {
        this.nivelConocimiento = nivelConocimiento;
    }

    public Usuario getUsuarioConocimiento() {
        return usuarioConocimiento;
    }

    public void setUsuarioConocimiento(Usuario usuarioConocimiento) {
        this.usuarioConocimiento = usuarioConocimiento;
    }
}
