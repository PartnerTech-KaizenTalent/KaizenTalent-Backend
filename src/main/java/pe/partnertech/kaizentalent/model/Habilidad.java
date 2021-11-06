/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;

@Entity
@Table(name = "habilidad")
public class Habilidad {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad")
    private Long idHabilidad;

    @Column(name = "nombre_habilidad", length = 50)
    private String nombreHabilidad;

    @Column(name = "nivel_habilidad", length = 20)
    private String nivelHabilidad;

    @ManyToOne
    @JoinTable(name = "usuario_habilidades",
            joinColumns = @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioHabilidades;

    //Constructores
    public Habilidad() {
    }

    public Habilidad(String nombreHabilidad, String nivelHabilidad, Usuario usuarioHabilidades) {
        this.nombreHabilidad = nombreHabilidad;
        this.nivelHabilidad = nivelHabilidad;
        this.usuarioHabilidades = usuarioHabilidades;
    }

    //Getters y Setters
    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getNivelHabilidad() {
        return nivelHabilidad;
    }

    public void setNivelHabilidad(String nivelHabilidad) {
        this.nivelHabilidad = nivelHabilidad;
    }

    public Usuario getUsuarioHabilidades() {
        return usuarioHabilidades;
    }

    public void setUsuarioHabilidades(Usuario usuarioHabilidades) {
        this.usuarioHabilidades = usuarioHabilidades;
    }
}
