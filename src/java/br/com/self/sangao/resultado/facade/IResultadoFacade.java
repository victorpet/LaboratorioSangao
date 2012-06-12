/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.resultado.facade;

import br.com.self.sangao.entity.Resultado;
import br.com.self.sangao.entity.Usuario;
import java.util.List;

/**
 *
 * @author victor
 */
public interface IResultadoFacade {
    
    public List<Object> select();

    public void adicionar(Resultado usuario);

    public void remover(Resultado usuario);

    public void remover(Object ob);
    
    public Resultado select(Integer id);
    
    public void atualizar(Object ob);
    
}
