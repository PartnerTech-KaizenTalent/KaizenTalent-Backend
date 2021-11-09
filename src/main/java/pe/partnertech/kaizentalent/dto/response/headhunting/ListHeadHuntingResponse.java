/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.dto.response.headhunting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.partnertech.kaizentalent.dto.response.general.ImagenResponse;
import pe.partnertech.kaizentalent.model.*;

import java.time.LocalDate;
import java.util.Set;

public class ListHeadHuntingResponse {

    //Atributos
    private Long idPostulante;
    private ImagenResponse fotoperfilPostulante;
    private String sueldoPostulante;
    private String nombrePostulante;

    //TODO: Experiencia Laboral Actual
    //TODO: Educacion Actual

    private String tituloPostulante;
    private String telefonoPostulante;
    private String ciudadPostulante;

    @JsonIgnore
    private Set<Educacion> listEducaciones;
    private String[] institucionesPostulante;

    @JsonIgnore
    private Set<Conocimiento> listConocimientos;
    private String  conocimientosPostulante;

    @JsonIgnore
    private Set<Habilidad> listHabilidades;
    private String habilidadesPostulante;

    @JsonIgnore
    private Set<Idioma> listIdiomas;
    private String idiomasPostulante;

    @JsonIgnore
    LocalDate fechanacimientoPostulante;

    long edadPostulante;

    //Constructores
    public ListHeadHuntingResponse() {
    }

    public ListHeadHuntingResponse(Long idPostulante, ImagenResponse fotoperfilPostulante, String sueldoPostulante,
                                   String nombrePostulante, String tituloPostulante, String telefonoPostulante,
                                   String ciudadPostulante, Set<Educacion> listEducaciones,
                                   String[] institucionesPostulante,
                                   Set<Conocimiento> listConocimientos, String conocimientosPostulante,
                                   Set<Habilidad> listHabilidades, String habilidadesPostulante, Set<Idioma> listIdiomas,
                                   String idiomasPostulante, LocalDate fechanacimientoPostulante, long edadPostulante) {
        this.idPostulante = idPostulante;
        this.fotoperfilPostulante = fotoperfilPostulante;
        this.sueldoPostulante = sueldoPostulante;
        this.nombrePostulante = nombrePostulante;
        this.tituloPostulante = tituloPostulante;
        this.telefonoPostulante = telefonoPostulante;
        this.ciudadPostulante = ciudadPostulante;
        this.listEducaciones = listEducaciones;
        this.institucionesPostulante = institucionesPostulante;
        this.listConocimientos = listConocimientos;
        this.conocimientosPostulante = conocimientosPostulante;
        this.listHabilidades = listHabilidades;
        this.habilidadesPostulante = habilidadesPostulante;
        this.listIdiomas = listIdiomas;
        this.idiomasPostulante = idiomasPostulante;
        this.fechanacimientoPostulante = fechanacimientoPostulante;
        this.edadPostulante = edadPostulante;
    }

    //Getters y Setters

    public Long getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Long idPostulante) {
        this.idPostulante = idPostulante;
    }

    public ImagenResponse getFotoperfilPostulante() {
        return fotoperfilPostulante;
    }

    public void setFotoperfilPostulante(ImagenResponse fotoperfilPostulante) {
        this.fotoperfilPostulante = fotoperfilPostulante;
    }

    public String getSueldoPostulante() {
        return sueldoPostulante;
    }

    public void setSueldoPostulante(String sueldoPostulante) {
        this.sueldoPostulante = sueldoPostulante;
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

    public Set<Educacion> getListEducaciones() {
        return listEducaciones;
    }

    public void setListEducaciones(Set<Educacion> listEducaciones) {
        this.listEducaciones = listEducaciones;
    }

    public String[] getInstitucionesPostulante() {
        return institucionesPostulante;
    }

    public void setInstitucionesPostulante(String[] institucionesPostulante) {
        this.institucionesPostulante = institucionesPostulante;
    }

    public Set<Conocimiento> getListConocimientos() {
        return listConocimientos;
    }

    public void setListConocimientos(Set<Conocimiento> listConocimientos) {
        this.listConocimientos = listConocimientos;
    }

    public String getConocimientosPostulante() {
        return conocimientosPostulante;
    }

    public void setConocimientosPostulante(String conocimientosPostulante) {
        this.conocimientosPostulante = conocimientosPostulante;
    }

    public Set<Habilidad> getListHabilidades() {
        return listHabilidades;
    }

    public void setListHabilidades(Set<Habilidad> listHabilidades) {
        this.listHabilidades = listHabilidades;
    }

    public String getHabilidadesPostulante() {
        return habilidadesPostulante;
    }

    public void setHabilidadesPostulante(String habilidadesPostulante) {
        this.habilidadesPostulante = habilidadesPostulante;
    }

    public Set<Idioma> getListIdiomas() {
        return listIdiomas;
    }

    public void setListIdiomas(Set<Idioma> listIdiomas) {
        this.listIdiomas = listIdiomas;
    }

    public String getIdiomasPostulante() {
        return idiomasPostulante;
    }

    public void setIdiomasPostulante(String idiomasPostulante) {
        this.idiomasPostulante = idiomasPostulante;
    }

    public LocalDate getFechanacimientoPostulante() {
        return fechanacimientoPostulante;
    }

    public void setFechanacimientoPostulante(LocalDate fechanacimientoPostulante) {
        this.fechanacimientoPostulante = fechanacimientoPostulante;
    }

    public long getEdadPostulante() {
        return edadPostulante;
    }

    public void setEdadPostulante(long edadPostulante) {
        this.edadPostulante = edadPostulante;
    }
}
