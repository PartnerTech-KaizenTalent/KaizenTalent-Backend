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

    public static String ConvierteMes(String valor_mes) {

        String mes_formateado;

        switch (valor_mes) {
            case "1":
            case "01":
                mes_formateado = "Enero";
                break;
            case "2":
            case "02":
                mes_formateado = "Febrero";
                break;
            case "3":
            case "03":
                mes_formateado = "Marzo";
                break;
            case "4":
            case "04":
                mes_formateado = "Abril";
                break;
            case "5":
            case "05":
                mes_formateado = "Mayo";
                break;
            case "6":
            case "06":
                mes_formateado = "Junio";
                break;
            case "7":
            case "07":
                mes_formateado = "Julio";
                break;
            case "8":
            case "08":
                mes_formateado = "Agosto";
                break;
            case "9":
            case "09":
                mes_formateado = "Septiembre";
                break;
            case "10":
                mes_formateado = "Octubre";
                break;
            case "11":
                mes_formateado = "Noviembre";
                break;
            case "12":
                mes_formateado = "Diciembre";
                break;
            default:
                mes_formateado = "";
                break;
        }

        return mes_formateado;
    }
}
