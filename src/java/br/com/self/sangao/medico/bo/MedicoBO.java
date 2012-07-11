/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.medico.bo;

import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.medico.dao.MedicoDAO;
import br.com.self.sangao.usuario.bo.UsuarioBO;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class MedicoBO {

    private static final Logger log = Logger.getLogger(UsuarioBO.class);
    
    MedicoDAO dao = MedicoDAO.getInstance();
  
    public List<Object> select() {
        return dao.select();
    }

    public void adicionar(Medico m) {
        dao.adicionar(m);
    }

    public void remover(Medico m) {
        dao.remover(m);
    }

    public void remover(Integer id){
        dao.remover(id, Medico.class);
    }
    
    public Medico select(Integer id){
        return (Medico) dao.select(id, new Medico());
    }
    
    public void atualizar(Medico m) {
        dao.atualizar(m);
    }
    
    public List<Medico> getAllMedicos(){
        return dao.getAllMedicos();
    }
    
    public Medico buscaMedicosPorCrm(String crm){
        return dao.buscaMedicoPorCrm(crm);
    }
}
