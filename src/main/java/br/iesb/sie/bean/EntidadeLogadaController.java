package br.iesb.sie.bean;

import br.iesb.sie.controller.BaseController;
import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.service.EntidadeService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Model
public class EntidadeLogadaController extends BaseController {

    @Inject
    private EntidadeService entidadeService;

    public Entidade getEntidade() {
        Principal userPrincipal = getFacesContext().getExternalContext().getUserPrincipal();
        if (userPrincipal != null) {
            return entidadeService.buscarEntidadePorLogin(userPrincipal.getName());
        } else {
            return null;
        }
    }

    public String logout() {
        ((HttpSession) getFacesContext().getExternalContext().getSession(false)).invalidate();
        return "/view/index.xhtml?faces-redirect=true";
    }

}
