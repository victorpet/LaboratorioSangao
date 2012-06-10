/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.usuario.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import br.com.self.sangao.entity.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class UsuarioDAO extends HibernateDAO {

    private static UsuarioDAO dao;
    public static UsuarioDAO getInstance() {

        if (dao == null) {
            dao = new UsuarioDAO();
        }
        return dao;
    }

    @Override
    public List<Object> select() {

        List<Object> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Usuario.findAll");
            list = query.getResultList();

        } catch (Exception e) {
           e.printStackTrace();
        }

        return list;
    }

    public boolean isValid(Usuario usuario) {

        boolean valid = false;
        List<Object> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Usuario.auth");
            query.setParameter("username", usuario.getUsername());
            query.setParameter("senha", usuario.getSenha());
            list = query.getResultList();

            if (list.size() > 0) {
                valid = true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao obter lista de Usuários");
        }

        return valid;
    }
}
