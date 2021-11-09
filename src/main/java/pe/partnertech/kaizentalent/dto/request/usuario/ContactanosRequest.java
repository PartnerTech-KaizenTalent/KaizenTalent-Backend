package pe.partnertech.kaizentalent.dto.request.usuario;

public class ContactanosRequest {

    //Atributos
    private String nombreUsuario;

    private String emailUsuario;

    private String asuntoUsuario;

    private String mensajeUsuario;

    //Constructor
    public ContactanosRequest() {
    }

    public ContactanosRequest(String nombreUsuario, String emailUsuario, String asuntoUsuario, String mensajeUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.asuntoUsuario = asuntoUsuario;
        this.mensajeUsuario = mensajeUsuario;
    }

    //Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getAsuntoUsuario() {
        return asuntoUsuario;
    }

    public void setAsuntoUsuario(String asuntoUsuario) {
        this.asuntoUsuario = asuntoUsuario;
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }
}
