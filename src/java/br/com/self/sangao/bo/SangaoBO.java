/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.bo;

import br.com.self.sangao.dao.SangaoDAO;
import br.com.self.sangao.entity.Entidade;

/**
 *
 * @author prado
 */
public class SangaoBO {
    
    SangaoDAO dao = SangaoDAO.getDAO();

    public boolean inserirRegistro(Entidade e){
        return dao.adicionar(e);
    }
}
