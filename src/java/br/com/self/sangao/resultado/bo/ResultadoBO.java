/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.resultado.bo;

import br.com.self.sangao.entity.Resultado;
import br.com.self.sangao.resultado.dao.ResultadosDAO;
import br.com.self.sangao.usuario.bo.UsuarioBO;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author victor
 */
public class ResultadoBO {
    
    private static final Logger log = Logger.getLogger(UsuarioBO.class);
    
    ResultadosDAO dao = ResultadosDAO.getInstance();
    
    public void adicionar(Resultado m) {
        dao.adicionar(m);
    }

    public void remover(Resultado m) {
        dao.remover(m);
    }
    
    public void remover(Object ob){
        dao.remover(ob, Resultado.class);
    }

    public void atualizar(Object ob){
        dao.atualizar(ob);
    }

    public Resultado select(Integer id){
        return (Resultado) dao.select(id, new Resultado());
    }
    
    public List<Object> select() {
        return dao.select();
    }
    
}
