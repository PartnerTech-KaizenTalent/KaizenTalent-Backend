/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "experiencialaboral")
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencialaboral")
    private Long idExperienciaLaboral;

    @Column(name = "nombre_experiencialaboral", length = 150)
    private String nombreExperienciaLaboral;

    @Column(name = "empresa_experiencialaboral", length = 150)
    private String empresaExperienciaLaboral;

    @Column(name = "mesinicio_experiencialaboral")
    private String mesinicioExperienciaLaboral;

    @Column(name = "añoinicio_experiencialaboral")
    private String anioinicioExperienciaLaboral;

    @Column(name = "mesfin_experiencialaboral")
    private String mesfinExperienciaLaboral;

    @Column(name = "añofin_experiencialaboral")
    private String aniofinExperienciaLaboral;

    @Column(name = "descripcion_experiencialaboral", columnDefinition = "text")
    private String descripcionExperienciaLaboral;

    @Column(name = "referente_referencialaboral", length = 100)
    private String referenteReferenciaLaboral;

    @Column(name = "emailreferente_referencialaboral", length = 60)
    private String emailreferenteReferenciaLaboral;

    @Column(name = "telefonoreferente_referencialaboral", length = 20)
    private String telefonoreferenteReferenciaLaboral;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "experiencialaboralImagen")
    private Imagen imagenExperienciaLaboral;

    @ManyToOne
    @JoinTable(name = "usuario_experienciaslaborales",
            joinColumns = @JoinColumn(name = "id_experiencialaboral", referencedColumnName = "id_experiencialaboral"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioExperienciaLaboral;

    //Constructores
    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreExperienciaLaboral, String empresaExperienciaLaboral,
                              String mesinicioExperienciaLaboral, String anioinicioExperienciaLaboral,
                              String mesfinExperienciaLaboral, String aniofinExperienciaLaboral,
                              String descripcionExperienciaLaboral, String referenteReferenciaLaboral,
                              String emailreferenteReferenciaLaboral, String telefonoreferenteReferenciaLaboral,
                              Imagen imagenExperienciaLaboral, Usuario usuarioExperienciaLaboral) {
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
        this.referenteReferenciaLaboral = referenteReferenciaLaboral;
        this.emailreferenteReferenciaLaboral = emailreferenteReferenciaLaboral;
        this.telefonoreferenteReferenciaLaboral = telefonoreferenteReferenciaLaboral;
        this.imagenExperienciaLaboral = imagenExperienciaLaboral;
        this.usuarioExperienciaLaboral = usuarioExperienciaLaboral;
    }

    //Getters y Setters
    public Long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public String getNombreExperienciaLaboral() {
        return nombreExperienciaLaboral;
    }

    public void setNombreExperienciaLaboral(String nombreExperienciaLaboral) {
        this.nombreExperienciaLaboral = nombreExperienciaLaboral;
    }

    public String getEmpresaExperienciaLaboral() {
        return empresaExperienciaLaboral;
    }

    public void setEmpresaExperienciaLaboral(String empresaExperienciaLaboral) {
        this.empresaExperienciaLaboral = empresaExperienciaLaboral;
    }

    public String getMesinicioExperienciaLaboral() {
        return mesinicioExperienciaLaboral;
    }

    public void setMesinicioExperienciaLaboral(String mesinicioExperienciaLaboral) {
        this.mesinicioExperienciaLaboral = mesinicioExperienciaLaboral;
    }

    public String getAnioinicioExperienciaLaboral() {
        return anioinicioExperienciaLaboral;
    }

    public void setAnioinicioExperienciaLaboral(String anioinicioExperienciaLaboral) {
        this.anioinicioExperienciaLaboral = anioinicioExperienciaLaboral;
    }

    public String getMesfinExperienciaLaboral() {
        return mesfinExperienciaLaboral;
    }

    public void setMesfinExperienciaLaboral(String mesfinExperienciaLaboral) {
        this.mesfinExperienciaLaboral = mesfinExperienciaLaboral;
    }

    public String getAniofinExperienciaLaboral() {
        return aniofinExperienciaLaboral;
    }

    public void setAniofinExperienciaLaboral(String aniofinExperienciaLaboral) {
        this.aniofinExperienciaLaboral = aniofinExperienciaLaboral;
    }

    public String getDescripcionExperienciaLaboral() {
        return descripcionExperienciaLaboral;
    }

    public void setDescripcionExperienciaLaboral(String descripcionExperienciaLaboral) {
        this.descripcionExperienciaLaboral = descripcionExperienciaLaboral;
    }

    public String getReferenteReferenciaLaboral() {
        return referenteReferenciaLaboral;
    }

    public void setReferenteReferenciaLaboral(String referenteReferenciaLaboral) {
        this.referenteReferenciaLaboral = referenteReferenciaLaboral;
    }

    public String getEmailreferenteReferenciaLaboral() {
        return emailreferenteReferenciaLaboral;
    }

    public void setEmailreferenteReferenciaLaboral(String emailreferenteReferenciaLaboral) {
        this.emailreferenteReferenciaLaboral = emailreferenteReferenciaLaboral;
    }

    public String getTelefonoreferenteReferenciaLaboral() {
        return telefonoreferenteReferenciaLaboral;
    }

    public void setTelefonoreferenteReferenciaLaboral(String telefonoreferenteReferenciaLaboral) {
        this.telefonoreferenteReferenciaLaboral = telefonoreferenteReferenciaLaboral;
    }

    public Imagen getImagenExperienciaLaboral() {
        return imagenExperienciaLaboral;
    }

    public void setImagenExperienciaLaboral(Imagen imagenExperienciaLaboral) {
        this.imagenExperienciaLaboral = imagenExperienciaLaboral;
    }

    public Usuario getUsuarioExperienciaLaboral() {
        return usuarioExperienciaLaboral;
    }

    public void setUsuarioExperienciaLaboral(Usuario usuarioExperienciaLaboral) {
        this.usuarioExperienciaLaboral = usuarioExperienciaLaboral;
    }
}
