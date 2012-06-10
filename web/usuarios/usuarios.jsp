<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    USUÁRIOS - <a href="<% out.print(Utils.ABSOLUTEPATH);%>usuarios/usuarios_inserir.jsp">Inserir novo Usuário</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>UsuariosServlet" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Nome do Usuário</td>

            <td class="principal">Username</td>

            <td class="principal">Senha</td>

        </tr>
    </thead>
    <!-- FIM HEADER TABELA -->

    <tbody>

        <!--Linha para Registro !-->
        <tr>

            <!-- Checkbox!-->
            <td align="center">
                <input type="checkbox" />
            </td>

            <!--Nome do Usuário !-->
            <td class="principal">
                Victor Pettengill Fernandes
            </td>

            <!--Username !-->
            <td class="principal">
                victor
            </td>

            <!--Password !-->
            <td class="principal">
                123456
            </td>

        </tr>
    </tbody>

</table>

<div style="float:left">
    <select name="acao" id="acao" style="margin-top:10px;" class="select">
        <option value="">.:: Opções ::.</option>
        <option value="excluir">Excluir marcados</option>
    </select>
    <input name="ok" id="submitBT" type="submit" value="ok"/>
</div>
    
</form>

<%@include file="../templates/trailer.jsp" %>
