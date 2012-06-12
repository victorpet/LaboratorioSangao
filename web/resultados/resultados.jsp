<%@page import="br.com.self.sangao.entity.Resultado"%>
<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    Resultados - <a href="<% out.print(Utils.ABSOLUTEPATH);%>Resultados?acao=inserir">Inserir novo Resultado</a>
</div>

<div class="clear"></div>

<%  List<Object> list = (List<Object>) request.getAttribute("list");%>

<% if (list != null) {
        if (list.size() > 0) {%>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Resultados" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Descrição</td>
            
            <td class="principal">Exame</td>
            
            <td>&nbsp;</td>

        </tr>
    </thead>
    <!-- FIM HEADER TABELA -->

    <tbody>

        <% for (Object o : list) {
                    Resultado u = (Resultado) o;
            %>
        
        <!--Linha para Registro !-->
        <tr>

            <!-- Checkbox!-->
            <td align="center">
                <input type="checkbox" name="ids[]" value="<% out.print(u.getId());%>"/>
            </td>
 
            <!--Nome!-->
            <td class="principal">
              <% out.print(u.getDescricao());%>
            </td>

            <!--Exame!-->
            <td class="principal">
                <% out.print(u.getIdExame().getId());%>
            </td>
            
            <td>
            <a href="<% out.print(Utils.ABSOLUTEPATH+"Resultados?acao=editar&id="+u.getId());%>">Editar</a>
            <td>

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
