/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.relatorio.bo;

import br.com.self.sangao.coleta.facade.ColetaFacade;
import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.relatorio.entity.Relatorio;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author alexandre.prado
 */
public class RelatorioJRDataSourceFactory {

    private final Logger log = Logger.getLogger(RelatorioJRDataSourceFactory.class);
    private static JRDataSource data;

    public static JRDataSource createDatasource() {

        try {
            List<Coleta> c = ColetaFacade.getInstance().getAllColetas();

            List<Relatorio> list = new ArrayList<Relatorio>();

            for (Coleta coleta : c) {

                Relatorio relatorio = new Relatorio();
                relatorio.setId(String.valueOf(coleta.getId()));
                relatorio.setDtColeta(coleta.getDtColeta());
                relatorio.setDtEntrega(coleta.getDtEntrega());
                relatorio.setMedico(coleta.getIdMedico().getNome());
                relatorio.setPaciente(coleta.getIdPaciente().getNome());
                relatorio.setTipo(coleta.getTipoExame().getDescricao());

                list.add(relatorio);
            }

            data = new RelatorioJRDataSource(list);


        } catch (Exception e) {
            System.out.println(e);
//            throw  new Exception("Erro ao buscar dados do cliente.", e,);
        }
        return data;
    }
}
