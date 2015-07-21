/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.mail;
import java.util.Properties;

import com.app.log.DemoLogFile;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author EdsonAlexander
 */
public class Email {
     
    String usuarioCorreo;
    String password;
    String destinatario;
    String asunto;
    String mensaje;
    
     public Email(String destinatario, String asunto,String mensaje) {
        this.usuarioCorreo = "edson.yusuke@gmail.com";
        this.password = "kkkdmqfhueitzgia";
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
     
     public boolean sendMail(){
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            DemoLogFile.info("Se ha enviado un correo a "+usuarioCorreo);
            return true;
        }
        catch (Exception e)
        {
            DemoLogFile.fatal("No se podido enviar un correo a "+usuarioCorreo);
            return false;
        }        
    } 
     
}
