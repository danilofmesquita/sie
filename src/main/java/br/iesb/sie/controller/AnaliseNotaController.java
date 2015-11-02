package br.iesb.sie.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AnaliseNotaController extends AnaliseAbstractController {

    /**
     * 
     */
    private static final long serialVersionUID = -6891867404947021797L;

    @Override
    protected Object construirGrafhData() {
        return analiseService.buscarDadosGraficoNota(tipoAnalise, turma, aluno, disciplina);
    }

}
