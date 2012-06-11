/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.servlets;

import br.com.self.sangao.entity.Paciente;
import br.com.self.sangao.paciente.facade.PacienteFacade;
import br.com.self.sangao.usuario.facade.UsuarioFacade;
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

/**
 *
 * @author Victor
 */
@WebServlet(name = "Pacientes", urlPatterns = {"/Pacientes"})
public class Pacientes extends HttpServlet {

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
        PrintWriter out = response.getWriter();

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
            request.setAttribute("list", PacienteFacade.getInstance().getAllPacientes());
            getServletContext().getRequestDispatcher("/pacientes/pacientes.jsp").forward(request, response);
        } else if (request.getParameter("acao").equalsIgnoreCase("editar")) {
            request.setAttribute("paciente", PacienteFacade.getInstance().getPaciente(Integer.parseInt(request.getParameter("id"))));
            getServletContext().getRequestDispatcher("/pacientes/pacientes_inserir.jsp").forward(request, response);
        } //else if (request.getParameter("acao").equalsIgnoreCase("inserir")) {
//            getServletContext().getRequestDispatcher("/usuarios/usuarios_inserir.jsp").forward(request, response);
//        }

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
        boolean ok = false;

        try {

            if (request.getParameter("acao").equalsIgnoreCase("salvar")) {

                String id = request.getParameter("id");
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                Date dt_nascimento = Utils.FORMATADOR_DATA.parse(request.getParameter("dtnasc"));
                String telefone = request.getParameter("telefone");

                Paciente p = new Paciente();
                if (!id.equals("")) {
                    p.setId(Integer.valueOf(id));
                }
                p.setNome(nome);
                p.setEndereco(endereco);
                p.setDtNascimento(dt_nascimento);
                p.setTelefone(telefone);

                ok = PacienteFacade.getInstance().inserirAtualizarRegistro(p);

                if (ok) {
                    request.setAttribute("mensagem", "Paciente salvo com sucesso!");
                } else {
                    request.setAttribute("mensagem", "Erro ao salvar paciente. Entre em contato com Victor Pet");
                }
                getServletContext().getRequestDispatcher("/pacientes/pacientes.jsp").forward(request, response);
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
