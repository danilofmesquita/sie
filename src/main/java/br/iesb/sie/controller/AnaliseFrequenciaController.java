package br.iesb.sie.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AnaliseFrequenciaController extends AnaliseAbstractController {

    /**
     * 
     */
    private static final long serialVersionUID = 2581244621930458646L;

    @Override
    protected Object construirGrafhData() {
        return analiseService.buscarDadosGraficoFrequencia(turma);
    }

}
