/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.general;

public class DocumentoCVResponse {

    //Atributos
    private String nombreDocumentoCV;
    private String urlDocumentoCV;

    //Constructores
    public DocumentoCVResponse() {
    }

    public DocumentoCVResponse(String nombreDocumentoCV, String urlDocumentoCV) {
        this.nombreDocumentoCV = nombreDocumentoCV;
        this.urlDocumentoCV = urlDocumentoCV;
    }

    //Getters y Setters
    public String getNombreDocumentoCV() {
        return nombreDocumentoCV;
    }

    public void setNombreDocumentoCV(String nombreDocumentoCV) {
        this.nombreDocumentoCV = nombreDocumentoCV;
    }

    public String getUrlDocumentoCV() {
        return urlDocumentoCV;
    }

    public void setUrlDocumentoCV(String urlDocumentoCV) {
        this.urlDocumentoCV = urlDocumentoCV;
    }
}
