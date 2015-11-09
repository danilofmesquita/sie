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

    @SuppressWarnings("unchecked")
    public List<NotaLancamento> buscarNotasLancamento(NotaLancamento filtro, List<Entidade> escolas,
                                                      Entidade professor) {
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

        if (filtro != null) {
            if (filtro.getEscola() != null) {
                hql += " AND nl.escola = :escola";
                params.put("escola", filtro.getEscola());
            }
            if (filtro.getDisciplina() != null) {
                hql += " AND nl.disciplina = :disciplina ";
                params.put("disciplina", filtro.getDisciplina());
            }
            if (filtro.getTurma() != null) {
                hql += " AND nl.turma = :turma ";
                params.put("turma", filtro.getTurma());
            }
            if (filtro.getDataLancamento() != null) {
                hql += " AND year(nl.dataLancamento) = year(:dataLancamento) ";
                hql += " AND month(nl.dataLancamento) = month(:dataLancamento) ";
                hql += " AND day(nl.dataLancamento) = day(:dataLancamento) ";
                params.put("dataLancamento", filtro.getDataLancamento());
            }
            if (filtro.getBimestre() != null) {
                hql += "AND nl.bimestre = :bimestre";
                params.put("bimestre", filtro.getBimestre());
            }
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
