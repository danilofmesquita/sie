package br.iesb.sie.bean;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.iesb.sie.controller.BaseController;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.FuncionarioService;
import br.iesb.sie.service.MatriculaService;
import br.iesb.sie.util.NavigationRules;

@Named
@SessionScoped
public class UsuarioLogado extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = -8508465255757968157L;

    @Inject
    private EntidadeService entidadeService;

    @Inject
    private FuncionarioService funcionarioService;

    @Inject
    private MatriculaService matriculaService;

    private Entidade entidade;

    private Boolean isEscola = null;

    private Boolean isAluno = null;

    private Boolean isSecretaria = null;

    private Boolean isProfessor = null;

    private List<Entidade> escolasVinculadas;

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
        return NavigationRules.SIE_HOME;
    }

    public boolean isAluno() {
        if (isAluno == null) {
            isAluno = getEntidade().getPerfis().contains(Perfil.ALUNO)
                    && matriculaService.isAlunoMatriculado(getEntidade().getId());
        }
        return isAluno;
    }

    public boolean isEscola() {
        if (isEscola == null) {
            isEscola = getEntidade().getPerfis().contains(Perfil.ESCOLA);

        }
        return isEscola;
    }

    public boolean isSecretaria() {
        if (isSecretaria == null) {
            isSecretaria = getEntidade().getPerfis().contains(Perfil.SECRETARIA)
                    && funcionarioService.possuiEscolaVinculada(Perfil.SECRETARIA, getEntidade());
        }
        return isSecretaria;
    }

    public boolean isProfessor() {
        if (isProfessor == null) {
            isProfessor = getEntidade().getPerfis().contains(Perfil.PROFESSOR)
                    && funcionarioService.possuiEscolaVinculada(Perfil.PROFESSOR, getEntidade());
        }
        return isProfessor;
    }

    public List<Entidade> getEscolasVinculadas() {
        if (escolasVinculadas == null) {
            Set<Entidade> setEscolasVinculadas = new HashSet<>();
            if (isSecretaria()) {
                setEscolasVinculadas
                        .addAll(entidadeService.buscarEscolasVinculadasAoFuncionario(getEntidade(), Perfil.SECRETARIA));
            }
            if (isProfessor()) {
                setEscolasVinculadas
                        .addAll(entidadeService.buscarEscolasVinculadasAoFuncionario(getEntidade(), Perfil.PROFESSOR));
            }
            if (isEscola()) {
                return Collections.singletonList(getEntidade());
            }
            escolasVinculadas = new ArrayList<>(setEscolasVinculadas);
        }
        return escolasVinculadas;
    }

}
