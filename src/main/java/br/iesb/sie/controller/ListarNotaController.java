package br.iesb.sie.controller;

import br.iesb.sie.entity.NotaLancamento;
import br.iesb.sie.service.NotaService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class ListarNotaController extends ListarController {

    @Inject
    private NotaService notaService;

    private NotaLancamento filtro;

    private List<NotaLancamento> notas;

    @PostConstruct
    public void init() {

    }

    @Override
    public void filtrar() {

    }

    public NotaLancamento getFiltro() {
        return filtro;
    }

    public void setFiltro(NotaLancamento filtro) {
        this.filtro = filtro;
    }

    public List<NotaLancamento> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaLancamento> notas) {
        this.notas = notas;
    }

}