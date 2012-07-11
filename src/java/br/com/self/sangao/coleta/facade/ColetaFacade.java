/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.coleta.facade;

/**
 *
 * @author prado
 */
public class ColetaFacade {
    
    private static IColetaFacade facade;
    
    public static IColetaFacade getInstance(){
        
        if(facade == null){
            facade = new ColetaFacadeImp();
        }
        
        return facade;
    }
}
