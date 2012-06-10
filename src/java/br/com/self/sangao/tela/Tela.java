/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.tela;

import br.com.self.sangao.etiqueta.bo.EtiquetaBO;
import br.com.self.sangao.etiqueta.bo.EtiquetaJRDataSourceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prado
 */
public class Tela extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("application/pdf");
//        PrintWriter out = response.getWriter();
        ServletOutputStream ouputStream = null;
        EtiquetaBO bo = new EtiquetaBO();
        byte[] bytes = bo.geraEtiqueta(EtiquetaJRDataSourceFactory.createDatasource());
//        response.sendRedirect("/home/prado/NetBeansProjects/SangaoEtiqueta/web/WEB-INF/rel/reportname.html");
//        out.print(bytes);
        try {
//            String fileName = "teste.pdf";
//            JRHtmlExporter exporter = new JRHtmlExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, bytes);
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
//            exporter.exportReport();

            if (bytes != null && bytes.length > 0) {
                response.setContentType("application/pdf");
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

                response.setContentLength(bytes.length);
                ouputStream = response.getOutputStream();
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
            }


            /*
             * TODO output your page here. You may use following sample code.
             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Tela</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Tela at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
//            out.close();
            ouputStream.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * // * Handles the HTTP //
     * <code>POST</code> method. // * //
     *
     * @param request servlet request //
     * @param response servlet response //
     * @throws ServletException if a servlet-specific error occurs //
     * @throws IOException if an I/O error occurs //
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
}
