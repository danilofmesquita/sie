package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Frequencia;
import br.iesb.sie.entity.Nota;
import br.iesb.sie.entity.NotaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.NotaService;
import br.iesb.sie.service.TurmaService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class ManterNotaController extends BaseController {

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private NotaService notaService;

    @Inject
    private TurmaService turmaService;

    private NotaLancamento lancamento;

    @PostConstruct
    public void init() {

    }

    public void selecionarTurmaListener() {
        if (lancamento.getTurma() != null) {
            lancamento.getTurma().getMatriculas().forEach(matricula -> {
                if (lancamento.getNotas() == null) {
                    lancamento.setNotas(new ArrayList<>());
                } else {
                    lancamento.getNotas().clear();
                }

                Nota nota = new Nota();
                nota.setAluno(matricula.getAluno());
                nota.setLancamento(lancamento);

                lancamento.getNotas().add(nota);
            });
        }
    }

    public List<Turma> getTurmas() {
        if (lancamento.getTurma() != null) {
            return turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
        } else {
            return Collections.emptyList();
        }
    }

    public void salvar() {
        notaService.salvarNotas(lancamento);
    }

    public NotaLancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(NotaLancamento lancamento) {
        this.lancamento = lancamento;
    }
}
