package br.iesb.sie.dao;

import br.iesb.sie.entidade.Usuario;

import javax.inject.Named;

@Named
public class UsuarioDAO extends BaseDAO<Usuario, Long> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Integer buscarUltimoLogin() {
        String query = "select u.login from Usuario u order by u.login desc";

        Object login = getSession().createQuery(query).setMaxResults(1).uniqueResult();

        if (login != null) {
            return (Integer) login;
        } else {
            return null;
        }
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        String query = "select u from Usuario u where u.login = :login";
        return (Usuario) getSession().createQuery(query).setParameter("login", Integer.valueOf(login)).uniqueResult();
    }
}
