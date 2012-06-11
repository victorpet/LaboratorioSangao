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
        dao.remover(m);
    }
    
    public void remover(Object ob, Class classe){
        dao.remover(ob, classe);
    }

    public void atualizar(Object ob, Class classe){
        dao.atualizar(ob, classe);
    }

    public Usuario select(Integer id){
        return (Usuario) dao.select(id, new Usuario());
    }
    
    public List<Object> select() {
        return dao.select();
    }
}
