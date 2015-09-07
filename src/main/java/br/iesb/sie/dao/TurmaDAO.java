package br.iesb.sie.dao;

import br.iesb.sie.entity.Turma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaDAO extends BaseDAO<Turma, Long> {

    public TurmaDAO() {
        super(Turma.class);
    }


    public List buscarTurmas(Turma filtro) {

        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT t FROM Turma t ";
        hql += " WHERE 1=1 ";

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

        if (filtro.getDataInicio() != null) {
            hql += " AND t.dataInicio >= :dataInicio ";
            params.put("dataInicio", filtro.getDataInicio());
        }

        if (filtro.getDataFim() != null) {
            hql += " AND t.dataFim <= :dataFim ";
            params.put("dataFim", filtro.getDataFim());
        }

        if (filtro.getTurno() != null) {
            hql += " AND t.turno = :turno ";
            params.put("turno", filtro.getTurno());
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();
    }
}
