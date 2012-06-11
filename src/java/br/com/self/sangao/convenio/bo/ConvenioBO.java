/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.convenio.bo;

import br.com.self.sangao.convenio.dao.ConvenioDAO;
import br.com.self.sangao.entity.Convenio;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ConvenioBO {
    
    private static ConvenioDAO dao = ConvenioDAO.getInstance();
    
    public void adicionar(Object o){
        dao.adicionar(o);
    }
    
    public void atualizar(Object o){
        dao.atualizar(o);
    }
    
    public void remover(Integer id){
        dao.remover(id, Convenio.class);
    }
    
    public Convenio select(Integer id){
        return (Convenio)dao.select(id, new Convenio());
    }
    
    public List select(){
        return dao.select();
    }
    
    public List selectByPaciente(Integer pacienteID){
        return dao.selectByPaciente(pacienteID);
    }
    
}
