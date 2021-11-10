/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting;

public class SkillFilterHeadhuntingResponse {

    //Atributos
    String skill;

    //Constructores
    public SkillFilterHeadhuntingResponse() {
    }

    public SkillFilterHeadhuntingResponse(String skill) {
        this.skill = skill;
    }

    //Getters y Setters
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
