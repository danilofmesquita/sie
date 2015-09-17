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

    public List<FrequenciaLancamento> buscarFrequenciasLancamento(List<Entidade> escolas, Entidade professor) {
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

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
