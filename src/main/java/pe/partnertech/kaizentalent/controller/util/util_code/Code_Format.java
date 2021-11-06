/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

public class Code_Format {

    public static String FormatExperienciaLaboral(int experiencia) {
        String experiencia_laboral;

        if (experiencia == 0) {
            experiencia_laboral = "Sin Experiencia";
        } else if (experiencia == 3) {
            experiencia_laboral = "3 Meses";
        } else if (experiencia == 6) {
            experiencia_laboral = "6 Meses";
        } else if (experiencia == 12) {
            experiencia_laboral = "1 Año";
        } else if (experiencia > 12) {
            experiencia_laboral = (experiencia / 12) + " Años";
        } else {
            experiencia_laboral = "";
        }

        return experiencia_laboral;
    }
}
