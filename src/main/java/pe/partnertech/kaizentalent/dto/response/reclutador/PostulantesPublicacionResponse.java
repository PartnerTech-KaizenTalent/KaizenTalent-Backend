/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.reclutador;

import pe.partnertech.kaizentalent.dto.response.general.DocumentoCVResponse;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;

public class PostulantesPublicacionResponse {

    //Atributos
    private Long idPostulante;

    private String nombrePostulante;

    private String tituloPostulante;

    private String ciudadPostulante;

    private ImagenResponse fotoPostulante;

    private DocumentoCVResponse cvPostulante;

    //Constructores
    public PostulantesPublicacionResponse() {
    }

    public PostulantesPublicacionResponse(Long idPostulante, String nombrePostulante, String tituloPostulante,
                                          String ciudadPostulante, ImagenResponse fotoPostulante,
                                          DocumentoCVResponse cvPostulante) {
        this.idPostulante = idPostulante;
        this.nombrePostulante = nombrePostulante;
        this.tituloPostulante = tituloPostulante;
        this.ciudadPostulante = ciudadPostulante;
        this.fotoPostulante = fotoPostulante;
        this.cvPostulante = cvPostulante;
    }

    //Getters y Setters
    public Long getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Long idPostulante) {
        this.idPostulante = idPostulante;
    }

    public String getNombrePostulante() {
        return nombrePostulante;
    }

    public void setNombrePostulante(String nombrePostulante) {
        this.nombrePostulante = nombrePostulante;
    }

    public String getTituloPostulante() {
        return tituloPostulante;
    }

    public void setTituloPostulante(String tituloPostulante) {
        this.tituloPostulante = tituloPostulante;
    }

    public String getCiudadPostulante() {
        return ciudadPostulante;
    }

    public void setCiudadPostulante(String ciudadPostulante) {
        this.ciudadPostulante = ciudadPostulante;
    }

    public ImagenResponse getFotoPostulante() {
        return fotoPostulante;
    }

    public void setFotoPostulante(ImagenResponse fotoPostulante) {
        this.fotoPostulante = fotoPostulante;
    }

    public DocumentoCVResponse getCvPostulante() {
        return cvPostulante;
    }

    public void setCvPostulante(DocumentoCVResponse cvPostulante) {
        this.cvPostulante = cvPostulante;
    }
}
