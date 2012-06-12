package br.com.self.sangao.servlets;

import br.com.self.sangao.entity.Usuario;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
import br.com.self.sangao.utils.Utils;
import bsh.util.Util;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UsuarioServlets
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        if(request.getParameter("login").equalsIgnoreCase("entrar")){
            
            Usuario u = new Usuario();
            u.setUsername(request.getParameter("username"));
            u.setSenha(request.getParameter("password"));
            
            boolean valid = UsuarioFacade.getInstance().isValid(u);
            
            if(valid){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("logado", "true");
                sessao.setAttribute("nome", u.getUsername());
                
                response.sendRedirect(Utils.ABSOLUTEPATH+"index.jsp");
            } else{
                response.sendRedirect("/LaboratorioSangao/login.jsp");
            }
            
        }
    
    }
}
