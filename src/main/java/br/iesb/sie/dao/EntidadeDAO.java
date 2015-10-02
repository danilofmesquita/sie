package br.iesb.sie.dao;

import br.iesb.sie.entity.Entidade;
import br.iesb.sie.model.Perfil;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class EntidadeDAO extends BaseDAO<Entidade, Long> {

    public EntidadeDAO() {
        super(Entidade.class);
    }

    public Integer buscarUltimoLogin() {
        String hql = "";
        hql += " SELECT e.login ";
        hql += " FROM Entidade e ";
        hql += " ORDER BY e.login DESC ";

        Object login = getSession().createQuery(hql).setMaxResults(1).uniqueResult();

        if (login != null) {
            return (Integer) login;
        } else {
            return 0;
        }
    }

    public Entidade buscarEntidadePorLogin(String login) {

        String hql = "";
        hql += " SELECT e ";
        hql += " FROM Entidade e ";
        hql += " WHERE e.login = :login ";

        return (Entidade) getSession().createQuery(hql).setParameter("login", Integer.valueOf(login)).uniqueResult();
    }

    public List buscarEntidadesPorPerfil(Perfil perfil) {

        String hql = "";
        hql += " SELECT e ";
        hql += " FROM Entidade e ";
        hql += " INNER JOIN e.perfis p ";
        hql += " WHERE p = :perfil ";


        return getSession().createQuery(hql).setParameter("perfil", perfil).list();
    }

    public List buscarProfessores(Entidade escola) {
        String hql = "";
        Map<String, Object> params = new HashMap<>();

        hql += " SELECT f.funcionario FROM Funcionario f ";
        hql += " WHERE 1=1 ";
        hql += " AND f.perfil = :professor ";
        hql += " AND f.vinculoAtivo = true ";

        params.put("professor", Perfil.PROFESSOR);

        if (escola != null) {
            hql += " AND f.escola = :escola ";
            params.put("escola", escola);
        }

        return addQueryParams(params, getSession().createQuery(hql)).list();

    }

    public List<Entidade> buscarEscolasVinculadas(Entidade funcionario, Perfil perfil) {
        String hql = "";

        hql += " SELECT distinct e FROM Entidade e ";
        hql += " INNER JOIN e.funcionarios f ";
        hql += " where f.funcionario = :funcionario ";
        hql += " and f.perfil = :perfil ";
        hql += " and f.vinculoAtivo is true ";

        return getSession().createQuery(hql)

                .setParameter("funcionario", funcionario)
                .setParameter("perfil", perfil).list();
    }

    public List<Entidade> buscarAlunosVinculados(List<Entidade> escolasVinculadas) {
        String hql = "";

        hql += " SELECT m.aluno FROM Matricula m ";
        hql += " where m.escola in :escolasVinculadas";

        return getSession().createQuery(hql)
                .setParameterList("escolasVinculadas", escolasVinculadas).list();
    }

    public List<Entidade> buscarEscolasVinculadasAoAluno(Entidade aluno) {

        String hql = "";

        hql += " SELECT distinct t.escola FROM Turma t ";
        hql += " INNER JOIN t.matriculas m ";
        hql += " where m.aluno = :aluno ";

        return getSession().createQuery(hql)
                .setParameter("aluno", aluno).list();
    }
}