package br.iesb.sie.dao;

import java.util.List;

import javax.inject.Named;

import br.iesb.sie.entidade.Usuario;

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
}
