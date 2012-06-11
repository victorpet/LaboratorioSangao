package br.com.self.sangao.medico.facade;

import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.medico.bo.MedicoBO;
import java.util.List;


public class MedicoFacadeImp implements IMedicoFacade {
    
    private static MedicoBO bo = new MedicoBO();

    @Override
    public List<Object> select() {
        return bo.select();
    }

    @Override
    public void adicionar(Medico m) {
       bo.adicionar(m);
    }

    @Override
    public void remover(Medico m) {
        bo.remover(m);
    }

    @Override
    public void atualizar(Medico m) {
        bo.atualizar(m);
    }

    @Override
    public List<Medico> getAllMedicos() {
        return bo.getAllMedicos();
    }
    
    @Override
    public void remover(Integer id) {
        bo.remover(id);
    }

    @Override
    public Medico select(Integer id) {
        return bo.select(id);
    }
}
