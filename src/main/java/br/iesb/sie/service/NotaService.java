package br.iesb.sie.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.Hibernate;

import br.iesb.sie.dao.NotaLancamentoDAO;
import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.NotaLancamento;

@Stateless
public class NotaService extends BaseService {

    /**
     * 
     */
    private static final long serialVersionUID = 2181078896638463490L;

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

    public List<NotaLancamento> buscarNotasLancamento(NotaLancamento notaLancamento, List<Entidade> escolasVinculadas,
            Entidade professor) {
        List<NotaLancamento> notaLancamentos = notaLancamentoDAO.buscarNotasLancamento(notaLancamento,
                escolasVinculadas, professor);
        notaLancamentos.forEach(n -> Hibernate.initialize(n.getNotas()));
        return notaLancamentos;
    }

    public void delete(Long idNotaLancamento) {
        NotaLancamento nl = getNotaLancamento(idNotaLancamento);
        notaLancamentoDAO.delete(nl);
    }
}
