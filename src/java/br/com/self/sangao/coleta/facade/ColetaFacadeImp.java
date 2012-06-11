/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.facade;

import br.com.self.sangao.coleta.bo.ColetaBO;
import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.TipoExame;
import java.util.List;

/**
 *
 * @author prado
 */
public class ColetaFacadeImp implements IColetaFacade {
    
    ColetaBO bo = new ColetaBO();
    
    @Override
    public void adicionar(Object o){
        bo.adicionar(o);
    }
    
    @Override
    public boolean inserirAtualizar(Object o) {
        return bo.atualizar(o);
    }
    
    @Override
    public void atualizar(Object o){
        bo.atualizar(o);
    }
    
    @Override
    public void remover(Integer id){
        bo.remover(id);
    }
    
    @Override
    public Coleta select(Integer id){
        return (Coleta) bo.select(id);
    }
    
    @Override
    public List select(){
        return bo.select();
    }
    
    @Override
    public List<Coleta> getAllColetas(){
        return bo.getAllColetas();
    }

    @Override
    public List<TipoExame> getAllTipoExames() {
        return bo.getAllTipoExames();
    }

    @Override
    public Coleta getColeta(Integer id) {
        return bo.getColeta(id);
    }
}
