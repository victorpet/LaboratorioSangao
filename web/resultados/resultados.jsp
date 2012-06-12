<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    Resultados - <a href="<% out.print(Utils.ABSOLUTEPATH);%>resultados/resultados_inserir.jsp">Inserir novo Resultado</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>ResultadosServlet" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Descrição</td>
            
            <td class="principal">Exame</td>

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
              Descrição do resultado
            </td>

            <!--Exame!-->
            <td class="principal">
                <!--Fazer Link para vizualizar o exame !-->
                12314124312
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
