package br.iesb.sie.dao;


import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Matricula;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class MatriculaDAO extends BaseDAO<Matricula, Long> {

    public MatriculaDAO() {
        super(Matricula.class);
    }

    public List<Matricula> buscarMatriculas(Matricula filtro, List<Entidade> escolasVinculadas) {

        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT m FROM Matricula m ";
        hql += " WHERE m.escola IN :escolasVinculadas ";
        params.put("escolasVinculadas", escolasVinculadas);

        if (filtro != null) {
            if (filtro.getAluno() != null) {
                hql += " AND m.aluno = :aluno ";
                params.put("aluno", filtro.getAluno());
            }

            if (filtro.getEscola() != null) {
                hql += " AND m.escola = :escola";
                params.put("escola", filtro.getEscola());
            }

            if (filtro.getTurma() != null) {
                hql += " AND m.turma = :turma";
                params.put("turma", filtro.getTurma());
            }
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();

    }
}
