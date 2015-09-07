package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ListarTurmaController extends BaseController {

    @Inject
    private TurmaService turmaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    private List<Turma> turmas;

    private Turma filtro = new Turma();

    @PostConstruct
    public void init() {
        if (usuarioLogado.isEscola()) {
            filtro.setEscola(usuarioLogado.getEntidade());
            filtrar();
        }
    }

    public String editar(Turma turma) {
        putFlashAttribute(Attributes.ID, turma.getId());
        return "incluir.xhtml?faces-redirect=true";
    }

    public void filtrar() {
        turmas = turmaService.buscarTurmas(filtro);
    }

    public void limpar() {
        filtro = new Turma();
        if (usuarioLogado.isEscola()) {
            filtro.setEscola(usuarioLogado.getEntidade());
        }
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
}
