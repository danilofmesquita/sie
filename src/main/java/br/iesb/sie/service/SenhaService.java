package br.iesb.sie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class SenhaService extends BaseService {

    @Inject
    private Logger logger;

    public String criarNovaSenha() {
        String newPassword = UUID.randomUUID().toString();
        if (newPassword.length() > 6) {
            return newPassword.substring(0, 6);
        } else {
            return criarNovaSenha();
        }
    }

    public String codificarSenha(String senha) {
        try {
            MessageDigest ms = MessageDigest.getInstance("SHA-256");
            byte[] digest = ms.digest(senha.getBytes(Charset.forName("UTF-8")));
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
