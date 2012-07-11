/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.facade;

import br.com.self.sangao.entity.Entidade;
import br.com.self.sangao.entity.Paciente;
import java.util.List;

/**
 *
 * @author prado
 */
public interface IPacienteFacade {
    
    public boolean inserirAtualizarRegistro(Entidade e);
    
    public void remover(Integer id);
    
    public void remover(Paciente p);
    
    public List<Paciente> getAllPacientes();
    
    public Paciente getPaciente(Integer id);
    
    public Paciente getPacientePorId(Integer id);
}
