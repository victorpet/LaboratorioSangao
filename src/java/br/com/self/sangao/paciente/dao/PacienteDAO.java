/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.paciente.dao;

import br.com.self.sangao.dao.HibernateDAO;
import java.util.List;

/**
 *
 * @author prado
 */
public class PacienteDAO extends HibernateDAO {

    private static PacienteDAO instance;

    public static PacienteDAO getDAO() {
        if (instance == null) {
            instance = new PacienteDAO();
        }
        return instance;
    }

    @Override
    public List<Object> select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
