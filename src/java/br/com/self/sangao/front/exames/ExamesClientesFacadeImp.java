/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.exames;

import br.com.self.sangao.front.entity.Exames;

/**
 *
 * @author prado
 */
public class ExamesClientesFacadeImp implements IExamesClientesFacade {
    
    private static ExamesClientesBO bo = new ExamesClientesBO();

    @Override
    public void gravar(Exames e) {
        bo.adicionar(e);
    }
    
}
