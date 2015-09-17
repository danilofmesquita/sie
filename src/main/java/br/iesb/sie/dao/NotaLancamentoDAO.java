package br.iesb.sie.dao;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.NotaLancamento;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class NotaLancamentoDAO extends BaseDAO<NotaLancamento, Long> {

    public NotaLancamentoDAO() {
        super(NotaLancamento.class);
    }

    public List<NotaLancamento> buscarNotasLancamento(List<Entidade> escolas, Entidade professor) {
        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT nl FROM NotaLancamento nl WHERE 1=1 ";

        if (escolas != null && !escolas.isEmpty()) {
            hql += " AND nl.escola IN :escolas ";
            params.put("escolas", escolas);
            if (professor != null) {
                hql += " AND nl.disciplina IN ( ";
                hql += "    SELECT pd.disciplina FROM ProfessorDisciplina pd ";
                hql += "    WHERE pd.turma.escola in :escolas ";
                hql += "    AND pd.professor = :professor ) ";
                params.put("professor", professor);
            }
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
