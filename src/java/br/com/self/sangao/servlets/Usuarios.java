/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

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
            
            request.setAttribute("list", UsuarioFacade.getInstance().select());
            getServletContext().getRequestDispatcher("/usuarios/usuarios.jsp").forward(request, response);   
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
        
        if(request.getParameter("acao").equals("inserir")){
            
            Usuario u = new Usuario();
            u.setNome(request.getParameter("nome"));
            u.setUsername(request.getParameter("username"));
            u.setSenha(request.getParameter("senha"));
            
            UsuarioFacade.getInstance().adicionar(u);
            
            response.sendRedirect(Utils.ABSOLUTEPATH+"UsuariosServlet?acao=list");
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
