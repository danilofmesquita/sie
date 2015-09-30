package br.iesb.sie.service;

import br.iesb.sie.dao.NotaDAO;
import br.iesb.sie.dao.NotaLancamentoDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.NotaLancamento;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class NotaService extends BaseService  {

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
        NotaLancamento notaLancamento = notaLancamentoDAO.get(idNotaLancamento);
        Hibernate.initialize(notaLancamento.getNotas());
        Hibernate.initialize(notaLancamento.getTurma().getMatriculas().size());
        return notaLancamento;
    }

    public List<NotaLancamento> buscarNotasLancamento(NotaLancamento notaLancamento,
                                                      List<Entidade> escolasVinculadas,
                                                      Entidade professor) {
        return notaLancamentoDAO.buscarNotasLancamento(notaLancamento, escolasVinculadas, professor);
    }


}
