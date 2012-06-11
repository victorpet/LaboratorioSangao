/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.convenio.facade;

import br.com.self.sangao.entity.Convenio;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IConvenioFacade {
    
    public void adicionar(Object o);
    
    public void atualizar(Object o);
    
    public void remover(Integer id);
    
    public Convenio select(Integer id);
    
    public List select();
    
    public List selectByPaciente(Integer pacienteID);
    
}
