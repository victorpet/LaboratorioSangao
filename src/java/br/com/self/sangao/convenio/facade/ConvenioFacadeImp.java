/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.convenio.facade;

import br.com.self.sangao.convenio.bo.ConvenioBO;
import br.com.self.sangao.entity.Convenio;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ConvenioFacadeImp implements IConvenioFacade{

    private static ConvenioBO bo = new ConvenioBO();
    
    @Override
    public void adicionar(Object o) {
        bo.adicionar(o);
    }

    @Override
    public void atualizar(Object o) {
        bo.atualizar(o);
    }

    @Override
    public void remover(Integer id) {
        bo.remover(id);
    }

    @Override
    public Convenio select(Integer id) {
        return bo.select(id);
    }

    @Override
    public List select() {
        return bo.select();
    }

    @Override
    public List selectByPaciente(Integer pacienteID) {
        return bo.selectByPaciente(pacienteID);
    }
    
}
