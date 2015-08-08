package br.iesb.sie.bean;

import br.iesb.sie.entidade.Usuario;
import br.iesb.sie.service.UsuarioService;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;

@Model
public class UsuarioLogadoController implements Serializable {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private FacesContext facesContext;

    public Usuario getUsuario() {
        Principal userPrincipal = facesContext.getExternalContext().getUserPrincipal();
        if (userPrincipal != null) {
            return usuarioService.buscarUsuarioPorLogin(userPrincipal.getName());
        } else {
            return null;
        }
    }

    public String logout() {
        ((HttpSession) facesContext.getExternalContext().getSession(false)).invalidate();
        return "/view/index.xhtml?faces-redirect=true";
    }

}
