/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class BasicInfoPostulanteResponse {

    //Atributos
    private String nombrePostulante;

    private String apellidoPostulante;

    private String direccionPostulante;

    private String emailPostulante;

    private String telefonoPostulante;

    private String ciudadPostulante;

    private String descripcionPostulante;

    private String tituloPostulante;

    private ImagenResponse fotoperfilPostulante;

    private DocumentoCVResponse documentocvPostulante;

    //Constructores
    public BasicInfoPostulanteResponse() {
    }

    public BasicInfoPostulanteResponse(String nombrePostulante, String apellidoPostulante, String direccionPostulante,
                                       String emailPostulante, String telefonoPostulante, String ciudadPostulante,
                                       String descripcionPostulante, String tituloPostulante,
                                       ImagenResponse fotoperfilPostulante, DocumentoCVResponse documentocvPostulante) {
        this.nombrePostulante = nombrePostulante;
        this.apellidoPostulante = apellidoPostulante;
        this.direccionPostulante = direccionPostulante;
        this.emailPostulante = emailPostulante;
        this.telefonoPostulante = telefonoPostulante;
        this.ciudadPostulante = ciudadPostulante;
        this.descripcionPostulante = descripcionPostulante;
        this.tituloPostulante = tituloPostulante;
        this.fotoperfilPostulante = fotoperfilPostulante;
        this.documentocvPostulante = documentocvPostulante;
    }

    //Getters y Setters
    public String getNombrePostulante() {
        return nombrePostulante;
    }

    public void setNombrePostulante(String nombrePostulante) {
        this.nombrePostulante = nombrePostulante;
    }

    public String getApellidoPostulante() {
        return apellidoPostulante;
    }

    public void setApellidoPostulante(String apellidoPostulante) {
        this.apellidoPostulante = apellidoPostulante;
    }

    public String getDireccionPostulante() {
        return direccionPostulante;
    }

    public void setDireccionPostulante(String direccionPostulante) {
        this.direccionPostulante = direccionPostulante;
    }

    public String getEmailPostulante() {
        return emailPostulante;
    }

    public void setEmailPostulante(String emailPostulante) {
        this.emailPostulante = emailPostulante;
    }

    public String getTelefonoPostulante() {
        return telefonoPostulante;
    }

    public void setTelefonoPostulante(String telefonoPostulante) {
        this.telefonoPostulante = telefonoPostulante;
    }

    public String getCiudadPostulante() {
        return ciudadPostulante;
    }

    public void setCiudadPostulante(String ciudadPostulante) {
        this.ciudadPostulante = ciudadPostulante;
    }

    public String getDescripcionPostulante() {
        return descripcionPostulante;
    }

    public void setDescripcionPostulante(String descripcionPostulante) {
        this.descripcionPostulante = descripcionPostulante;
    }

    public String getTituloPostulante() {
        return tituloPostulante;
    }

    public void setTituloPostulante(String tituloPostulante) {
        this.tituloPostulante = tituloPostulante;
    }

    public ImagenResponse getFotoperfilPostulante() {
        return fotoperfilPostulante;
    }

    public void setFotoperfilPostulante(ImagenResponse fotoperfilPostulante) {
        this.fotoperfilPostulante = fotoperfilPostulante;
    }

    public DocumentoCVResponse getDocumentocvPostulante() {
        return documentocvPostulante;
    }

    public void setDocumentocvPostulante(DocumentoCVResponse documentocvPostulante) {
        this.documentocvPostulante = documentocvPostulante;
    }
}
