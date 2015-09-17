package br.iesb.sie.controller;

import br.iesb.sie.entity.FrequenciaLancamento;
import br.iesb.sie.service.FrequenciaService;
import br.iesb.sie.util.Attributes;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ListarFrequenciaController extends ListarController {

    @Inject
    private FrequenciaService frequenciaService;

    private FrequenciaLancamento filtro;

    private List<FrequenciaLancamento> frequencias;

    @PostConstruct
    public void init() {

    }

    @Override
    public void filtrar() {

    }

    public List<FrequenciaLancamento> getFrequencias() {
        return frequencias;
    }

    public void setFrequencias(List<FrequenciaLancamento> frequencias) {
        this.frequencias = frequencias;
    }

    public FrequenciaLancamento getFiltro() {
        return filtro;
    }

    public void setFiltro(FrequenciaLancamento filtro) {
        this.filtro = filtro;
    }

}