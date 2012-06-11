/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.facade;

import br.com.self.sangao.entity.Entidade;
import br.com.self.sangao.entity.Paciente;

/**
 *
 * @author prado
 */
public interface IPacienteFacade {
    
    public boolean inserirRegistro(Entidade e);
    
    public void remover(Integer id);
    
    public void remover(Paciente p);
}
