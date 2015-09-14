package br.iesb.sie.service;

import br.iesb.sie.dao.NotaDAO;
import br.iesb.sie.dao.NotaLancamentoDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class NotaService {

    @Inject
    private NotaDAO notaDAO;

    @Inject
    private NotaLancamentoDAO notaLancamentoDAO;

}
