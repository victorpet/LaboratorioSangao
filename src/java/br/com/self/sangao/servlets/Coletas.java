/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.coleta.facade.ColetaFacade;
import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.entity.Paciente;
import br.com.self.sangao.entity.TipoExame;
import br.com.self.sangao.etiqueta.bo.EtiquetaBO;
import br.com.self.sangao.etiqueta.bo.EtiquetaJRDataSourceFactory;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prado
 */
public class Coletas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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

        if (request.getParameter("acao").equalsIgnoreCase("list")) {
            request.setAttribute("list", ColetaFacade.getInstance().getAllColetas());
            getServletContext().getRequestDispatcher("/sgc/coletas/coletas.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("editar")) {
            request.setAttribute("coleta", ColetaFacade.getInstance().getColeta(Integer.parseInt(request.getParameter("id"))));
            getServletContext().getRequestDispatcher("/sgc/coletas/coletas_inserir.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("imprimir")) {
            
            Integer id = Integer.parseInt(request.getParameter("id"));

            ServletOutputStream ouputStream = null;
            EtiquetaBO bo = new EtiquetaBO();
            byte[] bytes = bo.geraEtiqueta(EtiquetaJRDataSourceFactory.createDatasource(id));
            try {
                if (bytes != null && bytes.length > 0) {
                    
                    response.setContentType("application/pdf");
                    response.setContentLength(bytes.length);
                    ouputStream = response.getOutputStream();
                    ouputStream.write(bytes, 0, bytes.length);
                    ouputStream.flush();
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                ouputStream.close();
            }
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        try {

            if (request.getParameter("acao").equalsIgnoreCase("salvar")) {

                String id = request.getParameter("id");
                String idPaciente = request.getParameter("nome");
                Date dtColeta = Utils.FORMATADOR_DATA.parse(request.getParameter("dtColeta"));
                Date dtEntrega = Utils.FORMATADOR_DATA.parse(request.getParameter("dtEntrega"));
                String idMedico = request.getParameter("medico");
                String tipoExame = request.getParameter("tipoExame");

                Coleta c = new Coleta();
                if (!id.equals("")) {
                    c.setId(Integer.valueOf(id));
                }
                c.setIdPaciente(new Paciente(Integer.valueOf(idPaciente)));
                c.setDtColeta(dtColeta);
                c.setDtEntrega(dtEntrega);
                c.setIdMedico(new Medico(Integer.valueOf(idMedico)));
                c.setTipoExame(new TipoExame(Integer.valueOf(tipoExame)));

                ColetaFacade.getInstance().inserirAtualizar(c);

                response.sendRedirect(Utils.ABSOLUTESGC + "Coletas?acao=list");

            } else if (request.getParameter("acao").equalsIgnoreCase("excluir")) {

                String[] ids = request.getParameterValues("ids[]");

                for (int i = 0; i < ids.length; i++) {
                    ColetaFacade.getInstance().remover(Integer.valueOf(ids[i]));
                }

                response.sendRedirect(Utils.ABSOLUTESGC + "Coletas?acao=list");
            }

        } catch (ParseException e) {
        } finally {
//            out.close();
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
