package br.iesb.sie.controller;

import br.iesb.sie.bean.UsuarioLogado;
import br.iesb.sie.entity.FrequenciaLancamento;
import br.iesb.sie.entity.Turma;
import br.iesb.sie.service.FrequenciaService;
import br.iesb.sie.service.TurmaService;

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

    @Inject
    private UsuarioLogado usuarioLogado;

    @Inject
    private TurmaService turmaService;

    private FrequenciaLancamento filtro;

    private List<FrequenciaLancamento> frequencias;

    @PostConstruct
    public void init() {
        filtro = new FrequenciaLancamento();
        filtrar();
    }

    @Override
    public void filtrar() {
        if (usuarioLogado.isProfessor()) {
            frequencias = frequenciaService.buscarFrequenciasLancamento(filtro, usuarioLogado.getEscolasVinculadas(),
                    usuarioLogado.getEntidade());
        } else {
            frequencias = frequenciaService.buscarFrequenciasLancamento(filtro, usuarioLogado.getEscolasVinculadas(), null);
        }
    }

    @Override
    public void limpar() {
        filtro = new FrequenciaLancamento();
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

    public List<Turma> getTurmas() {
        return turmaService.buscarTurmas(null, usuarioLogado.getEscolasVinculadas());
    }

}