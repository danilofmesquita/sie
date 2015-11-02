package br.iesb.sie.controller;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.model.Disciplina;
import br.iesb.sie.model.TipoAnalise;
import br.iesb.sie.service.AnaliseService;
import br.iesb.sie.service.TurmaService;
import com.google.gson.Gson;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public abstract class AnaliseAbstractController extends BaseController {

    /**
     *
     */
    private static final long serialVersionUID = 3601253754320071053L;

    @Inject
    protected TurmaService turmaService;

    @Inject
    protected AnaliseService analiseService;

    protected Entidade escola, aluno;

    protected Turma turma;

    protected String graphData;

    protected TipoAnalise tipoAnalise;

    protected Disciplina disciplina;

    protected abstract Object construirGrafhData();

    public void construirGrafico() {
        setGraphData(new Gson().toJson(construirGrafhData()));
    }

    public List<Turma> getTurmas() {
        if (escola != null) {
            return turmaService.buscarTurmasPorEscola(escola);
        } else {
            return Collections.emptyList();
        }
    }

    public Entidade getEscola() {
        return escola;
    }

    public void setEscola(Entidade escola) {
        this.escola = escola;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getGraphData() {
        return graphData;
    }

    public void setGraphData(String graphData) {
        this.graphData = graphData;
    }

    public TipoAnalise getTipoAnalise() {
        return tipoAnalise;
    }

    public void setTipoAnalise(TipoAnalise tipoAnalise) {
        this.tipoAnalise = tipoAnalise;
    }

    public Entidade getAluno() {
        return aluno;
    }

    public void setAluno(Entidade aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
