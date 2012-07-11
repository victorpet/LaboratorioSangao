/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.resultado.facade;

/**
 *
 * @author victor
 */
public class ResultadoFacade {
    
    private static IResultadoFacade facade;
    
    public static IResultadoFacade getInstance(){
        
        if(facade == null){
            facade = new ResultadoFacadeImp();
        }
        
        return facade;
    }
    
}
