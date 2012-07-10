<%@page import="br.com.self.sangao.entity.Medico"%>
<%@page import="java.util.List" %>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    MEDICOS - <a href="<% out.print(Utils.ABSOLUTESGC);%>Medicos?acao=inserir">Inserir novo Médico</a>
</div>

<div class="clear"></div>

<%  List<Object> list = (List<Object>) request.getAttribute("list");%>

<% if (list != null) {
        if (list.size() > 0) {%>

<form action="<% out.print(Utils.ABSOLUTESGC);%>Medicos" method="post">

<table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

    <!-- HEADER DA TABELA -->
    <thead>
        <tr class="header">

            <!-- HEADERS -->

            <td>&nbsp;</td>

            <td class="principal">Nome</td>

            <td class="principal">CRM</td>
            
            <td>&nbsp;</td>

        </tr>
    </thead>
    <!-- FIM HEADER TABELA -->

    <tbody>

        <% for (Object o : list) {
                    Medico u = (Medico) o;
            %>
            
        <!--Linha para Registro !-->
        <tr>

            <!-- Checkbox!-->
            <td align="center">
               <input type="checkbox" name="ids[]" value="<% out.print(u.getId());%>"/>
            </td>

            <!--Nome!-->
            <td class="principal">
                <% out.print(u.getNome());%>
            </td>

            <!--CRM !-->
            <td class="principal">
                <% out.print(u.getCrm());%>
            </td>
            
            <td>
            <a href="<% out.print(Utils.ABSOLUTESGC+"Medicos?acao=editar&id="+u.getId());%>">Editar</a>
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
