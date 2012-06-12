<%@page import="br.com.self.sangao.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    USUÁRIOS - <a href="<% out.print(Utils.ABSOLUTEPATH+"Usuarios?acao=inserir");%>">Inserir novo Usuário</a>
</div>

<div class="clear"></div>

<%  List<Object> list = (List<Object>) request.getAttribute("list");%>

<% if (list != null) {
        if (list.size() > 0) {%>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Usuarios" method="post">

    <table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

        <!-- HEADER DA TABELA -->
        <thead>
            <tr class="header">

                <!-- HEADERS -->

                <td>&nbsp;</td>

                <td class="principal">Nome do Usuário</td>

                <td class="principal">Username</td>

                <td class="principal">Senha</td>
                
                <td>&nbsp;</td>

            </tr>
        </thead>
        <!-- FIM HEADER TABELA -->

        <tbody>

            <% for (Object o : list) {
                    Usuario u = (Usuario) o;
            %>

            <!--Linha para Registro !-->
            <tr>

                <!-- Checkbox!-->
                <td align="center">
                    <input type="checkbox" name="ids[]" value="<% out.print(u.getId());%>"/>
                </td>

                <!--Nome do Usuário !-->
                <td class="principal">
                    <% out.print(u.getNome());%>
                </td>

                <!--Username !-->
                <td class="principal">
                    <% out.print(u.getUsername());%>
                </td>

                <!--Password !-->
                <td class="principal">
                    <% out.print(u.getSenha());%>
                </td>
                
                <!--Editar !-->
                <td class="principal">
                    <a href="<% out.print(Utils.ABSOLUTEPATH+"Usuarios?acao=editar&id="+u.getId());%>">Editar</a>
                </td>

            </tr>    

            <% }%>

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

<% }
} else {%>

<div>Não Existem registros ainda</div>

<% }%>

<%@include file="../templates/trailer.jsp" %>
