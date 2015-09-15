package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.Frequencia;
import br.iesb.sie.entity.FrequenciaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.FrequenciaService;
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
public class ManterFrequenciaController extends BaseController {

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private FrequenciaService frequenciaService;

    @Inject
    private TurmaService turmaService;

    private FrequenciaLancamento lancamento;

    @PostConstruct
    public void init() {
        if (lancamento == null) {
            lancamento = new FrequenciaLancamento();
        }
    }

    public void selecionarTurmaListener() {
        if (lancamento.getTurma() != null) {
            lancamento.getTurma().getMatriculas().forEach(matricula -> {
                if (lancamento.getFrequencias() == null) {
                    lancamento.setFrequencias(new ArrayList<>());
                } else {
                    lancamento.getFrequencias().clear();
                }

                Frequencia frequencia = new Frequencia();
                frequencia.setAluno(matricula.getAluno());
                frequencia.setLancamento(lancamento);

                lancamento.getFrequencias().add(frequencia);
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
        frequenciaService.salvarFrequencias(lancamento);
    }

    public FrequenciaLancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(FrequenciaLancamento lancamento) {
        this.lancamento = lancamento;
    }
}
