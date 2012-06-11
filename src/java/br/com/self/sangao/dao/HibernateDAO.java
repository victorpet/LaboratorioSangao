/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.dao;

import br.com.self.sangao.entity.Entidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public abstract class HibernateDAO<T> {

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
            t.rollback();
            log.error("Erro ao adicionar objeto", e);
        } finally {
            em.close();
        }
        return false;
    }

    public <T extends Entidade> void atualizar(Object obj, Class<T> classe) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            T o = em.find(classe, obj);
            t.begin();
            em.merge(o);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            log.error("Erro ao atualizar objeto", e);
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
            log.error("Erro ao remover objeto", e);
        } finally {
            em.close();
        }
    }

    public <T extends Entidade> void remover(Object obj, Class<T> classe) {
        em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        try {
            T o = em.find(classe, obj);
            t.begin();

            em.remove(o);

            t.commit();
        } catch (Exception e) {
            t.rollback();
            log.error("Erro ao remover objeto", e);
        } finally {
            em.close();
        }
    }

    public abstract List<Object> select();
}
