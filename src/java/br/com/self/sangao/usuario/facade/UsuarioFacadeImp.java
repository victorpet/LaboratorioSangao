/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.usuario.facade;

import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.usuario.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author Victor
 */
public class UsuarioFacadeImp implements IUsuarioFacade{

    @Override
    public boolean isValid(Usuario usuario) {
       return UsuarioDAO.getInstance().isValid(usuario);
    }

    @Override
    public void adicionar(Usuario m) {
        UsuarioDAO.getInstance().adicionar(m);
    }

    @Override
    public void remover(Usuario m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Usuario m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> select() {
        return UsuarioDAO.getInstance().select();
    }
    
}
