/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "documentocv")
public class DocumentoCV implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documentocv")
    private Long idDocumentoCV;

    @Column(name = "nombre_documentocv")
    private String nombreDocumentoCV;

    @Column(name = "tipoarchivo_documentocv", length = 25)
    private String tipoarchivoDocumentoCV;

    @Column(name = "url_documentocv")
    private String urlDocumentoCV;

    @Column(name = "archivo_documentocv")
    private byte[] archivoDocumentoCV;

    @Column(name = "fechasubida_documentocv")
    private LocalDateTime fechasubidaDocumentoCV;

    @OneToOne
    @JoinTable(name = "usuario_documentocv",
            joinColumns = @JoinColumn(name = "id_documentocv", referencedColumnName = "id_documentocv"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"))
    private Usuario usuarioDocumentoCV;

    //Constructores
    public DocumentoCV() {
    }

    public DocumentoCV(String nombreDocumentoCV, String tipoarchivoDocumentoCV, String urlDocumentoCV,
                       byte[] archivoDocumentoCV, LocalDateTime fechasubidaDocumentoCV, Usuario usuarioDocumentoCV) {
        this.nombreDocumentoCV = nombreDocumentoCV;
        this.tipoarchivoDocumentoCV = tipoarchivoDocumentoCV;
        this.urlDocumentoCV = urlDocumentoCV;
        this.archivoDocumentoCV = archivoDocumentoCV;
        this.fechasubidaDocumentoCV = fechasubidaDocumentoCV;
        this.usuarioDocumentoCV = usuarioDocumentoCV;
    }

    //Getters y Setters
    public Long getIdDocumentoCV() {
        return idDocumentoCV;
    }

    public void setIdDocumentoCV(Long idDocumentoCV) {
        this.idDocumentoCV = idDocumentoCV;
    }

    public String getNombreDocumentoCV() {
        return nombreDocumentoCV;
    }

    public void setNombreDocumentoCV(String nombreDocumentoCV) {
        this.nombreDocumentoCV = nombreDocumentoCV;
    }

    public String getTipoarchivoDocumentoCV() {
        return tipoarchivoDocumentoCV;
    }

    public void setTipoarchivoDocumentoCV(String tipoarchivoDocumentoCV) {
        this.tipoarchivoDocumentoCV = tipoarchivoDocumentoCV;
    }

    public String getUrlDocumentoCV() {
        return urlDocumentoCV;
    }

    public void setUrlDocumentoCV(String urlDocumentoCV) {
        this.urlDocumentoCV = urlDocumentoCV;
    }

    public byte[] getArchivoDocumentoCV() {
        return archivoDocumentoCV;
    }

    public void setArchivoDocumentoCV(byte[] archivoDocumentoCV) {
        this.archivoDocumentoCV = archivoDocumentoCV;
    }

    public LocalDateTime getFechasubidaDocumentoCV() {
        return fechasubidaDocumentoCV;
    }

    public void setFechasubidaDocumentoCV(LocalDateTime fechasubidaDocumentoCV) {
        this.fechasubidaDocumentoCV = fechasubidaDocumentoCV;
    }

    public Usuario getUsuarioDocumentoCV() {
        return usuarioDocumentoCV;
    }

    public void setUsuarioDocumentoCV(Usuario usuarioDocumentoCV) {
        this.usuarioDocumentoCV = usuarioDocumentoCV;
    }
}
