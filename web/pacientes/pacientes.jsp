<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.paciente.facade.PacienteFacade"%>
<%@page import="br.com.self.sangao.entity.Paciente"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<%
    List<Paciente> list = PacienteFacade.getInstance().getAllPacientes();
%>

<div class="tituloPagina">
    PACIENTES - <a href="<% out.print(Utils.ABSOLUTEPATH);%>pacientes/pacientes_inserir.jsp">Inserir novo Paciente</a>
</div>

<% if (request.getAttribute("mensagem") != null) {%>

<div>
    <h3><%=request.getAttribute("mensagem")%></h3>
</div>
<% }%>

<div class="clear"></div>

<%  List<Object> pacientes = (List<Object>) request.getAttribute("list");%>

<% if (list != null) {
        if (list.size() > 0) {%>

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


            <% for (Object o : list) {
                    Paciente p = (Paciente) o;
            %>
            <tr>
                <!-- Checkbox!-->
                <td align="center">
                    <input type="checkbox" />
                </td>

                <!--Nome!-->
                <td class="principal">
                    <%=p.getNome()%>
                </td>

                <!--Dt. Nasc !-->
                <td class="principal">
                    <%=p.getDtNascimento()%>
                </td>

                <!--Endereço !-->
                <td class="principal">
                    <%=p.getEndereco()%>
                </td>

                <!--Telefone !-->
                <td class="principal">
                    <%=p.getTelefone()%>
                </td>
                
                <!--Editar !-->
                <td class="principal">
                    <a href="<% out.print(Utils.ABSOLUTEPATH+"Pacientes?acao=editar&id="+p.getId());%>">Editar</a>
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
