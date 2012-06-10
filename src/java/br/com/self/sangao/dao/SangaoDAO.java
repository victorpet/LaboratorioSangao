/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.dao;

import java.util.List;

/**
 *
 * @author prado
 */
public class SangaoDAO extends HibernateDAO {

    private static SangaoDAO instance;

    public static SangaoDAO getDAO() {
        if (instance == null) {
            instance = new SangaoDAO();
        }
        return instance;
    }

    @Override
    public List<Object> select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
