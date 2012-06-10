package br.com.self.sangao.medico.facade;

import java.util.List;

import br.com.self.sangao.medico.dao.MedicoDAO;

public class MedicoFacadeImp implements IMedicoFacade{

	@Override
	public List<Object> select() {
		return MedicoDAO.getInstance().select();
	}

}
