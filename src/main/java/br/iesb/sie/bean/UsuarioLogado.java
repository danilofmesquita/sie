package br.iesb.sie.bean;

import br.iesb.sie.controller.BaseController;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.FuncionarioService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@javax.faces.view.ViewScoped
public class UsuarioLogado extends BaseController {

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private FuncionarioService funcionarioService;

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

    public boolean isSecretaria() {
        return getEntidade().getPerfis().contains(Perfil.SECRETARIA)
                && funcionarioService.possuiEscolaVinculada(Perfil.SECRETARIA, getEntidade());
    }

    public boolean isProfessor() {
        return getEntidade().getPerfis().contains(Perfil.PROFESSOR)
                && funcionarioService.possuiEscolaVinculada(Perfil.PROFESSOR, getEntidade());
    }

    public List<Entidade> getEscolasVinculadas() {
        List<Entidade> escolasVinculadas = new ArrayList<>();
        if (isSecretaria()) {
            escolasVinculadas.addAll(entidadeService.buscarEscolasVinculadas(getEntidade(), Perfil.SECRETARIA));
        }
        if (isProfessor()) {
            escolasVinculadas.addAll(entidadeService.buscarEscolasVinculadas(getEntidade(), Perfil.PROFESSOR));
        }
        if (isEscola()) {
            return Collections.singletonList(getEntidade());
        }
        return escolasVinculadas;
    }
}
