package br.iesb.sie.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.Hibernate;

import br.iesb.sie.dao.FrequenciaLancamentoDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.FrequenciaLancamento;

@Stateless
public class FrequenciaService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = 5255051289876767357L;

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

    public List<FrequenciaLancamento> buscarFrequenciasLancamento(FrequenciaLancamento filtro,
            List<Entidade> escolasVinculadas, Entidade professor) {
        return frequenciaLancamentoDAO.buscarFrequenciasLancamento(filtro, escolasVinculadas, professor);
    }

}
