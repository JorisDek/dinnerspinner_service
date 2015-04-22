/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jorisdek.dinnerspinner.service;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import nl.jorisdek.dinnerspinner.entity.Dishes;

/**
 *
 * @author Gebruiker
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public List<T> findRandom(boolean gezond, boolean goedkoop, boolean snel, boolean simpel){
        System.out.println("gezond: "+gezond+" goedkoop: "+goedkoop+" snel: "+snel+" simpel: "+simpel);
        String query = "SELECT id FROM dishes d ";
        if(!gezond && !goedkoop && !snel && !simpel){
            
        } else {
            query += "WHERE ";
        }
        if(gezond) {
            if (goedkoop || snel || simpel) {
                query += "d.gezond = 1 OR ";
            } else {
                query += "d.gezond = 1";
            }
        }
        if(goedkoop){
            if(snel || simpel){
                query += "d.goedkoop = 1 OR ";
            } else {
                query += "d.goedkoop = 1";
            }
        }
        if(snel){
            if(simpel){
                query += "d.snel = 1 OR ";
            } else {
                query += "d.snel = 1";
            }
        }
        if(simpel){
            query += "d.simpel = 1";
        }
        
        
        javax.persistence.Query q = getEntityManager().createQuery(query);
        List list;
        list = q.getResultList();
        System.out.println("Lijst van dishes na filter!!!"+list);
        Random rand = new Random();
        int min = 0;
        int max = list.size()-1;
        int random = rand.nextInt((max - min) + 1) + min;
        ArrayList element = new ArrayList();
        
        System.out.println(list.get(random));
        return getEntityManager().createQuery(query).getResultList();
    }
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        System.out.println("CQ "+getEntityManager().createQuery(cq));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
