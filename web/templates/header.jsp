<%-- 
    Document   : header
    Created on : Jun 10, 2012, 11:12:13 AM
    Author     : Victor
--%>

<%@page import="br.com.self.sangao.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/reset.css">
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/960.css">
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/padrao.css">
    </head>
    <body>

        <!-- TOPO -->
        <div class="container_12 topo">

            <div class="grid_12">

                <div class="grid_4 infosSGC">
                    Laboratório Sangão<br>
                </div>

                <div class="grid_4 omega infosUsuario">
                    Olá, <!-- Colocar nome usuario!-->, seja bem vindo 
                    <br>
                    <a href="">Sair do Sistema </a>

                </div>

                <div class="clear"></div>	

            </div>

            <div class="clear"></div>

        </div>
        <!-- //TOPO -->

        <!-- MENU -->
        <div id="menuContainer">

            <div class="container_12">
                <div class="menu">
                    <ul>
                        <li ><a href="javascript:void(0);">Inicio</a></li>
                        <li ><a href="<% out.print(Utils.ABSOLUTEPATH);%>pacientes/pacientes.jsp">Pacientes</a></li>
                        <li ><a href="<% out.print(Utils.ABSOLUTEPATH);%>medicos/medicos.jsp">Médicos</a></li>
                        <li ><a href="<% out.print(Utils.ABSOLUTEPATH);%>resultados/resultados.jsp">Resultados</a></li>
                        <li ><a href="<% out.print(Utils.ABSOLUTEPATH);%>exames/exames.jsp">Exames</a></li>
                        <li ><a href="javascript:void(0);">Convênios</a></li>
                        <li ><a href="UsuariosServlet?acao=list">Usuários</a></li>
                    </ul>
                </div>
            </div>

        </div>
        <!-- //MENU -->

        <!-- CONTEUDO -->
        <div class="conteudoContainer">

            <div id="conteudo">

                <div class="container_12">
                    
                    <div class="grid_12">