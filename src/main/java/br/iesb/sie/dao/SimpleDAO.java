package br.iesb.sie.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class SimpleDAO {

    @PersistenceContext(name = "sie-pu")
    private EntityManager em;

    public Session getSession() {
        return (Session) em.getDelegate();
    }
}
