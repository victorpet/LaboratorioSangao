/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.exames;

import br.com.self.sangao.dao.HibernateDAO;
import java.util.List;

/**
 *
 * @author prado
 */
public class ExamesClientesDAO extends HibernateDAO {
    
    private static ExamesClientesDAO dao;

    public static ExamesClientesDAO getInstance() {

        if (dao == null) {
            dao = new ExamesClientesDAO();
        }
        return dao;
    }

    @Override
    public List select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
