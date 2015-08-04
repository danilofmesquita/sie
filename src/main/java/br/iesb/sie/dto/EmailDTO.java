package br.iesb.sie.dto;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailDTO {

    public static String EMAIL_SIE = "sie@noreply.iesb.br";

    @Inject
    private Logger logger;
    private String destino, assunto, conteudo;

    public EmailDTO() {
    }

    public EmailDTO addDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public EmailDTO addAssunto(String assunto) {
        this.assunto = assunto;
        return this;
    }


    public EmailDTO addConteudo(String conteudo) {
        this.conteudo = conteudo;
        return this;
    }

    public Message pupularEmail(Session mailSession) {

        try {
            Message m = new MimeMessage(mailSession);

            m.setFrom(new InternetAddress("noreply@sie.gov.br"));
            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            m.setSubject(assunto);
            m.setText(conteudo);

            return m;

        } catch (AddressException e) {
            logger.log(Level.SEVERE, "Não foi possível popular o email!", e);
        } catch (MessagingException e) {
            logger.log(Level.SEVERE, "Não foi possível popular o email!", e);
        }

        return null;
    }


}
