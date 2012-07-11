package br.com.self.sangao.medico.facade;

public class MedicoFacade {

	private static IMedicoFacade facade;
	
	public static IMedicoFacade getInstance(){
		
		if(facade == null){
			facade = new MedicoFacadeImp();
		}
		
		return facade;
	}
	
}
