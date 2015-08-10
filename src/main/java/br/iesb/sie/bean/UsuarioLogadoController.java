package br.iesb.sie.bean;

import br.iesb.sie.controller.BaseController;
import br.iesb.sie.entidade.Usuario;
import br.iesb.sie.service.UsuarioService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Model
public class UsuarioLogadoController extends BaseController {

    @Inject
    private UsuarioService usuarioService;

    public Usuario getUsuario() {
        Principal userPrincipal = getFacesContext().getExternalContext().getUserPrincipal();
        if (userPrincipal != null) {
            return usuarioService.buscarUsuarioPorLogin(userPrincipal.getName());
        } else {
            return null;
        }
    }

    public String logout() {
        ((HttpSession) getFacesContext().getExternalContext().getSession(false)).invalidate();
        return "/view/index.xhtml?faces-redirect=true";
    }

}
