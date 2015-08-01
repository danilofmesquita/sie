package br.iesb.sie.service;

import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class SenhaService {

    public String criarNovaSenha() {
        String newPassword = UUID.randomUUID().toString();
        if (newPassword.length() > 6) {
            return newPassword.substring(0, 6);
        } else {
            return criarNovaSenha();
        }
    }

}
