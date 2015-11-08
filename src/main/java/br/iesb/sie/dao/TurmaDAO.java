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

    @SuppressWarnings("unchecked")
    public List<Turma> buscarTurmas(Turma filtro, List<Entidade> escolas) {

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

    @SuppressWarnings("unchecked")
    public List<Turma> buscarTurmasPorEscolaAluno(Entidade escola, Entidade aluno) {

        String hql = "";

        hql += " SELECT distinct t FROM Turma t ";
        hql += " INNER JOIN t.matriculas m ";
        hql += " WHERE m.aluno = :aluno ";
        hql += " AND t.escola = :escola ";

        return getSession().createQuery(hql).setParameter("aluno", aluno).setParameter("escola", escola).list();

    }

    @SuppressWarnings("unchecked")
    public List<Turma> buscarTurmasPorEscola(Entidade escola) {
        String hql = "SELECT distinct t FROM Turma t WHERE t.escola = :escola ";
        return getSession().createQuery(hql).setParameter("escola", escola).list();
    }

    @SuppressWarnings("unchecked")
    public List<Entidade> buscarAlunosPorTurma(Turma turma) {
        String hql = "SELECT distinct m.aluno FROM Matricula m where m.turma = :turma";
        return getSession().createQuery(hql).setParameter("turma", turma).list();
    }

    public List<Turma> buscarTurmasPorAluno(Entidade aluno) {

        String hql = "";

        hql += " SELECT distinct t FROM Turma t ";
        hql += " INNER JOIN t.matriculas m ";
        hql += " WHERE m.aluno = :aluno ";
        hql += " ORDER BY t.id ASC";

        return getSession().createQuery(hql).setParameter("aluno", aluno).list();
    }
}
