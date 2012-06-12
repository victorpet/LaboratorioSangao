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
@WebServlet(name = "Usuarios", urlPatterns = {"/site/Usuarios"})
public class Usuarios extends HttpServlet {

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

        if (request.getParameter("acao").equalsIgnoreCase("list")) {
            request.setAttribute("list", UsuarioFacade.getInstance().select());
            getServletContext().getRequestDispatcher("/usuarios/usuarios.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("editar")) {
            request.setAttribute("usuario", UsuarioFacade.getInstance().select(Integer.parseInt(request.getParameter("id"))));
            getServletContext().getRequestDispatcher("/usuarios/usuarios_inserir.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("inserir")) {
            getServletContext().getRequestDispatcher("/usuarios/usuarios_inserir.jsp").forward(request, response);
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
            
            Usuario u = new Usuario();
            u.setNome(request.getParameter("nome"));
            u.setUsername(request.getParameter("username"));
            u.setSenha(request.getParameter("senha"));

            UsuarioFacade.getInstance().adicionar(u);
            
            } else{
                
                Usuario u = new Usuario(Integer.parseInt(id));
                u.setNome(request.getParameter("nome"));
                u.setUsername(request.getParameter("username"));
                u.setSenha(request.getParameter("senha"));
                
                UsuarioFacade.getInstance().atualizar(u);
            }
            
            response.sendRedirect(Utils.ABSOLUTEPATH + "Usuarios?acao=list");
        } else if (request.getParameter("acao").equalsIgnoreCase("excluir")) {

            String[] ids = request.getParameterValues("ids[]");

            for (int i = 0; i < ids.length; i++) {
                
               UsuarioFacade.getInstance().remover(ids[i]);
                
            }

            response.sendRedirect(Utils.ABSOLUTEPATH + "Usuarios?acao=list");
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
