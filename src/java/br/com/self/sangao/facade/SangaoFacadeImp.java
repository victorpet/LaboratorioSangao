/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.facade;

import br.com.self.sangao.bo.SangaoBO;
import br.com.self.sangao.entity.Entidade;
import org.apache.log4j.Logger;

/**
 *
 * @author prado
 */
public class SangaoFacadeImp implements ISangaoFacade {

    private static final Logger log = Logger.getLogger(SangaoFacadeImp.class);
    
    private static SangaoBO bo = new SangaoBO();

    @Override
    public boolean inserirRegistro(Entidade e) {
        return bo.inserirRegistro(e);
    }
}
