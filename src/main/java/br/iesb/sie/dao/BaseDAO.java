package br.iesb.sie.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class BaseDAO<T, ID extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext(name = "sie-pu")
    private EntityManager em;

    public BaseDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void salvar(T t) {
        getSession().saveOrUpdate(t);
    }

    public Session getSession() {
        return (Session) em.getDelegate();
    }

    public T get(ID id) {
        return (T) getSession().get(clazz, id);
    }
}
