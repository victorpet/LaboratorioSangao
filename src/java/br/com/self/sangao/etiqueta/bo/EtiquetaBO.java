/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.etiqueta.bo;

import java.io.InputStream;
import java.util.*;
import net.sf.jasperreports.engine.*;
import org.apache.log4j.Logger;

/**
 *
 * @author treinamento
 */
public class EtiquetaBO {

    private final Logger log = Logger.getLogger(EtiquetaBO.class);

    public byte[] geraEtiqueta(JRDataSource source) {

        byte[] bytes = null;

        HashMap map = new HashMap();
        InputStream urlReport = getClass().getResourceAsStream("Etiqueta.jasper");

        try {
            bytes = JasperRunManager.runReportToPdf(urlReport, map, source);
        } catch (JRException e) {
            log.error(e);
        }
        return bytes;
    }
}
