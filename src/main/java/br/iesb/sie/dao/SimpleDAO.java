package br.iesb.sie.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class SimpleDAO {


    @PersistenceContext(name = "sie-pu")
    private EntityManager em;

    public Session getSession() {
        return (Session) em.getDelegate();
    }
}
