/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.facade;

import br.com.self.sangao.coleta.bo.ColetaBO;
import br.com.self.sangao.entity.Coleta;
import java.util.List;

/**
 *
 * @author prado
 */
public class ColetaFacadeImp implements IColetaFacade {
    
    ColetaBO bo = new ColetaBO();
    
    public void adicionar(Object o){
        bo.adicionar(o);
    }
    
    public void inserirAtualizar(Object o) {
        bo.atualizar(o);
    }
    
    public void atualizar(Object o){
        bo.atualizar(o);
    }
    
    public void remover(Integer id){
        bo.remover(id);
    }
    
    public Coleta select(Integer id){
        return (Coleta) bo.select(id);
    }
    
    public List select(){
        return bo.select();
    }
    
    public List<Coleta> getAllColetas(){
        return bo.getAllColetas();
    }
}
