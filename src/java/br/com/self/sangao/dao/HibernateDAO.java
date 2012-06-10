/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public abstract class HibernateDAO {

    private static final Logger log = Logger.getLogger(HibernateDAO.class);
    EntityManager em;

    public HibernateDAO() {
    }

    public boolean adicionar(Object o) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(o);
            t.commit();
            return true;
        } catch (Exception e) {
            log.error(e);
            t.rollback();
        } finally {
            em.close();
        }
        return false;
    }

    public void atualizar(Object o) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(o);
            t.commit();
        } catch (Exception e) {
            log.error(e);
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
