/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.usuario.facade;

import br.com.self.sangao.entity.Usuario;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IUsuarioFacade {

    public List<Object> select();

    public boolean isValid(Usuario usuario);

    public void adicionar(Usuario usuario);

    public void remover(Usuario usuario);

    public void remover(Object ob, Class classe);
    
    public Usuario select(Integer id);
    
    public void atualizar(Object ob, Class classe);
}
