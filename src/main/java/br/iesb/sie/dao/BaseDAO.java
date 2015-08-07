package br.iesb.sie.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAO<T> {

	@PersistenceContext(name = "sie-pu")
	private EntityManager em;
	
	public void salvar(T t){
		em.persist(t);
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
}
