package br.iesb.sie.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.NotaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.NotaService;
import br.iesb.sie.service.TurmaService;

@Named
@ViewScoped
public class ListarNotaController extends ListarController {

    /**
     * 
     */
    private static final long serialVersionUID = 7999335048470317415L;

    @Inject
    private NotaService notaService;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private TurmaService turmaService;

    private NotaLancamento filtro;

    private List<NotaLancamento> notas;

    @PostConstruct
    public void init() {
        filtro = new NotaLancamento();
        filtrar();
    }

    @Override
    public void filtrar() {
        if (usuarioLogado.isProfessor()) {
            notas = notaService.buscarNotasLancamento(filtro, usuarioLogado.getEscolasVinculadas(),
                    usuarioLogado.getEntidade());
        } else {
            notas = notaService.buscarNotasLancamento(filtro, usuarioLogado.getEscolasVinculadas(), null);
        }
    }

    @Override
    public void limpar() {
        filtro = new NotaLancamento();
    }

    public NotaLancamento getFiltro() {
        return filtro;
    }

    public void setFiltro(NotaLancamento filtro) {
        this.filtro = filtro;
    }

    public List<NotaLancamento> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaLancamento> notas) {
        this.notas = notas;
    }

    public List<Turma> getTurmas() {
        return turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
    }

}