package br.iesb.sie.dao;

import br.iesb.sie.entidade.Perfil;

import javax.inject.Named;
import javax.persistence.TypedQuery;

@Named
public class PerfilDAO extends BaseDAO<Perfil> {
	
	public Perfil buscarPerfil(String nome){
        TypedQuery<Perfil> query =
                getEntityManager().createQuery("select p from Perfil p where p.nome = :nome ", Perfil.class);

        query.setParameter("nome", nome);

        if(query.getResultList().isEmpty()){
            getEntityManager().persist(new Perfil(nome));
            return buscarPerfil(nome);
        } else {
            return query.getResultList().get(0);
        }
    }


}
