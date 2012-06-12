/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.relatorio.bo;

import java.io.InputStream;
import java.util.*;
import net.sf.jasperreports.engine.*;
import org.apache.log4j.Logger;

/**
 *
 * @author treinamento
 */
public class RelatorioBO {

    private final Logger log = Logger.getLogger(RelatorioBO.class);

    public byte[] geraRelatorio(JRDataSource source) {

        byte[] bytes = null;

        HashMap map = new HashMap();
        InputStream urlReport = getClass().getResourceAsStream("Relatorio.jasper");

        try {
            bytes = JasperRunManager.runReportToPdf(urlReport, map, source);
        } catch (JRException e) {
            log.error(e);
        }
        return bytes;
    }
}
