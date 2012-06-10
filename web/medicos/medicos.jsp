<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    MEDICOS - <a href="<% out.print(Utils.ABSOLUTEPATH);%>medicos/medicos_inserir.jsp">Inserir novo Médico</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>MedicosServlet" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Nome</td>

            <td class="principal">CRM</td>

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

            <!--Nome!-->
            <td class="principal">
                Victor Pettengill Fernandes
            </td>

            <!--CRM !-->
            <td class="principal">
                37546
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
