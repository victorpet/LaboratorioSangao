/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.resultado.facade;

import br.com.self.sangao.entity.Resultado;
import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.resultado.bo.ResultadoBO;
import java.util.List;

/**
 *
 * @author victor
 */
public class ResultadoFacadeImp implements IResultadoFacade{

    private ResultadoBO bo = new ResultadoBO();
    
    @Override
    public List<Object> select() {
        return bo.select();
    }

    @Override
    public void adicionar(Resultado resultado) {
        bo.adicionar(resultado);
    }

    @Override
    public void remover(Resultado resultado) {
       bo.remover(resultado);
    }

    @Override
    public void remover(Object ob) {
        bo.remover(ob);
    }

    @Override
    public Resultado select(Integer id) {
        return bo.select(id);
    }

    @Override
    public void atualizar(Object ob) {
        bo.atualizar(ob);
    }
    
}
