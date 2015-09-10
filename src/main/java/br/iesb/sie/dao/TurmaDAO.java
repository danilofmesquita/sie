package br.iesb.sie.dao;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.entity.Turma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaDAO extends BaseDAO<Turma, Long> {

    public TurmaDAO() {
        super(Turma.class);
    }


    public List buscarTurmas(Turma filtro, List<Entidade> escolas) {

        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT t FROM Turma t ";
        hql += " WHERE 1=1 ";

        if (filtro != null) {
            if (filtro.getEscola() != null) {
                hql += " AND t.escola = :escola ";
                params.put("escola", filtro.getEscola());
            }

            if (filtro.getSerie() != null) {
                hql += " AND t.serie = :serie";
                params.put("serie", filtro.getSerie());
            }

            if (filtro.getNome() != null) {
                hql += " AND t.nome like :nome ";
                params.put("nome", filtro.getNome());
            }

            if (filtro.getAno() != null) {
                hql += " AND t.ano = :ano ";
                params.put("ano", filtro.getAno());
            }

            if (filtro.getTurno() != null) {
                hql += " AND t.turno = :turno ";
                params.put("turno", filtro.getTurno());
            }
        }

        if (escolas != null && !escolas.isEmpty()) {
            hql += " AND t.escola in :escolas ";
            params.put("escolas", escolas);
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
