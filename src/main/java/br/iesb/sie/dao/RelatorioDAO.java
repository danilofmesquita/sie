package br.iesb.sie.dao;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Relatorio;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class RelatorioDAO extends BaseDAO<Relatorio, Long> {

    public RelatorioDAO() {
        super(Relatorio.class);
    }

    public List<Relatorio> buscarRelatorios(Relatorio relatorio, List<Entidade> escolas) {
        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT r FROM Relatorio r ";
        hql += " WHERE 1=1 ";
        hql += " AND r.escola in :escolas ";
        params.put("escolas", escolas);

        if (relatorio != null) {
            if (relatorio.getEscola() != null) {
                hql += " AND r.escola = :escola ";
                params.put("escola", relatorio.getEscola());
            }
            if (relatorio.getTurma() != null) {
                hql += " AND r.turma = :turma ";
                params.put("turma", relatorio.getTurma());
            }
            if (relatorio.getBimestre() != null) {
                hql += " AND r.bimestre = :bimestre ";
                params.put("bimestre", relatorio.getBimestre());
            }
            if(relatorio.getAluno() != null){
                hql += " AND r.aluno = :aluno ";
                params.put("aluno", relatorio.getAluno());
            }
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
