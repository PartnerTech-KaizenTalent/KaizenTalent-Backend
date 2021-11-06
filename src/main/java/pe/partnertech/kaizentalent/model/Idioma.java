/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "idioma")
public class Idioma implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Long idIdioma;

    @Column(name = "nombre_idioma", length = 50)
    private String nombreIdioma;

    @Column(name = "nivel_idioma", length = 20)
    private String nivelIdioma;

    @ManyToOne
    @JoinTable(name = "usuario_idiomas",
            joinColumns = @JoinColumn(name = "id_idioma", referencedColumnName = "id_idioma"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioIdioma;

    //Constructores
    public Idioma() {
    }

    public Idioma(String nombreIdioma, String nivelIdioma, Usuario usuarioIdioma) {
        this.nombreIdioma = nombreIdioma;
        this.nivelIdioma = nivelIdioma;
        this.usuarioIdioma = usuarioIdioma;
    }

    //Getters y Setters
    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public String getNivelIdioma() {
        return nivelIdioma;
    }

    public void setNivelIdioma(String nivelIdioma) {
        this.nivelIdioma = nivelIdioma;
    }

    public Usuario getUsuarioIdioma() {
        return usuarioIdioma;
    }

    public void setUsuarioIdioma(Usuario usuarioIdioma) {
        this.usuarioIdioma = usuarioIdioma;
    }
}
