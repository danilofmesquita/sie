package br.iesb.sie.dao;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.FrequenciaLancamento;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class FrequenciaLancamentoDAO extends BaseDAO<FrequenciaLancamento, Long> {

    public FrequenciaLancamentoDAO() {
        super(FrequenciaLancamento.class);
    }

    public List<FrequenciaLancamento> buscarFrequenciasLancamento(FrequenciaLancamento filtro, List<Entidade> escolas,
                                                                  Entidade professor) {
        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT fl FROM FrequenciaLancamento fl WHERE 1=1 ";

        if (escolas != null && !escolas.isEmpty()) {
            hql += " AND fl.escola IN :escolas ";
            params.put("escolas", escolas);
            if (professor != null) {
                hql += " AND fl.disciplina IN ( ";
                hql += "    SELECT pd.disciplina FROM ProfessorDisciplina pd ";
                hql += "    WHERE pd.turma.escola in :escolas ";
                hql += "    AND pd.professor = :professor ) ";
                params.put("professor", professor);
            }
        }

        if (filtro != null) {
            if (filtro.getEscola() != null) {
                hql += " AND fl.escola = :escola";
                params.put("escola", filtro.getEscola());
            }
            if (filtro.getDisciplina() != null) {
                hql += " AND fl.disciplina = :disciplina ";
                params.put("disciplina", filtro.getDisciplina());
            }
            if (filtro.getTurma() != null) {
                hql += " AND fl.turma = :turma ";
                params.put("turma", filtro.getTurma());
            }
            if (filtro.getDataLancamento() != null) {
                hql += " AND fl.dataLancamento = :dataLancamento ";
                params.put("dataLancamento", filtro.getDataLancamento());
            }
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
