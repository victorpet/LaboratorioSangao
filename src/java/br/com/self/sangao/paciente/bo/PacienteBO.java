/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.bo;

import br.com.self.sangao.paciente.dao.PacienteDAO;
import br.com.self.sangao.entity.Entidade;
import br.com.self.sangao.entity.Paciente;

/**
 *
 * @author prado
 */
public class PacienteBO {
    
    PacienteDAO dao = PacienteDAO.getDAO();

    public boolean inserirRegistro(Entidade e){
        return dao.adicionar(e);
    }
    
    public void remover(Integer id){
        dao.remover(id, Paciente.class);
    }
    
    public void remover(Paciente p){
        dao.remover(p);
    }
}
