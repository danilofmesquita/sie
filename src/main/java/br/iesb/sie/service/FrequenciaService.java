package br.iesb.sie.service;

import br.iesb.sie.dao.FrequenciaDAO;
import br.iesb.sie.dao.FrequenciaLancamentoDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.FrequenciaLancamento;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class FrequenciaService {

    @Inject
    private FrequenciaDAO frequenciaDAO;

    @Inject
    private FrequenciaLancamentoDAO frequenciaLancamentoDAO;

    public void salvarFrequencias(FrequenciaLancamento frequenciaLancamento) {
        if (frequenciaLancamento.getDataLancamento() == null) {
            frequenciaLancamento.setDataLancamento(new Date());
        }
        frequenciaLancamentoDAO.salvar(frequenciaLancamento);
    }

    public FrequenciaLancamento getFrequenciaLancamento(Long idFrequenciaLancamento) {
        FrequenciaLancamento frequenciaLancamento = frequenciaLancamentoDAO.get(idFrequenciaLancamento);
        Hibernate.initialize(frequenciaLancamento.getFrequencias());
        Hibernate.initialize(frequenciaLancamento.getTurma().getMatriculas().size());
        return frequenciaLancamento;
    }

    public List<FrequenciaLancamento> buscarFrequenciasLancamento(List<Entidade> escolasVinculadas,
                                                                  Entidade professor) {
        return frequenciaLancamentoDAO.buscarFrequenciasLancamento(escolasVinculadas, professor);
    }

}
