/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.exames;

import br.com.self.sangao.front.entity.Exames;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class ExamesClientesBO {
    
    private static final Logger log = Logger.getLogger(ExamesClientesBO.class);
    
    ExamesClientesDAO dao = ExamesClientesDAO.getInstance();
    
    public void adicionar(Exames e) {
        dao.adicionar(e);
    }
    
}
