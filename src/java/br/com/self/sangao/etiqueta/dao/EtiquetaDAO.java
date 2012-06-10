/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.etiqueta.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author treinamento
 */
public class EtiquetaDAO extends HibernateDAO {

    private static EtiquetaDAO emf;

    public static EtiquetaDAO getInstance(){
        if (emf == null)
            emf = new EtiquetaDAO();
        return emf;
    }

    @Override
    public List<Object> select() {
        List<Object> list = null;
        Query query = PersistenceManager.getInstance().getConnection().
                createQuery("");
        //query.setParameter("");
        list = query.getResultList();
        return list;
    }
}
