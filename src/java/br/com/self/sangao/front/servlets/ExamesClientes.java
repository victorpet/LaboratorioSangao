/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.servlets;

import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.Medico;
import br.com.self.sangao.entity.Paciente;
import br.com.self.sangao.front.entity.Exames;
import br.com.self.sangao.paciente.facade.PacienteFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prado
 */
public class ExamesClientes extends HttpServlet {

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
//            out.println("<title>Servlet ExamesClientes</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ExamesClientes at " + request.getContextPath() + "</h1>");
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
        
        String idPaciente = request.getParameter("idPaciente");
        String crmMedico = request.getParameter("crmMedico");
        String data = request.getParameter("data");
        
        String[] exames = request.getParameterValues("array");
        
        Paciente p = new Paciente(Integer.parseInt(idPaciente));
        Medico m = new Medico(crmMedico);
        Coleta c = new Coleta();
        c.setIdPaciente(p);
        c.setIdMedico(m);
        c.setTipoExame(null);
        
       
//        Paciente p = new Paciente();
//        p.setNome(nome);
//        p.setSexo(sexo);
//        p.setEmail("");
//        p.setEndereco(endereco);
//        p.setBairro(bairro);
//        p.setTelefone(telefone1);
//        p.setTelefone2(telefone2);
        
//        for (int i = 0; i <= exames.length; i++) {
//            exam.getExames().add(exames[i]);
//        }
        PacienteFacade.getInstance().inserirAtualizarRegistro(p);
        
        
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
