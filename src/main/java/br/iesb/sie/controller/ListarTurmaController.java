package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Perfil;
import br.iesb.sie.service.EntidadeService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class ListarTurmaController extends BaseController {

    @Inject
    private TurmaService turmaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private EntidadeService entidadeService;

    private List<Turma> turmas;

    private Turma filtro = new Turma();

    @PostConstruct
    public void init() {
        filtrar();
    }

    public String editar(Turma turma) {
        putFlashAttribute(Attributes.ID, turma.getId());
        return "incluir.xhtml?faces-redirect=true";
    }

    public void filtrar() {
        turmas = turmaService.buscarTurmas(filtro, buscarEscolasVinculadas());
    }

    public void limpar() {
        filtro = new Turma();
        filtrar();
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Turma getFiltro() {
        return filtro;
    }

    public void setFiltro(Turma filtro) {
        this.filtro = filtro;
    }

    public List<Entidade> buscarEscolasVinculadas() {
        if (usuarioLogado.isEscola()) {
            return Collections.singletonList(usuarioLogado.getEntidade());
        } else if (usuarioLogado.isSecretaria()) {
            return entidadeService.buscarEscolasVinculadas(usuarioLogado.getEntidade(), Perfil.SECRETARIA);
        }
        return Collections.emptyList();
    }
}
