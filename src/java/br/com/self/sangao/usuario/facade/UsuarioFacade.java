/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.usuario.facade;

/**
 *
 * @author Victor
 */
public class UsuarioFacade {
 
    private static IUsuarioFacade facade;
    
    public static IUsuarioFacade getInstance(){
        
        if(facade == null){
            facade = new UsuarioFacadeImp();
        }
        
        return facade;
    }
    
}
