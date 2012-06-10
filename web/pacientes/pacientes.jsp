<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    PACIENTES - <a href="<% out.print(Utils.ABSOLUTEPATH);%>pacientes/pacientes_inserir.jsp">Inserir novo Paciente</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>PacientesServlet" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Nome</td>

            <td class="principal">Dt. Nasc</td>

            <td class="principal">Endereço</td>
            
            <td class="principal">Telefone</td>

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

            <!--Dt. Nasc !-->
            <td class="principal">
                28/12/1992
            </td>

            <!--Endereço !-->
            <td class="principal">
                Rua Doutor Arlindo de Andrade
            </td>
            
            <!--Telefone !-->
            <td class="principal">
                (67) 9812-6106
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
