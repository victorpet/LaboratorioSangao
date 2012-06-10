/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.etiqueta.bo;

import br.com.self.sangao.etiqueta.entity.Etiqueta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author alexandre.prado
 */
public class EtiquetaJRDataSourceFactory {

    private static JRDataSource data;
    private static ResultSet resultset;
    private static PreparedStatement pstmt;
    private static String query;
    private static Statement stmt;
    private static int mesLocal;
    private static int anoLocal;
    
    private final Logger log = Logger.getLogger(EtiquetaJRDataSourceFactory.class);

    public static Connection getConnection() {
        return null;//TMain.main.getDBConnection();
    }

    public static JRDataSource createDatasource() {

//        try {
//            query = "select * from empresa";
//            stmt = getConnection().createStatement();
//            resultset = stmt.executeQuery(query);
            
            List<Etiqueta> list = new ArrayList<Etiqueta>();

//            if (resultset.next()) {
                
                Etiqueta etiqueta = new Etiqueta();
                etiqueta.setDataColeta(new Date());
                etiqueta.setDataEntrega(new Date());
                etiqueta.setMedico("Dr. Marcio");
                etiqueta.setNomePaciente("Alexandre Ducatti");
                etiqueta.setTipoExame("Urina");
//                Empresa obj = new Empresa();
//                TotalTrafego total = calculaBytes(mes, ano);
//                obj.setNome(resultset.getString("nome"));
//                obj.setCnpj(resultset.getString("cnpj"));
//                obj.setIestadual(resultset.getString("iestadual"));
//                obj.setEndereco(resultset.getString("endereco"));
//                obj.setNumeroEndereco(resultset.getInt("numero_endereco"));
//                obj.setCep(resultset.getString("cep"));
//                obj.setAtendente1(resultset.getString("atendente1"));
//                obj.setTel1(resultset.getString("tel1"));
//                obj.setEmail1(resultset.getString("email1"));
//                obj.setAtendente2(resultset.getString("atendente2"));
//                obj.setTel2(resultset.getString("tel2"));
//                obj.setEmail2(resultset.getString("email2"));
//                obj.setPrecofranquiagprs(resultset.getDouble("precofranquiagprs"));
//                obj.setPrecofranquiasat(resultset.getDouble("precofranquiasat"));
//                obj.setPrecoexcedentegprs(resultset.getDouble("precoexcedentegprs"));
//                obj.setPrecoexcedentesat(resultset.getDouble("precoexcedentesat"));
//                obj.setCobrarexcedentegprs(resultset.getString("precofranquiagprs"));
//                obj.setFranquiagprs(resultset.getDouble("franquiagprs"));
//                obj.setFranquiasat(resultset.getDouble("franquiasat"));
//                obj.setCobrarexcedentegprs(resultset.getString("cobrarexcedentegprs"));
//                obj.setTotalGPRS(total.getTotalGPRS());
//                obj.setTotalSAT(total.getTotalSAT());
//                obj.setTotalViaturaGPRS(gprsCount());
//                obj.setTotalViaturaSAT(satCount());
                list.add(etiqueta);
                data = new EtiquetaJRDataSource(list);
//            }
//        } catch (SQLException e) {
//            log.error("Erro ao buscar dados do cliente.", e);
//        }
        return data;
    }

    public static Timestamp getMonthLastDayAsSqlDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(anoLocal, mesLocal - 1, 1);
        int ultimoDiaMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(anoLocal, mesLocal - 1, ultimoDiaMes, 23, 59, 59);
        return new java.sql.Timestamp(cal.getTimeInMillis());

    }

    public static Timestamp getMonthFirstDayAsSqlDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(anoLocal, mesLocal - 1, 1, 00, 00, 00);
        return new java.sql.Timestamp(cal.getTimeInMillis());
    }
}
