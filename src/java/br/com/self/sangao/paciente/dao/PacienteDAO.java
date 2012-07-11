/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import br.com.self.sangao.entity.Paciente;
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
public class PacienteDAO extends HibernateDAO {

    private static final Logger log = Logger.getLogger(PacienteDAO.class);
    private static PacienteDAO instance;

    public static PacienteDAO getDAO() {
        if (instance == null) {
            instance = new PacienteDAO();
        }
        return instance;
    }

    @Override
    public List<Object> select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Paciente> getAllPacientes() {
        EntityManager em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        List<Paciente> list = new ArrayList<Paciente>();
        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("PacPiente.findAll");
            list = query.getResultList();
        } catch (Exception e) {
            t.rollback();
            log.error("Erro ao selectionar pacientes", e);
        } finally {
            em.close();
        }
        return list;
    }
    
    public Paciente getPacientePorId(Integer id) {
        EntityManager em = PersistenceManager.getInstance().getConnection();
        Paciente p = null;
        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Paciente.findById");
            p = (Paciente) query.getSingleResult();
        } catch (Exception e) {
            log.error("Erro ao selectionar pacientes", e);
        } finally {
            em.close();
        }
        return p;
    }
}
