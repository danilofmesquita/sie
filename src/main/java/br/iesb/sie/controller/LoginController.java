package br.iesb.sie.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Model
public class LoginController extends BaseController {

    @Inject
    private Logger logger;

    private String login;

    private String senha;

    public String logar() {
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        try {
            request.login(login, senha);
            return "/view/index.xhtml";
        } catch (ServletException e) {
            addErrorMessage("Não possível autenticar, verifique a Matrícula e a Senha.");
            logger.log(Level.SEVERE, "Erro ao efetuar o login", e);
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
