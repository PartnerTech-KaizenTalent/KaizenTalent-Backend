/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios_puestostrabajo")
public class UsuariosPuestosTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuariospuestostrabajo")
    private Long idUsuariosPuestosTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_puestotrabajo")
    private PuestoTrabajo puestotrabajo;

    //Constructores
    public UsuariosPuestosTrabajo() {
    }

    public UsuariosPuestosTrabajo(Usuario usuario, PuestoTrabajo puestotrabajo) {
        this.usuario = usuario;
        this.puestotrabajo = puestotrabajo;
    }

    //Getters y Setters
    public Long getIdUsuariosPuestosTrabajo() {
        return idUsuariosPuestosTrabajo;
    }

    public void setIdUsuariosPuestosTrabajo(Long idUsuariosPuestosTrabajo) {
        this.idUsuariosPuestosTrabajo = idUsuariosPuestosTrabajo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PuestoTrabajo getPuestotrabajo() {
        return puestotrabajo;
    }

    public void setPuestotrabajo(PuestoTrabajo puestotrabajo) {
        this.puestotrabajo = puestotrabajo;
    }
}
