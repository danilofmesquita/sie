package br.iesb.sie.dao;

import br.iesb.sie.entity.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Map;

public class BaseDAO<T extends BaseEntity, ID extends Serializable> {

    private final Class<T> clazz;

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

    public Query addQueryParams(Map<String, Object> params, Query query) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }
}
