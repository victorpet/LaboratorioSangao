/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.facade;

/**
 *
 * @author prado
 */
public class PacienteFacade {

    private static IPacienteFacade instance;

    public static IPacienteFacade getInstance() {
        if (instance == null) {
            instance = new PacienteFacadeImp();
        }
        return instance;
    }
}
