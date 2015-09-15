package br.iesb.sie.service;

import br.iesb.sie.dao.NotaDAO;
import br.iesb.sie.dao.NotaLancamentoDAO;
import br.iesb.sie.entity.NotaLancamento;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class NotaService {

    @Inject
    private NotaDAO notaDAO;

    @Inject
    private NotaLancamentoDAO notaLancamentoDAO;

    public void salvarNotas(NotaLancamento notaLancamento) {
        if (notaLancamento.getDataLancamento() == null) {
            notaLancamento.setDataLancamento(new Date());
        }
        notaLancamentoDAO.salvar(notaLancamento);
    }

    public NotaLancamento getNotaLancamento(Long idNotaLancamento) {
        return notaLancamentoDAO.get(idNotaLancamento);
    }

}