/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.etiqueta.bo;

import br.com.self.sangao.etiqueta.entity.Etiqueta;
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
public class EtiquetaJRDataSource implements JRDataSource{
    private final Logger log = Logger.getLogger(EtiquetaJRDataSource.class);
    private Iterator<Etiqueta> iterator;
    private Etiqueta cursor;
    
    public EtiquetaJRDataSource(List <Etiqueta> etiqueta){
        super();
        iterator = etiqueta.iterator();
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
        Etiqueta etiqueta = cursor;
        if (field.getName().equals("nomePaciente")) {
                return etiqueta.getNomePaciente();
        }
        if (field.getName().equals("tipoExame")) {
                return etiqueta.getTipoExame();
        }
        if (field.getName().equals("nomeMedico")) {
                return etiqueta.getMedico();
        }
        if (field.getName().equals("dataEntrega")) {
                return etiqueta.getDataEntrega();
        }
        if (field.getName().equals("dataColeta")) {
                return etiqueta.getDataColeta();
        }
        return null;
    }
}
