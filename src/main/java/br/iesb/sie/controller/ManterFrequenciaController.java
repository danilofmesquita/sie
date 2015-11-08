package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Frequencia;
import br.iesb.sie.entity.FrequenciaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Disciplina;
import br.iesb.sie.service.FrequenciaService;
import br.iesb.sie.service.TurmaService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class ManterFrequenciaController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = -1776299744147058903L;

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private FrequenciaService frequenciaService;

    @Inject
    private TurmaService turmaService;

    private FrequenciaLancamento lancamento;

    private List<Turma> turmas;

    private List<Disciplina> disciplinas;

    @PostConstruct
    public void init() {
        Long id = getFlashAttribute(Attributes.ID);
        if (id == null) {
            if (lancamento == null) {
                lancamento = new FrequenciaLancamento();
            }
        } else {
            lancamento = frequenciaService.getFrequenciaLancamento(id);
            turmas = turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
            preencherDisciplinas();
        }
    }

    public void selecionaEscolaListener() {
        if (lancamento.getEscola() != null) {
            turmas = turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
        } else {
            turmas = Collections.emptyList();
        }
    }

    public void selecionarTurmaListener() {
        if (lancamento.getTurma() != null) {
            if (lancamento.getFrequencias() == null) {
                lancamento.setFrequencias(new ArrayList<>());
            } else {
                lancamento.getFrequencias().clear();
            }
            lancamento.getTurma().getMatriculas().forEach(matricula -> {
                Frequencia frequencia = new Frequencia();
                frequencia.setAluno(matricula.getAluno());
                frequencia.setLancamento(lancamento);

                lancamento.getFrequencias().add(frequencia);
            });
            preencherDisciplinas();
        } else {
            disciplinas = Collections.emptyList();
            lancamento.setTurma(null);
        }
    }

    private void preencherDisciplinas() {
        if (usuarioLogado.isProfessor()) {
            disciplinas = turmaService.buscarDisciplinasPorTurmaProfessor(lancamento.getTurma().getId(),
                    usuarioLogado.getEntidade().getId());
        } else {
            disciplinas = turmaService.buscarDisciplinasPorTurma(lancamento.getTurma().getId());
        }
    }

    public String salvar() {
        frequenciaService.salvarFrequencias(lancamento);
        addInfoMessage("Dados salvos com sucesso!");
        return "listar.xhtml?faces-redirect=true";
    }

    public FrequenciaLancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(FrequenciaLancamento lancamento) {
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
