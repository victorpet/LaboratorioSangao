/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.facade;

import br.com.self.sangao.paciente.bo.PacienteBO;
import br.com.self.sangao.entity.Entidade;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class PacienteFacadeImp implements IPacienteFacade {

    private static final Logger log = Logger.getLogger(PacienteFacadeImp.class);
    
    private static PacienteBO bo = new PacienteBO();

    @Override
    public boolean inserirRegistro(Entidade e) {
        return bo.inserirRegistro(e);
    }
}
