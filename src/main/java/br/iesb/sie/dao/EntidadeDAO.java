package br.iesb.sie.dao;

import br.iesb.sie.entidade.Entidade;

import javax.inject.Named;

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

        hql.append(" select e.login ");
        hql.append(" from ").append(Entidade.class.getName()).append(" e ");
        hql.append(" where e.login = :login ");

        return (Entidade) getSession().createQuery(hql.toString())
                .setParameter("login", Integer.valueOf(login)).uniqueResult();
    }
}
