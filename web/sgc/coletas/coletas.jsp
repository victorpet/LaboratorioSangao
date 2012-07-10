<%@page import="br.com.self.sangao.entity.Coleta"%>
<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.paciente.facade.PacienteFacade"%>
<%@page import="br.com.self.sangao.entity.Paciente"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    COLETAS - <a href="<% out.print(Utils.ABSOLUTESGC);%>coletas/coletas_inserir.jsp">Inserir nova coleta</a>
</div>

<% if (request.getAttribute("mensagem") != null) {%>

<div>
    <h3><%=request.getAttribute("mensagem")%></h3>
</div>
<% }%>

<div class="clear"></div>

<%  List<Object> coletas = (List<Object>) request.getAttribute("list");%>

<% if (coletas != null) {
        if (coletas.size() > 0) {%>

<form action="<% out.print(Utils.ABSOLUTESGC);%>Coletas" method="post">

    <table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

        <!-- HEADER DA TABELA -->
        <thead>
            <tr class="header">

                <!-- HEADERS -->

                <td>&nbsp;</td>

                <td class="principal">Nome do Paciente</td>

                <td class="principal">Dt. Coleta</td>

                <td class="principal">Dt. Entrega</td>

                <td class="principal">Nome do médico</td>
                
                <td class="principal">Tipo de exame</td>

            </tr>
        </thead>
        <!-- FIM HEADER TABELA -->

        <tbody>

            <!--Linha para Registro !-->


            <% for (Object o : coletas) {
                    Coleta c = (Coleta) o;
            %>
            <tr>
                <!-- Checkbox!-->
                <td align="center">
                    <input type="checkbox" name="ids[]" value="<% out.print(c.getId());%>"/>
                </td>

                <!--Nome!-->
                <td class="principal">
                    <% out.print(c.getIdPaciente().getNome()); %>
                </td>

                <!--Dt. Coleta !-->
                <td class="principal">
                    <% out.print(Utils.FORMATADOR_DATA.format(c.getDtColeta())); %>
                </td>

                <!--Dt. Entrega !-->
                <td class="principal">
                    <% out.print(Utils.FORMATADOR_DATA.format(c.getDtEntrega())); %>
                </td>

                <!--Nome Médico !-->
                <td class="principal">
                    <% out.print(c.getIdMedico().getNome()); %>
                </td>
                
                <!--Tipo de exame !-->
                <td class="principal">
                    <% out.print(c.getTipoExame().getDescricao());%>
                </td>
                
                <!--Editar !-->
                <td class="principal">
                    <a href="<% out.print(Utils.ABSOLUTESGC+"Coletas?acao=editar&id="+c.getId());%>">Editar</a>
                </td>
                
                <!--Etiqueta !-->
                <td class="principal">
                    <a href="<% out.print(Utils.ABSOLUTESGC+"Coletas?acao=imprimir&id="+c.getId());%>">Imprimir Etiqueta</a>
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

<div>Não existem registros.</div>

<% }%>

<%@include file="../templates/trailer.jsp" %>
