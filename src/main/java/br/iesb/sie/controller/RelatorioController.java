package br.iesb.sie.controller;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Relatorio;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.RelatorioService;
import br.iesb.sie.service.TurmaService;

public class RelatorioController extends BaseController {

    /**
     * 
     */
    private static final long serialVersionUID = -990109336743387660L;

    @Inject
    protected RelatorioService relatorioService;

    @Inject
    protected TurmaService turmaService;

    private Relatorio relatorio;

    public void init() {
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
