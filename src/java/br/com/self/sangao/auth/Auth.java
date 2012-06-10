/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.auth;

/**
 *
 * @author Victor
 */
public class Auth {

    private static Auth auth;

    public static Auth getInstance() {

        if (auth == null) {
            auth = new Auth();
        }

        return auth;
    }
}
