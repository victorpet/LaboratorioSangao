/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.servlets;

import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author prado
 */
public class LoginCliente extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LoginCliente</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginCliente at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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
//        processRequest(request, response);
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
//        processRequest(request, response);
        PrintWriter out = response.getWriter();
        

        String usuario = request.getParameter("usuarioCliente");
        String senha = request.getParameter("senhaCliente");

        Usuario valid = UsuarioFacade.getInstance().getUsuario(usuario, senha);
        HttpSession sessao = request.getSession();

//        JOptionPane.showMessageDialog(null, "login ok, retornou " + valid);

        if (valid != null) {

            sessao.setAttribute("logado", "true");
            sessao.setAttribute("nome", valid.getUsername());
            sessao.setAttribute("id", valid.getId());

//            response.getWriter().print("login ok");
//            out.print(false);

//            response.sendRedirect(Utils.ABSOLUTEPATH + "index.jsp");
        } else {
            sessao.setAttribute("logado", "false");
//            out.print("Usuario e senha invalidas!");
        }
        
//        request.setAttribute("resultado", "ok");
//        response.sendRedirect("/LaboratorioSangao/login.jsp");
//        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher(Utils.ABSOLUTEPATH + "index.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect(Utils.ABSOLUTEPATH + "index.jsp");
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
