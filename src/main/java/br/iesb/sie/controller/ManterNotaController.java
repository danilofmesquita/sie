package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Frequencia;
import br.iesb.sie.entity.Nota;
import br.iesb.sie.entity.NotaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Disciplina;
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

    private List<Turma> turmas;

    private NotaLancamento lancamento;

    private List<Disciplina> disciplinas;

    @PostConstruct
    public void init() {
        lancamento = new NotaLancamento();
    }

    public void selecionaEscolaListener() {
        if (lancamento.getEscola() != null) {
            turmas = turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
        } else {
            turmas = Collections.emptyList();
            lancamento.setTurma(null);
        }
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
            if (usuarioLogado.isProfessor()) {
                disciplinas = turmaService.buscarDisciplinasVinculadasATurmaEProfessor(lancamento.getTurma().getId(),
                        usuarioLogado.getEntidade().getId());
            } else {
                disciplinas = turmaService.buscarDisciplinasVinculadasATurma(lancamento.getTurma().getId());
            }
        } else {
            disciplinas = Collections.emptyList();
            lancamento.setTurma(null);
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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
