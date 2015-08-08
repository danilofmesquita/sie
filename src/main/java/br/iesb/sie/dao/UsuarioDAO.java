package br.iesb.sie.dao;

import br.iesb.sie.entidade.Usuario;

import javax.inject.Named;
import java.util.List;

@Named
public class UsuarioDAO extends BaseDAO<Usuario> {

	public Integer buscarUltimoLogin() {
		String query = "select u.login from Usuario u order by u.login desc";

		List<Integer> rl = getEntityManager().createQuery(query, Integer.class).setMaxResults(1).getResultList();

		if (rl.isEmpty()) {
			return null;
		} else {
			return rl.get(0);
		}
	}

	public Usuario buscarUsuarioPorLogin(String login) {
		String query = "select u from Usuario u where u.login = :login";
		return getEntityManager().createQuery(query, Usuario.class).setParameter("login", Integer.valueOf(login)).getSingleResult();
	}
}
