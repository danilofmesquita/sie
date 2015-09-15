package br.iesb.sie.service;

import br.iesb.sie.dao.FrequenciaDAO;
import br.iesb.sie.dao.FrequenciaLancamentoDAO;
import br.iesb.sie.entity.FrequenciaLancamento;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class FrequenciaService {

    @Inject
    private FrequenciaDAO frequenciaDAO;

    @Inject
    private FrequenciaLancamentoDAO frequenciaLancamentoDAO;

    public void salvarFrequencias(FrequenciaLancamento frequenciaLancamento) {
        if(frequenciaLancamento.getDataLancamento() == null){
            frequenciaLancamento.setDataLancamento(new Date());
        }
        frequenciaLancamentoDAO.salvar(frequenciaLancamento);
    }

    public FrequenciaLancamento getFrequenciaLancamento(Long idFrequenciaLancamento) {
        return frequenciaLancamentoDAO.get(idFrequenciaLancamento);
    }
}
