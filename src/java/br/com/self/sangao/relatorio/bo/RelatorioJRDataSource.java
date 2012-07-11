/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.relatorio.bo;

import br.com.self.sangao.relatorio.entity.Relatorio;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import org.apache.log4j.Logger;

/**
 *
 * @author alexandre.prado
 */
public class RelatorioJRDataSource implements JRDataSource{
    private final Logger log = Logger.getLogger(RelatorioJRDataSource.class);
    private Iterator<Relatorio> iterator;
    private Relatorio cursor;
    
    public RelatorioJRDataSource(List <Relatorio> relatorio){
        super();
        iterator = relatorio.iterator();
    }

    @Override
    public boolean next() throws JRException {
        boolean retorno = iterator.hasNext();
        if(retorno){
            cursor = iterator.next();
        }
        return retorno;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Relatorio relatorio = cursor;
        if (field.getName().equals("nomePaciente")) {
                return relatorio.getPaciente();
        }
        if (field.getName().equals("tipo")) {
                return relatorio.getTipo();
        }
        if (field.getName().equals("medico")) {
                return relatorio.getMedico();
        }
        if (field.getName().equals("dtEntrega")) {
                return relatorio.getDtEntrega();
        }
        if (field.getName().equals("dtColeta")) {
                return relatorio.getDtColeta();
        }
        if (field.getName().equals("id")) {
                return relatorio.getId();
        }
        return null;
    }
}
