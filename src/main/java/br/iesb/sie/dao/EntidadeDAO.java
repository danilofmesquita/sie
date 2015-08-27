package br.iesb.sie.dao;

import br.iesb.sie.entidade.Entidade;
import br.iesb.sie.model.Perfil;

import javax.inject.Named;
import java.util.List;

@Named
public class EntidadeDAO extends BaseDAO<Entidade, Long> {

    public EntidadeDAO() {
        super(Entidade.class);
    }

    public Integer buscarUltimoLogin() {
        StringBuilder hql = new StringBuilder();

        hql.append(" select e.login ");
        hql.append(" from ").append(Entidade.class.getName()).append(" e ");
        hql.append(" order by e.login desc ");

        Object login = getSession().createQuery(hql.toString())
                .setMaxResults(1).uniqueResult();

        if (login != null) {
            return (Integer) login;
        } else {
            return 0;
        }
    }

    public Entidade buscarEntidadePorLogin(String login) {

        StringBuilder hql = new StringBuilder();

        hql.append(" select e  ");
        hql.append(" from ").append(Entidade.class.getName()).append(" e ");
        hql.append(" where e.login = :login ");

        return (Entidade) getSession().createQuery(hql.toString())
                .setParameter("login", Integer.valueOf(login)).uniqueResult();
    }

    public List<Entidade> buscarEscolas() {
        return getSession().createQuery("select e from Entidade e inner join e.perfis p where p = :escola")
                .setParameter("escola", Perfil.ESCOLA).list();
    }

    public List<Entidade> buscarEntidadesPorPerfil(Perfil perfil) {
        return (List<Entidade>) getSession()
                .createQuery(" select e from Entidade e inner join e.perfis p where p = :perfil")
                .setParameter("perfil", perfil).list();
    }
}
