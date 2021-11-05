/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.profile.postulante;

public class SkillPostulanteResponse {

    //Atributos
    private Long idSkill;

    private String nombreSkill;

    private String nivelSkill;

    //Constructores
    public SkillPostulanteResponse() {
    }

    public SkillPostulanteResponse(Long idSkill, String nombreSkill, String nivelSkill) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.nivelSkill = nivelSkill;
    }

    //Getters y Setters
    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getNivelSkill() {
        return nivelSkill;
    }

    public void setNivelSkill(String nivelSkill) {
        this.nivelSkill = nivelSkill;
    }
}
