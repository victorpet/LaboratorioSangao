/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.dao.HibernateDAO;
import br.com.self.sangao.entity.Paciente;
import br.com.self.sangao.paciente.bo.PacienteBO;
import br.com.self.sangao.paciente.facade.PacienteFacade;
import br.com.self.sangao.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Victor
 */
@WebServlet(name = "PacientesServlet", urlPatterns = {"/PacientesServlet"})
public class PacientesServlet extends HttpServlet {
    
    private static final Logger log = Logger.getLogger(PacientesServlet.class);

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
        PrintWriter out = response.getWriter();

        try {
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            Date dt_nascimento = Utils.FORMATADOR_DATA.parse(request.getParameter("dtnasc"));
            String telefone = request.getParameter("telefone");
//            
//            PacienteBO bo = new PacienteBO();
//            Paciente p = bo.getPaciente(150);
//            System.out.print(p.getNome());

            Paciente p = new Paciente();
            p.setNome(nome);
            p.setEndereco(endereco);
            p.setDtNascimento(dt_nascimento);
            p.setTelefone(telefone);

            boolean ok = PacienteFacade.getInstance().inserirRegistro(p);
            
            request.setAttribute("resultado", ok);
            
        } catch (ParseException e) {
            log.error(e);
        } finally {
            out.close();
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
