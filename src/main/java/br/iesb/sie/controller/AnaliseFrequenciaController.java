package br.iesb.sie.controller;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.AnaliseService;
import br.iesb.sie.service.TurmaService;
import com.google.gson.Gson;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class AnaliseFrequenciaController extends BaseController {

    @Inject
    private TurmaService turmaService;

    @Inject
    private AnaliseService analiseService;

    private Entidade escola;

    private Turma turma;

    private String graphData;


    public void constuirGrafico(){
        graphData = new Gson().toJson(analiseService.buscarDadosGraficoFrequencia(turma));
    }

    public List<Turma> getTurmas() {
        if (escola != null) {
            return turmaService.buscarTurmasVinculadasAEscola(escola);
        } else {
            return Collections.emptyList();
        }
    }

    public TurmaService getTurmaService() {
        return turmaService;
    }

    public void setTurmaService(TurmaService turmaService) {
        this.turmaService = turmaService;
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
}
