/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", length = 50)
    private String nombreUsuario;

    @Column(name = "apellido_usuario", length = 50)
    private String apellidoUsuario;

    @Column(name = "ciudad_usuario", length = 40)
    private String ciudadUsuario;

    @Column(name = "email_usuario", length = 40)
    private String emailUsuario;

    @Column(name = "telefono_usuario", length = 15)
    private String telefonoUsuario;

    @Column(name = "tipodocumento_usuario", length = 30)
    private String tipodocumentoUsuario;

    @Column(name = "numerodocumento_usuario", length = 12)
    private String numerodocumentoUsuario;

    @Column(name = "username_usuario", length = 50)
    private String usernameUsuario;

    @Column(name = "password_usuario")
    private String passwordUsuario;

    @Column(name = "estado_usuario")
    private String estadoUsuario;

    @Column(name = "fecharegistro_usuario")
    private LocalDate fecharegistroUsuario;

    @Column(name = "genero_usuario", length = 20)
    private String generoUsuario;

    @Column(name = "titulo_usuario", length = 50)
    private String tituloUsuario;

    @Column(name = "contactante_usuario", length = 100)
    private String contactanteempresaUsuario;

    @Column(name = "tamañoempresa_usuario", length = 40)
    private String tamanioempresaUsuario;

    @Column(name = "direccion_usuario", length = 150)
    private String direccionUsuario;

    @Column(name = "descripcion_usuario", columnDefinition = "text")
    private String descripcionUsuario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "fechanacimiento_usuario")
    private LocalDate fechanacimientoUsuario;

    @Column(name = "sueldo_usuario")
    private String sueldoUsuario;

    @ManyToMany
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private Set<Rol> rolesUsuario = new HashSet<>();

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioUtilityToken")
    private Set<UtilityToken> utilitytokensUsuario;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioConocimiento")
    private Set<Conocimiento> conocimientosUsuario;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioEducacion")
    private Set<Educacion> educacionesUsuario;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioExperienciaLaboral")
    private Set<ExperienciaLaboral> experienciaslaboralesUsuario;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioHabilidad")
    private Set<Habilidad> habilidadesUsuario;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioIdioma")
    private Set<Idioma> idiomasUsuario;

    @OneToMany(mappedBy = "usuario")
    private Set<UsuariosPuestosTrabajo> puestostrabajoUsuario;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioImagen")
    private Imagen imagenUsuario;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "usuarioDocumentoCV")
    private DocumentoCV documentoCVUsuario;

    //Constructores
    public Usuario() {
    }

    //---Postulante
    public Usuario(String nombreUsuario, String apellidoUsuario, String ciudadUsuario, String emailUsuario,
                   String tipodocumentoUsuario, String numerodocumentoUsuario, String usernameUsuario,
                   String passwordUsuario, String generoUsuario, LocalDate fechanacimientoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.emailUsuario = emailUsuario;
        this.tipodocumentoUsuario = tipodocumentoUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.generoUsuario = generoUsuario;
        this.fechanacimientoUsuario = fechanacimientoUsuario;
    }

    //---Reclutador
    public Usuario(String nombreUsuario, String ciudadUsuario, String emailUsuario, String numerodocumentoUsuario,
                   String usernameUsuario, String passwordUsuario, String contactanteempresaUsuario,
                   String tamanioempresaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.emailUsuario = emailUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.contactanteempresaUsuario = contactanteempresaUsuario;
        this.tamanioempresaUsuario = tamanioempresaUsuario;
    }

    //Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCiudadUsuario() {
        return ciudadUsuario;
    }

    public void setCiudadUsuario(String ciudadUsuario) {
        this.ciudadUsuario = ciudadUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getTipodocumentoUsuario() {
        return tipodocumentoUsuario;
    }

    public void setTipodocumentoUsuario(String tipodocumentoUsuario) {
        this.tipodocumentoUsuario = tipodocumentoUsuario;
    }

    public String getNumerodocumentoUsuario() {
        return numerodocumentoUsuario;
    }

    public void setNumerodocumentoUsuario(String numerodocumentoUsuario) {
        this.numerodocumentoUsuario = numerodocumentoUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public LocalDate getFecharegistroUsuario() {
        return fecharegistroUsuario;
    }

    public void setFecharegistroUsuario(LocalDate fecharegistroUsuario) {
        this.fecharegistroUsuario = fecharegistroUsuario;
    }

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public String getTituloUsuario() {
        return tituloUsuario;
    }

    public void setTituloUsuario(String tituloUsuario) {
        this.tituloUsuario = tituloUsuario;
    }

    public String getContactanteempresaUsuario() {
        return contactanteempresaUsuario;
    }

    public void setContactanteempresaUsuario(String contactanteempresaUsuario) {
        this.contactanteempresaUsuario = contactanteempresaUsuario;
    }

    public String getTamanioempresaUsuario() {
        return tamanioempresaUsuario;
    }

    public void setTamanioempresaUsuario(String tamanioempresaUsuario) {
        this.tamanioempresaUsuario = tamanioempresaUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getDescripcionUsuario() {
        return descripcionUsuario;
    }

    public void setDescripcionUsuario(String descripcionUsuario) {
        this.descripcionUsuario = descripcionUsuario;
    }

    public LocalDate getFechanacimientoUsuario() {
        return fechanacimientoUsuario;
    }

    public void setFechanacimientoUsuario(LocalDate fechanacimientoUsuario) {
        this.fechanacimientoUsuario = fechanacimientoUsuario;
    }

    public String getSueldoUsuario() {
        return sueldoUsuario;
    }

    public void setSueldoUsuario(String sueldoUsuario) {
        this.sueldoUsuario = sueldoUsuario;
    }

    public Set<Rol> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(Set<Rol> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }

    public Set<UtilityToken> getUtilitytokensUsuario() {
        return utilitytokensUsuario;
    }

    public void setUtilitytokensUsuario(Set<UtilityToken> utilitytokensUsuario) {
        this.utilitytokensUsuario = utilitytokensUsuario;
    }

    public Set<Conocimiento> getConocimientosUsuario() {
        return conocimientosUsuario;
    }

    public void setConocimientosUsuario(Set<Conocimiento> conocimientosUsuario) {
        this.conocimientosUsuario = conocimientosUsuario;
    }

    public Set<Educacion> getEducacionesUsuario() {
        return educacionesUsuario;
    }

    public void setEducacionesUsuario(Set<Educacion> educacionesUsuario) {
        this.educacionesUsuario = educacionesUsuario;
    }

    public Set<ExperienciaLaboral> getExperienciaslaboralesUsuario() {
        return experienciaslaboralesUsuario;
    }

    public void setExperienciaslaboralesUsuario(Set<ExperienciaLaboral> experienciaslaboralesUsuario) {
        this.experienciaslaboralesUsuario = experienciaslaboralesUsuario;
    }

    public Set<Habilidad> getHabilidadesUsuario() {
        return habilidadesUsuario;
    }

    public void setHabilidadesUsuario(Set<Habilidad> habilidadesUsuario) {
        this.habilidadesUsuario = habilidadesUsuario;
    }

    public Set<Idioma> getIdiomasUsuario() {
        return idiomasUsuario;
    }

    public void setIdiomasUsuario(Set<Idioma> idiomasUsuario) {
        this.idiomasUsuario = idiomasUsuario;
    }

    public Set<UsuariosPuestosTrabajo> getPuestostrabajoUsuario() {
        return puestostrabajoUsuario;
    }

    public void setPuestostrabajoUsuario(Set<UsuariosPuestosTrabajo> puestostrabajoUsuario) {
        this.puestostrabajoUsuario = puestostrabajoUsuario;
    }

    public Imagen getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(Imagen imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public DocumentoCV getDocumentoCVUsuario() {
        return documentoCVUsuario;
    }

    public void setDocumentoCVUsuario(DocumentoCV documentoCVUsuario) {
        this.documentoCVUsuario = documentoCVUsuario;
    }
}
