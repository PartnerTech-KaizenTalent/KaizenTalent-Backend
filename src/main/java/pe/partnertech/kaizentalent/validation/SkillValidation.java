/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.validation;

public class SkillValidation {

    //Atributos
    private Long idPostulante;

    private String nombreSkill;

    private String nivelSkill;

    //Constructores
    public SkillValidation() {
    }

    public SkillValidation(Long idPostulante, String nombreSkill, String nivelSkill) {
        this.idPostulante = idPostulante;
        this.nombreSkill = nombreSkill;
        this.nivelSkill = nivelSkill;
    }

    //Getters y Setters
    public Long getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Long idPostulante) {
        this.idPostulante = idPostulante;
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
