/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "educacion")
public class Educacion implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_educacion")
    private Long idEducacion;

    @Column(name = "institucion_educacion", length = 100)
    private String institucionEducacion;

    @Column(name = "mesinicio_educacion")
    private String mesinicioEducacion;

    @Column(name = "añoinicio_educacion")
    private String anioinicioEducacion;

    @Column(name = "mesfin_educacion")
    private String mesfinEducacion;

    @Column(name = "añofin_educacion")
    private String aniofinEducacion;

    @Column(name = "nombre_educacion", length = 100)
    private String nombreEducacion;

    @Column(name = "nivel_educacion")
    private String nivelEducacion;

    @Column(name = "estado_educacion")
    private String estadoEducacion;

    @ManyToOne
    @JoinTable(name = "usuario_educaciones",
            joinColumns = @JoinColumn(name = "id_educacion", referencedColumnName = "id_educacion"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioEducacion;

    //Constructores
    public Educacion() {
    }

    public Educacion(Long idEducacion, String institucionEducacion, String mesinicioEducacion, String anioinicioEducacion,
                     String mesfinEducacion, String aniofinEducacion, String nombreEducacion, String nivelEducacion,
                     String estadoEducacion, Usuario usuarioEducacion) {
        this.idEducacion = idEducacion;
        this.institucionEducacion = institucionEducacion;
        this.mesinicioEducacion = mesinicioEducacion;
        this.anioinicioEducacion = anioinicioEducacion;
        this.mesfinEducacion = mesfinEducacion;
        this.aniofinEducacion = aniofinEducacion;
        this.nombreEducacion = nombreEducacion;
        this.nivelEducacion = nivelEducacion;
        this.estadoEducacion = estadoEducacion;
        this.usuarioEducacion = usuarioEducacion;
    }

    //Getters y Setters
    public Long getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Long idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucionEducacion() {
        return institucionEducacion;
    }

    public void setInstitucionEducacion(String institucionEducacion) {
        this.institucionEducacion = institucionEducacion;
    }

    public String getMesinicioEducacion() {
        return mesinicioEducacion;
    }

    public void setMesinicioEducacion(String mesinicioEducacion) {
        this.mesinicioEducacion = mesinicioEducacion;
    }

    public String getAnioinicioEducacion() {
        return anioinicioEducacion;
    }

    public void setAnioinicioEducacion(String anioinicioEducacion) {
        this.anioinicioEducacion = anioinicioEducacion;
    }

    public String getMesfinEducacion() {
        return mesfinEducacion;
    }

    public void setMesfinEducacion(String mesfinEducacion) {
        this.mesfinEducacion = mesfinEducacion;
    }

    public String getAniofinEducacion() {
        return aniofinEducacion;
    }

    public void setAniofinEducacion(String aniofinEducacion) {
        this.aniofinEducacion = aniofinEducacion;
    }

    public String getNombreEducacion() {
        return nombreEducacion;
    }

    public void setNombreEducacion(String nombreEducacion) {
        this.nombreEducacion = nombreEducacion;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public String getEstadoEducacion() {
        return estadoEducacion;
    }

    public void setEstadoEducacion(String estadoEducacion) {
        this.estadoEducacion = estadoEducacion;
    }

    public Usuario getUsuarioEducacion() {
        return usuarioEducacion;
    }

    public void setUsuarioEducacion(Usuario usuarioEducacion) {
        this.usuarioEducacion = usuarioEducacion;
    }
}
