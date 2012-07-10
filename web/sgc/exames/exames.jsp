<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    Exames - <a href="<% out.print(Utils.ABSOLUTESGC);%>exames/exames_inserir.jsp">Inserir novo Exame</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTESGC);%>ExamesServlet" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Data Coleta</td>
            
            <td class="principal">Data Entrega</td>
            
            <td class="principal">Resultados</td>
            
            <td class="principal">Tipo de Exame</td>
            
            <td class="principal">Paciente</td>
            
            <td class="principal">Médico</td>

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
 
            <!-- Data Coleta!-->
            <td class="principal">Data Coleta</td>
            
            <!-- Data Entrega!-->
            <td class="principal">Data Entrega</td>
            
            <!-- Resultados!-->
            <td class="principal">Resultados</td>
            
            <!-- Tipo de Exame!-->
            <td class="principal">Tipo de Exame</td>
            
            <!-- Paciente!-->
            <td class="principal">Paciente</td>
            
            <!-- Médico!-->
            <td class="principal">Médico</td>

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
