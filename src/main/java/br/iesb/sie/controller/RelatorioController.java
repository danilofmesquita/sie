package br.iesb.sie.controller;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Relatorio;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.RelatorioService;
import br.iesb.sie.service.TurmaService;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class RelatorioController extends BaseController {

    @Inject
    protected RelatorioService relatorioService;

    @Inject
    protected TurmaService turmaService;

    private Relatorio relatorio;

    public void init(){
        relatorio = new Relatorio();
    }

    public List<Turma> getTurmas() {
        if (relatorio.getEscola() != null) {
            return turmaService.buscarTurmasVinculadasAEscola(relatorio.getEscola());
        } else {
            return Collections.emptyList();
        }
    }

    public List<Entidade> getAlunos() {
        if (relatorio.getTurma() != null) {
            return turmaService.buscarAlunosVinculadosATurma(relatorio.getTurma());
        } else {
            return Collections.emptyList();
        }
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

}
