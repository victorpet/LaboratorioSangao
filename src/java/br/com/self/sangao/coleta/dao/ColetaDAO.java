/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import br.com.self.sangao.entity.Coleta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class ColetaDAO extends HibernateDAO {

    private static final Logger log = Logger.getLogger(ColetaDAO.class);
    private static ColetaDAO dao;

    public static ColetaDAO getInstance() {

        if (dao == null) {
            dao = new ColetaDAO();
        }

        return dao;
    }

    @Override
    public List select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Coleta> getAllColetas() {
        EntityManager em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        List<Coleta> list = new ArrayList<Coleta>();
        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Coleta.findAll");
            list = query.getResultList();
        } catch (Exception e) {
            t.rollback();
            log.error("Erro ao selectionar coletas", e);
        } finally {
            em.close();
        }
        return list;

    }
}
