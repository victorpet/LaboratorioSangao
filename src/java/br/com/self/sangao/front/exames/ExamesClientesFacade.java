/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.exames;

/**
 *
 * @author prado
 */
public class ExamesClientesFacade {

    private static IExamesClientesFacade facade;

    public static IExamesClientesFacade getInstance() {

        if (facade == null) {
            facade = new ExamesClientesFacadeImp();
        }

        return facade;
    }
}
