package br.iesb.sie.dao;

import br.iesb.sie.entity.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;


public class BaseDAO<T extends BaseEntity, ID extends Serializable> extends SimpleDAO {

    private final Class<T> clazz;

    public BaseDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void salvar(T t) {
        getSession().saveOrUpdate(t);
    }

    public T get(ID id) {
        return (T) getSession().get(clazz, id);
    }

    public Query addQueryParams(Map<String, Object> params, Query query) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof Collection) {
                query.setParameterList(entry.getKey(), (Collection) entry.getValue());
            } else {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query;
    }
}
