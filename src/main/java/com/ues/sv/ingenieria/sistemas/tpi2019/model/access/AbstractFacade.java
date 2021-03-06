/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sv.ingenieria.sistemas.tpi2019.model.access;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;

/**
 *
 * @author bryan
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     * @return
     */
    public T create(T entity) {
        if (getEntityManager() != null && entity != null) {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            return entity;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     *
     * @param entity
     */
    public void edit(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().merge(entity);
            } else {
                throw new NullPointerException("");
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }

    /**
     *
     * @param entity
     */
    public void remove(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().remove(getEntityManager().merge(entity));
            } else {
                throw new NullPointerException("");
            }
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public T findById(Object id) {
        try {
            if (entityClass != null && id != null) {
                return getEntityManager().find(entityClass, id);
            } else {
                throw new NullPointerException("");
            }
        } catch (NullPointerException ex) {
            System.err.println(ex);
        }
        return null;
    }

    public List<T> findAll() {
        try {
            if (entityClass != null && getEntityManager() != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                return getEntityManager().createQuery(cq).getResultList();
            } else {
                return Collections.EMPTY_LIST;
            }
        } catch (Exception e) {
             System.err.println(e);
        }
        return Collections.emptyList();
    }

    public List<T> findRange(int primero, int tamnio) {
        try {
            if (entityClass != null && getEntityManager() != null && tamnio > 0 && primero >= 0) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                q.setMaxResults(tamnio);
                q.setFirstResult(primero);
                return q.getResultList();
            } else {
                throw new NullPointerException("");
            }
        } catch (NullPointerException e) {
             System.err.println(e);
        }
        return Collections.emptyList();
    }

    public int count() {
        try {
            if (getEntityManager() != null && entityClass != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
                cq.select(getEntityManager().getCriteriaBuilder().count(rt));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                return ((Long) q.getSingleResult()).intValue();
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
             System.err.println(e);
        }
        return 0;
    }

    public Query executeQuery(String query) {
        if (getEntityManager() != null && query != null && !query.isEmpty()) {
            return getEntityManager().createQuery(query);
        }
        return null;
    }

}
