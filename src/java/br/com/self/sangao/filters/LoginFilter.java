package br.com.self.sangao.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filter) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession sessao = req.getSession();
        boolean logado;

        if (sessao.getAttribute("logado") == null) {
            logado = false;
        } else {
            if (sessao.getAttribute("logado").equals("true")) {
                logado = true;
            } else {
                logado = false;
            }
        }

        if (!logado) {
            res.sendRedirect("/LaboratorioSangao/login.html");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
