/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.etiqueta.bo;

import br.com.self.sangao.coleta.facade.ColetaFacade;
import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.etiqueta.entity.Etiqueta;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author alexandre.prado
 */
public class EtiquetaJRDataSourceFactory {

    private final Logger log = Logger.getLogger(EtiquetaJRDataSourceFactory.class);
    private static JRDataSource data;

    public static JRDataSource createDatasource(Integer idColeta) {

        try {
            Coleta c = ColetaFacade.getInstance().select(idColeta);

            List<Etiqueta> list = new ArrayList<Etiqueta>();

            Etiqueta etiqueta = new Etiqueta();
            etiqueta.setDataColeta(c.getDtColeta());
            etiqueta.setDataEntrega(c.getDtEntrega());
            etiqueta.setMedico(c.getIdMedico().getNome());
            etiqueta.setNomePaciente(c.getIdPaciente().getNome());
            etiqueta.setTipoExame(c.getTipoExame().getDescricao());

            list.add(etiqueta);
            data = new EtiquetaJRDataSource(list);

        } catch (Exception e) {
            System.out.println(e);
//            throw  new Exception("Erro ao buscar dados do cliente.", e,);
        }
        return data;
    }
}
