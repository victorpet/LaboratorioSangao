/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.convenio.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class ConvenioDAO extends HibernateDAO {

    private static ConvenioDAO dao;
    
    public static ConvenioDAO getInstance(){
        
        if(dao == null){
            dao = new ConvenioDAO();
        }
        
        return dao;
    }
    
    @Override
    public List select() {
        
         List<Object> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Convenio.findAll");
            list = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List selectByPaciente(Integer pacienteID){
        
         List<Object> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Convenio.findByPaciente");
            query.setParameter("idPaciente", pacienteID);
            list = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
        
    }
    
}
