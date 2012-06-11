/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.convenio.facade.ConvenioFacade;
import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.medico.facade.MedicoFacade;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class Medicos extends HttpServlet {

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
            request.setAttribute("list", MedicoFacade.getInstance().select());
            getServletContext().getRequestDispatcher("/medicos/medicos.jsp").forward(request, response);
        } else if (request.getParameter("acao").equals("inserir")) {
            getServletContext().getRequestDispatcher("/medicos/medicos_inserir.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("editar")) {
            request.setAttribute("medico", MedicoFacade.getInstance().select(Integer.parseInt(request.getParameter("id"))));
            getServletContext().getRequestDispatcher("/medicos/medicos_inserir.jsp").forward(request, response);
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
            
                Medico m = new Medico();
                m.setNome(request.getParameter("nome"));
                m.setCrm(request.getParameter("crm"));
                
                MedicoFacade.getInstance().adicionar(m);
            } else{
           
                Medico m = MedicoFacade.getInstance().select(Integer.parseInt(request.getParameter("id")));
                m.setNome(request.getParameter("nome"));
                m.setCrm(request.getParameter("crm"));
                
                MedicoFacade.getInstance().atualizar(m);
                
            }
            
            response.sendRedirect(Utils.ABSOLUTEPATH + "Medicos?acao=list");
        } else if (request.getParameter("acao").equalsIgnoreCase("excluir")) {

            String[] ids = request.getParameterValues("ids[]");

            for (int i = 0; i < ids.length; i++) {
                
               MedicoFacade.getInstance().remover(Integer.parseInt(ids[i]));
                
            }

            response.sendRedirect(Utils.ABSOLUTEPATH + "Medicos?acao=list");
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
