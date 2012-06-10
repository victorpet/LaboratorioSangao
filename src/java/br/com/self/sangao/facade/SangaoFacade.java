/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.facade;

/**
 *
 * @author prado
 */
public class SangaoFacade {

    private static ISangaoFacade instance;

    public static ISangaoFacade getInstance() {
        if (instance == null) {
            instance = new SangaoFacadeImp();
        }
        return instance;
    }
}
