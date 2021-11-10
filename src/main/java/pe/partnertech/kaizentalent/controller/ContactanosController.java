package pe.partnertech.kaizentalent.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import pe.partnertech.kaizentalent.dto.request.usuario.ContactanosRequest;
import pe.partnertech.kaizentalent.dto.response.general.MessageResponse;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContactanosController {

    final
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailKaizen;

    public ContactanosController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/contactanos/send_email")
    public ResponseEntity<?> SendContactEmail(@RequestBody ContactanosRequest contactanosRequest) {

        try {
            SendEmailKaizen(contactanosRequest.getNombreUsuario(), contactanosRequest.getEmailUsuario(),
                    contactanosRequest.getAsuntoUsuario(), contactanosRequest.getMensajeUsuario());
        } catch (UnsupportedEncodingException e) {
            return new ResponseEntity<>(new MessageResponse("Error: " + e), HttpStatus.BAD_REQUEST);
        } catch (MessagingException e) {
            return new ResponseEntity<>(new MessageResponse("Error al enviar el email"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new MessageResponse("Se ha enviado su correo al administrador de Kaizen Talent correctamente."),
                HttpStatus.OK);
    }

    private void SendEmailKaizen(String nombreUsuario, String emailUsuario, String asuntoUsuario, String mensajeUsuario)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(emailUsuario, nombreUsuario);
        helper.setTo(emailKaizen);

        String contenido =
                "<!DOCTYPE html>" +
                        "<html lang=\"es\" xmlns=\"http://www.w3.org/1999/xhtml\">" +
                        "" +
                        "<head>" +
                        "" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                        "    <meta name=\"format-detection\" content=\"date=no\">" +
                        "    <meta name=\"format-detection\" content=\"address=no\">" +
                        "    <meta name=\"format-detection\" content=\"telephone=no\">" +
                        "    <title>Kaizen Talent - Tienes un nuevo mensaje</title>" +
                        "" +
                        "    <!-- GOOGLE WEB FONT -->" +
                        "    <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:400,500,600\" rel=\"stylesheet\">" +
                        "" +
                        "    <style>" +
                        "    *{" +
                        "        -webkit-font-smoothing: antialiased;" +
                        "        -moz-osx-font-smoothing: grayscale;" +
                        "    }" +
                        "" +
                        "    body {" +
                        "        padding: 0 !important;" +
                        "        margin: 0 !important;" +
                        "        display: block !important;" +
                        "        min-width: 100% !important;" +
                        "        width: 100% !important;" +
                        "        background: #ededed;" +
                        "        font-family: 'Work Sans', Arial, sans-serif;" +
                        "        -webkit-text-size-adjust: none;" +
                        "    }" +
                        "" +
                        "    a {" +
                        "        color: #1dbe72;" +
                        "        text-decoration: none;" +
                        "    }" +
                        "" +
                        "    p {" +
                        "        padding: 0 !important;" +
                        "        margin: 0 !important;" +
                        "    }" +
                        "" +
                        "    strong {" +
                        "        font-weight: 600 !important;" +
                        "    }" +
                        "" +
                        "    img {" +
                        "        -ms-interpolation-mode: bicubic;" +
                        "        /* Para Internet Explorer */" +
                        "    }" +
                        "" +
                        "    /* Estilos Mobile */" +
                        "    @media only screen and (max-width:525px) {" +
                        "" +
                        "        .mobile-br-15 {" +
                        "            height: 15px !important;" +
                        "        }" +
                        "" +
                        "        .m-td," +
                        "        .m-td," +
                        "        .m-td{" +
                        "            display: none !important;" +
                        "            width: 0 !important;" +
                        "            height: 0 !important;" +
                        "            font-size: 0 !important;" +
                        "            line-height: 0 !important;" +
                        "            min-height: 0 !important;" +
                        "        }" +
                        "" +
                        "        .img-m-center{" +
                        "            text-align: center !important;" +
                        "        }" +
                        "" +
                        "        .text-r-m-center," +
                        "        .text-white-top," +
                        "        .text-white-top{" +
                        "            text-align: center !important;" +
                        "        }" +
                        "" +
                        "        .fluid-img img," +
                        "        .fluid-img img {" +
                        "            width: 100% !important;" +
                        "            max-width: 100% !important;" +
                        "            height: auto !important;" +
                        "        }" +
                        "" +
                        "        .mobile-shell {" +
                        "            width: 100% !important;" +
                        "            min-width: 100% !important;" +
                        "        }" +
                        "" +
                        "        .center {" +
                        "            margin: 0 auto;" +
                        "        }" +
                        "" +
                        "        .td{" +
                        "            width: 100% !important;" +
                        "            min-width: 100% !important;" +
                        "        }" +
                        "" +
                        "        .content-spacing {" +
                        "            width: 15px !important;" +
                        "        }" +
                        "" +
                        "    }" +
                        "    </style>" +
                        "</head>" +
                        "" +
                        "<body class=\"body\" style=\"padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#ededed; -webkit-text-size-adjust:none;\">" +
                        "    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ededed\">" +
                        "        <tr>" +
                        "            <td align=\"center\" valign=\"top\">" +
                        "                <!-- Header -->" +
                        "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#1dbe72\">" +
                        "                    <tr>" +
                        "                        <td align=\"center\">" +
                        "                            <table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">" +
                        "                                <tr>" +
                        "                                    <td class=\"td\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">" +
                        "                                        <!-- Header tabla -->" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "                                            <tr>" +
                        "                                                <td>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"30\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "                                                        <tr>" +
                        "                                                            <td>" +
                        "                                                                <div class=\"img\" style=\"font-size:0pt; line-height:0pt; text-align:center\">" +
                        "                                                                    <div class=\"img-m-center\" style=\"font-size:0pt; line-height:0pt\">" +
                        "                                                                        <a href=\"#\" target=\"_blank\">" +
                        "                                                                            <img src=\"cid:KaizenLogo\" border=\"0\" width=\"45\" height=\"45\" alt=\"\" />" +
                        "                                                                        </a>" +
                        "                                                                    </div>" +
                        "                                                                </div>" +
                        "                                                            </td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"25\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                </td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                        <!-- Fin Header Tabla -->" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                    </tr>" +
                        "                </table>" +
                        "                <!-- Fin Header -->" +
                        "                <!-- Form -->" +
                        "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ededed\">" +
                        "                    <tr>" +
                        "                        <td valign=\"top\" class=\"m-td\" style=\"font-size:0pt; line-height:0pt; text-align:left\">" +
                        "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#1dbe72\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                <tr>" +
                        "                                    <td bgcolor=\"#1dbe72\" height=\"190\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                        <td width=\"650\" align=\"center\">" +
                        "                            <table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\" bgcolor=\"#6634cc\">" +
                        "                                <tr>" +
                        "                                    <td class=\"td\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "                                            <tr>" +
                        "                                                <td class=\"img\" style=\"font-size:0pt; line-height:0pt; text-align:left\" width=\"20\"></td>" +
                        "                                                <td>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"40\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                    <div class=\"fluid-img\" style=\"font-size:0pt; line-height:0pt;\">" +
                        "                                                        <div class=\"img-center\" style=\"font-size:0pt; line-height:0pt; text-align:center\">" +
                        "                                                            <img src=\"cid:ContactImage\" border=\"0\" width=\"40%;\" alt=\"\" />" +
                        "                                                        </div>" +
                        "                                                    </div>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"30\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                </td>" +
                        "                                                <td class=\"img\" style=\"font-size:0pt; line-height:0pt; text-align:left\" width=\"20\"></td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                            <table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">" +
                        "                                <tr>" +
                        "                                    <td>" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">" +
                        "                                            <tr>" +
                        "                                                <td class=\"content-spacing\" style=\"font-size:0pt; line-height:0pt; text-align:left\" width=\"30\"></td>" +
                        "                                                <td>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"40\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                    <div style=\"color:#ffff; font-family: 'Work Sans', Arial, sans-serif; font-size:26px; line-height:34px; text-align:center; font-weight: 500; background-color: #2f55d4; padding: 10px; border-radius: 10px;\">Tienes una nueva solicitud de mensaje</div>" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"30\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                    <!-- El mensaje -->" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:17px; line-height:21px; text-align:left; font-weight: bolder;\">" +
                        "                                                        ¡Hola!, te enviaron un mensaje nuevo :" +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:15px; line-height:21px; text-align:left; font-weight: 600;\">" +
                        "                                                        Datos de esta solicitud" +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:13px; line-height:21px; text-align:left; font-weight: 550;\">" +
                        "                                                        Nombre Completo: " + nombreUsuario +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:13px; line-height:21px; text-align:left; font-weight: 550;\">" +
                        "                                                        Email: " + emailUsuario +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <hr style=\"height: 2px; background-color: #2f55d4;\">" +
                        "                                                    <br>" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:13px; line-height:21px; text-align:left; font-weight: 550;\">" +
                        "                                                        Mensaje: " +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <div style=\"color:#444444; font-family: 'Work Sans', Arial, sans-serif; font-size:15px; line-height:21px; text-align:left;\">" +
                        mensajeUsuario +
                        "                                                    </div>" +
                        "                                                    <br>" +
                        "                                                    <br>" +
                        "                                                    <div style=\"margin-left: 30%;\"><a href=\"mailto:" + emailUsuario + "?subject=Respuesta%20de%20Kaizen%20Talent\" style=\"color:white; background: #00da3b; font-size: 16px; border-radius: 15px; display: block; width: 40%; padding: 12px; text-align: center; font-weight: bold;\">Responder Mensaje</a></div>" +
                        "                                                    <!-- Fin del mensaje-->" +
                        "                                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                                        <tr>" +
                        "                                                            <td height=\"40\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                                        </tr>" +
                        "                                                    </table>" +
                        "                                                </td>" +
                        "                                                <td class=\"content-spacing\" style=\"font-size:0pt; line-height:0pt; text-align:left\" width=\"30\"></td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                                <tr>" +
                        "                                    <td>" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                            <tr>" +
                        "                                                <td height=\"20\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                        <td valign=\"top\" class=\"m-td\" style=\"font-size:0pt; line-height:0pt; text-align:left\">" +
                        "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#1dbe72\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                <tr>" +
                        "                                    <td bgcolor=\"#1dbe72\" height=\"190\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                    </tr>" +
                        "                </table>" +
                        "                <!-- Fin Form -->" +
                        "                <!-- Footer -->" +
                        "                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "                    <tr>" +
                        "                        <td align=\"center\">" +
                        "                            <table width=\"650\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mobile-shell\">" +
                        "                                <tr>" +
                        "                                    <td class=\"td\" style=\"width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal;\">" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "                                            <tr>" +
                        "                                                <td align=\"center\">" +
                        "                                                    <div class=\"text-r-m-center\" style=\"color:#777777; font-family: 'Work Sans', Arial, sans-serif; font-size:14px; line-height:24px; text-align:center\">" +
                        "                                                        <a href=\"#\" target=\"_blank\" style=\"color:#666666; text-decoration:underline\"><span style=\"color:#666666; text-decoration:underline\">http://kaizen-talent.com/</span></a>" +
                        "                                                        <br />" +
                        "                                                        &copy; 2021 Kaizen Talent - Todos los derechos reservados" +
                        "                                                    </div>" +
                        "                                                </td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">" +
                        "                                            <tr>" +
                        "                                                <td height=\"40\" class=\"spacer\" style=\"font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%\">&nbsp;</td>" +
                        "                                            </tr>" +
                        "                                        </table>" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                    </tr>" +
                        "                </table>" +
                        "                <!-- Fin Footer -->" +
                        "                <div style=\"font-size:0pt; line-height:0pt;\" class=\"mobile-br-15\"></div>" +
                        "            </td>" +
                        "        </tr>" +
                        "    </table>" +
                        " " +
                        "</body>" +
                        "</html>";


        helper.setSubject(asuntoUsuario);
        helper.setText(contenido, true);

        helper.addInline("KaizenLogo", new ClassPathResource("/logokaizen.png"));
        helper.addInline("ContactImage", new ClassPathResource("/contactanos.png"));

        mailSender.send(message);
    }
}
