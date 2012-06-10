/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author treinamento
 */
public abstract class  HibernateDAO {

    EntityManager em;

    public HibernateDAO() {
    }

    public void adicionar(Object o) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(o);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            em.close();
        }
    }

    public void atualizar(Object o) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(o);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            em.close();
        }
    }

    public void remover(Object o) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.remove(o);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            em.close();
        }
    }

    public abstract List<Object> select();
}
