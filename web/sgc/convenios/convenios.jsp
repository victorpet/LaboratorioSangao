<%@page import="br.com.self.sangao.entity.Convenio"%>
<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    Convenios - <a href="<% out.print(Utils.ABSOLUTESGC);%>Convenios?acao=inserir">Inserir novo Convênio</a>
</div>

<div class="clear"></div>

<%  List<Object> list = (List<Object>) request.getAttribute("list");%>

<% if (list != null) {
        if (list.size() > 0) {%>
        
<form action="<% out.print(Utils.ABSOLUTESGC);%>Convenios" method="post">

    <table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

        <!-- HEADER DA TABELA -->
        <thead>
            <tr class="header">

                <!-- HEADERS -->

                <td>&nbsp;</td>

                <td class="principal">
                    Paciente
                </td>
                
                <td class="principal">
                    Natureza
                </td>

                <td class="principal">
                    Acomodação
                </td>

                <td class="principal">
                    Validade
                </td>

                <td class="principal">
                    Abrangência
                </td>

                <td>&nbsp;</td>

            </tr>
        </thead>
        <!-- FIM HEADER TABELA -->

        <tbody>

            <% for (Object o : list) {
                    Convenio u = (Convenio) o;
            %>
            
            <!--Linha para Registro !-->
            <tr>

                <!-- Checkbox!-->
                <td align="center">
                    <input type="checkbox" name="ids[]" value="<% out.print(u.getMatricula());%>"/>
                </td>

                <td class="principal">
                    <% out.print(u.getIdPaciente().getNome());%>
                </td>

                <td class="principal">
                    <% out.print(u.getNaturezaContratacao());%>
                </td>
                
                <td class="principal">
                    <% out.print(u.getAcomodacao());%>
                </td>

                <td class="principal">
                    <% out.print(u.getValidade());%>
                </td>

                <td class="principal">
                    <% out.print(u.getAbrangencia());%>
                </td>

                <!--Editar !-->
                <td class="principal">
                    <a href="<% out.print(Utils.ABSOLUTESGC+"Convenios?acao=editar&id="+u.getMatricula());%>">Editar</a>
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

<% } else{
        out.print("<div>Não Existem registros ainda</div>");    
}
} else {%>

<div>Não Existem registros ainda</div>

<% }%>

<%@include file="../templates/trailer.jsp" %>
