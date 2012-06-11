package br.com.self.sangao.medico.facade;

import br.com.self.sangao.entity.Medico;
import java.util.List;

public interface IMedicoFacade {

    public List<Object> select();

    public void adicionar(Medico m);

    public void remover(Medico m);

    public void remover(Integer id);

    public Medico select(Integer id);

    public void atualizar(Medico m);
}
