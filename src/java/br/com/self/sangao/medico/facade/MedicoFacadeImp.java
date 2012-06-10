package br.com.self.sangao.medico.facade;

import br.com.self.sangao.entity.Medico;
import java.util.List;

import br.com.self.sangao.medico.dao.MedicoDAO;

public class MedicoFacadeImp implements IMedicoFacade {

    @Override
    public List<Object> select() {
        return MedicoDAO.getInstance().select();
    }

    @Override
    public void adicionar(Medico m) {
       MedicoDAO.getInstance().adicionar(m);
    }

    @Override
    public void remover(Medico m) {
        MedicoDAO.getInstance().remover(m);
    }

    @Override
    public void atualizar(Medico m) {
        MedicoDAO.getInstance().atualizar(m);
    }

}
