package br.iesb.sie.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AnaliseFrequenciaNotaController extends AnaliseAbstractController {

    /**
     *
     */
    private static final long serialVersionUID = 2581244621230458646L;

    @Override
    protected Object construirGrafhData() {
        return analiseService.buscarDadosGraficoFrequenciaNota(tipoAnalise, turma, aluno, disciplina);
    }
}
