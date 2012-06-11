package br.com.self.sangao.medico.dao;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.dao.PersistenceManager;
import br.com.self.sangao.entity.Medico;
import java.util.List;
import javax.persistence.Query;

public class MedicoDAO extends HibernateDAO {

    private static MedicoDAO dao;

    public static MedicoDAO getInstance() {

        if (dao == null) {
            dao = new MedicoDAO();
        }
        return dao;
    }

    @Override
    public List<Object> select() {

        List<Object> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createQuery("SELECT * FROM medicos");
            list = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erro ao obter lista de Medicos");
        }
        return list;
    }

    public List<Medico> getAllMedicos() {

        List<Medico> list = null;

        try {
            Query query = PersistenceManager.getInstance().getConnection().createNamedQuery("Medico.findAll");
            list = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erro ao obter lista de Medicos");
        }
        return list;
    }
}
