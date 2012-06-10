/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.usuario.bo;

import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.usuario.dao.UsuarioDAO;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class UsuarioBO {
    
    private static final Logger log = Logger.getLogger(UsuarioBO.class);
    
    UsuarioDAO dao = UsuarioDAO.getInstance();
    
    public boolean isValid(Usuario usuario) {
       return dao.isValid(usuario);
    }

    public void adicionar(Usuario m) {
        dao.adicionar(m);
    }

    public void remover(Usuario m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void atualizar(Usuario m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Object> select() {
        return dao.select();
    }
}
