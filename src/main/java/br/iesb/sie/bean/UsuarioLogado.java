package br.iesb.sie.bean;

import br.iesb.sie.controller.BaseController;
import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Named
@javax.faces.view.ViewScoped
public class UsuarioLogado extends BaseController {

    @Inject
    private EntidadeService entidadeService;

    private Entidade entidade;

    public Entidade getEntidade() {
        if (entidade == null) {
            Principal userPrincipal = getFacesContext().getExternalContext().getUserPrincipal();
            if (userPrincipal != null) {
                entidade = entidadeService.buscarEntidadePorLogin(userPrincipal.getName());
            }
        }

        return entidade;
    }


    public String logout() {
        ((HttpSession) getFacesContext().getExternalContext().getSession(false)).invalidate();
        return "/view/index.xhtml?faces-redirect=true";
    }

    public boolean isEscola() {
        return getEntidade().getPerfis().contains(Perfil.ESCOLA);
    }

}
