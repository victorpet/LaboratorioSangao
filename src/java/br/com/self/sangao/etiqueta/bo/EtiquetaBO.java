/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.self.sangao.etiqueta.bo;

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

//        try {
//            //logo nastek
//            String pathLogoNastek = "/br/com/nastek/self/sysdata/client/resources/reports/logo_nastek.jpg";
//            InputStream urlNastek = this.getClass().getResourceAsStream(pathLogoNastek);
//            logo_nastek = ImageIO.read(urlNastek);
//            String pathLogoEmpresa = TMain.main.getPathForLogoByCompany();
//            InputStream urlEmpresa = this.getClass().getResourceAsStream(pathLogoEmpresa);
//            logo_empresa = ImageIO.read(urlEmpresa);
//        } catch (IOException e) {
//            NastekLog.getMainLog().log(Level.WARNING, "Erro acessando imagens Fatura.", e);
//        }
//        DateFormat df_numero_fatura = new SimpleDateFormat("yyyyMMdd");
//        String numero_fatura = df_numero_fatura.format(new Date());
//        Date periodo = new Date(String.valueOf(ano + "/" + mes + "/" + 01));
//        Calendar dataInicial = GregorianCalendar.getInstance();
//        dataInicial.setTime(periodo);
//        Date datai = dataInicial.getTime();
//        Calendar dataFinal = GregorianCalendar.getInstance();
//        dataFinal.setTime(periodo);
//        dataFinal.set(Calendar.DAY_OF_MONTH, dataFinal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        Date dataf = dataFinal.getTime();

        HashMap map = new HashMap();
//        map.put("numero_fatura", numero_fatura);
//        map.put("datai", datai);
//        map.put("dataf", dataf);
//        map.put("REPORT_LOCALE", new Locale("pt", "BR"));
//        map.put("logo_nastek", logo_nastek);
//        map.put("logo_empresa", logo_empresa);
//        String pathReport = "/br/com/nastek/self/sysdata/client/resources/reports/FaturaServicos.jasper";
//
//        InputStream urlReport = this.getClass().getResourceAsStream(pathReport);
        
        String dir = System.getProperty("user.dir");
        
        String path = "/home/prado/Compartilhada/Etiqueta.jasper";
        
        try {
//            bytes = JasperFillManager.fillReport(path, map, source);
//            JasperViewer viewer = new JasperViewer(relatorio, false);
            bytes = JasperRunManager.runReportToPdf(path, map, source); 
//            JRHtmlExporter e = new JRHtmlExporter();
//            e.setParameter(JRExporterParameter.JASPER_PRINT, relatorio);
//            e.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
//            System.out.println(bytes);
//            viewer.setVisible(true);
        } catch (JRException e) {
            log.error(e);
        }
        return bytes;
    }
}
