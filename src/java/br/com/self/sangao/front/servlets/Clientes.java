/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.servlets;

import br.com.self.sangao.entity.Paciente;
import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.paciente.facade.PacienteFacade;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prado
 */
public class Clientes extends HttpServlet {

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
//            out.println("<title>Servlet Clientes</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Clientes at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

        String nome = request.getParameter("nome");
        String sexo = request.getParameter("sexo");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone1 = request.getParameter("telefone");
        String email = request.getParameter("email");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        System.out.println(nome);
        System.out.println(sexo);
        System.out.println(endereco);
        System.out.println(bairro);
        System.out.println(cidade);
        System.out.println(estado);
        System.out.println(telefone1);
        System.out.println(email);
        System.out.println(usuario);
        System.out.println(senha);
        
        Paciente p = new Paciente();
        p.setNome(nome);
        p.setSexo(sexo);
        p.setEndereco(endereco);
        p.setBairro(bairro);
        p.setCidade(cidade);
        p.setEstado(estado);
        p.setTelefone(telefone1);
        p.setEmail(email);
        
        PacienteFacade.getInstance().inserirAtualizarRegistro(p);
        
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setUsername(usuario);
        user.setSenha(senha);
        
        UsuarioFacade.getInstance().adicionar(user);

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
