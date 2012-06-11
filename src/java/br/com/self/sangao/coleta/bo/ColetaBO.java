/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.bo;

import br.com.self.sangao.coleta.dao.ColetaDAO;
import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.TipoExame;
import java.util.List;

/**
 *
 * @author prado
 */
public class ColetaBO {
    
    private static ColetaDAO dao = ColetaDAO.getInstance();
    
    public void adicionar(Object o){
        dao.adicionar(o);
    }
    
    public void inserirAtualizar(Object o) {
        dao.atualizar(o);
    }
    
    public boolean atualizar(Object o){
        return dao.atualizar(o);
    }
    
    public void remover(Integer id){
        dao.remover(id, Coleta.class);
    }
    
    public Coleta select(Integer id){
        return (Coleta) dao.select(id, new Coleta());
    }
    
    public List select(){
        return dao.select();
    }
    
    public List<Coleta> getAllColetas(){
        return dao.getAllColetas();
    }
    
    public List<TipoExame> getAllTipoExames(){
        return dao.getAllTipoExames();
    }
    
    public Coleta getColeta(Integer id){
        return dao.getColeta(id);
    }
}
