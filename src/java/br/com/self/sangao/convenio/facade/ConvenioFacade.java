/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.convenio.facade;

/**
 *
 * @author Victor
 */
public class ConvenioFacade {
    
    private static IConvenioFacade facade;
    
    public static IConvenioFacade getInstance(){
        
        if(facade == null){
            facade = new ConvenioFacadeImp();
        }
        
        return facade;
    }
    
}
