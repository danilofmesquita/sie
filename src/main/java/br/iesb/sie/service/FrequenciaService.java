package br.iesb.sie.service;

import br.iesb.sie.dao.FrequenciaDAO;
import br.iesb.sie.dao.FrequenciaLancamentoDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FrequenciaService {

    @Inject
    private FrequenciaDAO frequenciaDAO;

    @Inject
    private FrequenciaLancamentoDAO frequenciaLancamentoDAO;
}
