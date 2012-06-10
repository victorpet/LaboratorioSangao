/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.bo;

import br.com.self.sangao.paciente.dao.PacienteDAO;
import br.com.self.sangao.entity.Entidade;

/**
 *
 * @author prado
 */
public class PacienteBO {
    
    PacienteDAO dao = PacienteDAO.getDAO();

    public boolean inserirRegistro(Entidade e){
        return dao.adicionar(e);
    }
}
