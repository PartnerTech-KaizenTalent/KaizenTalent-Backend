/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.reclutador;

import java.util.Set;

public class PublicacionResponse {

    //Atributos
    String nombrePublicacion;

    Set<PostulantesPublicacionResponse> postulantesPublicacion;

    //Constructores
    public PublicacionResponse() {
    }

    public PublicacionResponse(String nombrePublicacion, Set<PostulantesPublicacionResponse> postulantesPublicacion) {
        this.nombrePublicacion = nombrePublicacion;
        this.postulantesPublicacion = postulantesPublicacion;
    }

    //Getters y Setters
    public String getNombrePublicacion() {
        return nombrePublicacion;
    }

    public void setNombrePublicacion(String nombrePublicacion) {
        this.nombrePublicacion = nombrePublicacion;
    }

    public Set<PostulantesPublicacionResponse> getPostulantesPublicacion() {
        return postulantesPublicacion;
    }

    public void setPostulantesPublicacion(Set<PostulantesPublicacionResponse> postulantesPublicacion) {
        this.postulantesPublicacion = postulantesPublicacion;
    }
}
