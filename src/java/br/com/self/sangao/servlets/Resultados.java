/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.coleta.facade.ColetaFacade;
import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.entity.Resultado;
import br.com.self.sangao.medico.facade.MedicoFacade;
import br.com.self.sangao.resultado.facade.ResultadoFacade;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "Resultados", urlPatterns = {"/sgc/Resultados"})
public class Resultados extends HttpServlet {


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
     
        if (request.getParameter("acao").equals("list")) {
            request.setAttribute("list", ResultadoFacade.getInstance().select());
            getServletContext().getRequestDispatcher("/sgc/resultados/resultados.jsp").forward(request, response);
        } else if (request.getParameter("acao").equals("inserir")) {
            getServletContext().getRequestDispatcher("/sgc/resultados/resultados_inserir.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("editar")) {
            request.setAttribute("resultado", ResultadoFacade.getInstance().select(Integer.parseInt(request.getParameter("id"))));
            getServletContext().getRequestDispatcher("/sgc/resultados/resultados_inserir.jsp").forward(request, response);
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
        
        if (request.getParameter("acao").equalsIgnoreCase("salvar")) {

            String id = request.getParameter("id");
            
            if(id.equals("")){
            
                Resultado r = new Resultado();
                r.setDescricao(request.getParameter("descricao"));
                r.setIdExame(ColetaFacade.getInstance().select(Integer.parseInt(request.getParameter("coleta"))));
                
                ResultadoFacade.getInstance().atualizar(r);
            } else{
           
                Resultado r = ResultadoFacade.getInstance().select(Integer.parseInt(id));
                r.setDescricao(request.getParameter("descricao"));
                r.setIdExame(ColetaFacade.getInstance().select(Integer.parseInt(request.getParameter("coleta"))));
                
                ResultadoFacade.getInstance().atualizar(r);
                
            }
            
            response.sendRedirect(Utils.ABSOLUTESGC + "Resultados?acao=list");
        } else if (request.getParameter("acao").equalsIgnoreCase("excluir")) {

            String[] ids = request.getParameterValues("ids[]");

            for (int i = 0; i < ids.length; i++) {
                
               ResultadoFacade.getInstance().remover(Integer.parseInt(ids[i]));
                
            }

            response.sendRedirect(Utils.ABSOLUTESGC + "Resultados?acao=list");
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
