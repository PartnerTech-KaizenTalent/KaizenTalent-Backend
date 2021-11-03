/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.controller.util.util_code;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Code_SendVerifyEmail {

    public static void EnviarCorreo(String email, String url, JavaMailSender mailSender, String mail, String img_logo,
                             String img_check, TemplateEngine templateEngine)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(mail, "Kaizen Talent Support");
        helper.setTo(email);

        String asunto = "Verificación de Cuenta";

        Context context = new Context();
        Map<String, Object> model = new HashMap<>();
        model.put("url", url);
        model.put("img_logo", img_logo);
        model.put("img_check", img_check);

        context.setVariables(model);

        String html_template = templateEngine.process("userverify-mailtemplate", context);

        helper.setSubject(asunto);
        helper.setText(html_template, true);

        mailSender.send(message);
    }
}
