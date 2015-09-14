package br.iesb.sie.dao;

import br.iesb.sie.entity.FrequenciaLancamento;

import javax.inject.Named;

@Named
public class FrequenciaLancamentoDAO extends BaseDAO<FrequenciaLancamento, Long> {

    public FrequenciaLancamentoDAO() {
        super(FrequenciaLancamento.class);
    }
}
