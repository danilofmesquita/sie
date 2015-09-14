package br.iesb.sie.dao;

import br.iesb.sie.entity.NotaLancamento;

import javax.inject.Named;

@Named
public class NotaLancamentoDAO extends BaseDAO<NotaLancamento, Long> {

    public NotaLancamentoDAO() {
        super(NotaLancamento.class);
    }
}
