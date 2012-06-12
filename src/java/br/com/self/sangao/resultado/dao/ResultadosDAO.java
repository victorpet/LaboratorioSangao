package br.com.self.sangao.resultado.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import br.com.self.sangao.entity.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.apache.poi.hssf.record.formula.functions.T;

/**
 *
 * @author victor
 */
public class ResultadosDAO extends  HibernateDAO<T> {

    private static ResultadosDAO dao;
    
    public static ResultadosDAO getInstance(){
        
        if(dao == null){
            dao = new ResultadosDAO();
        }
        
        return dao;
    }
    
    @Override
    public List<Object> select() {
        
        EntityManager em = PersistenceManager.getInstance().getConnection();
        EntityTransaction t = em.getTransaction();
        List list = null;
        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Resultado.findAll");
            list = query.getResultList();
        } catch (Exception e) {
            t.rollback();
        } finally {
            em.close();
        }
        return list;
        
    }
     
}
