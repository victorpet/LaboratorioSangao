/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.facade;

import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.TipoExame;
import java.util.List;

/**
 *
 * @author prado
 */
public interface IColetaFacade {
    
    public void adicionar(Object o);
    
    public boolean inserirAtualizar(Object o);
    
    public void atualizar(Object o);
    
    public void remover(Integer id);
    
    public Coleta select(Integer id);
    
    public List select();
    
    public List<Coleta> getAllColetas();
    
    public List<TipoExame> getAllTipoExames();
    
    public Coleta getColeta(Integer id);
}
