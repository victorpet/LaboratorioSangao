/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.facade;

import br.com.self.sangao.paciente.bo.PacienteBO;
import br.com.self.sangao.entity.Entidade;
import br.com.self.sangao.entity.Paciente;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class PacienteFacadeImp implements IPacienteFacade {

    private static final Logger log = Logger.getLogger(PacienteFacadeImp.class);
    
    private static PacienteBO bo = new PacienteBO();

    @Override
    public boolean inserirAtualizarRegistro(Entidade e) {
        return bo.inserirAtualizarRegistro(e);
    }

    @Override
    public void remover(Integer id) {
        bo.remover(id);
    }

    @Override
    public void remover(Paciente p) {
        bo.remover(p);
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return bo.getAllPacientes();
    }

    @Override
    public Paciente getPaciente(Integer id) {
        return bo.getPaciente(id);
    }
}
