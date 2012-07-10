<%@page import="br.com.self.sangao.coleta.facade.ColetaFacade"%>
<%@page import="br.com.self.sangao.entity.TipoExame"%>
<%@page import="br.com.self.sangao.medico.facade.MedicoFacade"%>
<%@page import="br.com.self.sangao.entity.Medico"%>
<%@page import="java.util.List"%>
<%@page import="br.com.self.sangao.paciente.facade.PacienteFacade"%>
<%@page import="br.com.self.sangao.entity.Paciente"%>
<%@page import="br.com.self.sangao.entity.Coleta"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<%
    Coleta coleta = (Coleta) request.getAttribute("coleta");
%>

<div class="tituloPagina">
    <%

        String id = "";
        Paciente paciente = new Paciente();
        String dtColeta = "";
        String dtEntrega = "";
        Medico medico = new Medico();
        TipoExame tipo = new TipoExame();


        if (coleta == null) {
            out.print("INSERIR COLETA");
        } else {
            id = "" + coleta.getId();
            paciente = coleta.getIdPaciente();
            dtColeta = Utils.FORMATADOR_DATA.format(coleta.getDtColeta());
            dtEntrega = Utils.FORMATADOR_DATA.format(coleta.getDtEntrega());
            medico = coleta.getIdMedico();
            tipo = coleta.getTipoExame();

            out.print("EDITAR COLETA");
        }


    %>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTESGC);%>Coletas" method="post">

    <input type="hidden" name="id" value="<% out.print(id);%>"/>

    <fieldset>

        <legend>Informações da Coleta</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <select name="nome">
                <% 
                   List<Paciente> list = PacienteFacade.getInstance().getAllPacientes();
                %>
                <option value=""> .:: Selecione ::.</option>
                <% for (Paciente p : list) {%>
                <option value="<% out.print(p.getId()); %>" <% if (p.getId().equals(paciente.getId())) { %> selected="selected"<% } %>> <% out.print(p.getNome()); %></option>
                <% } %>
            </select>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Dt. Coleta *</legend>
        <br />
        <label>
            <input type="text" name="dtColeta" value="<% out.print(dtColeta);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Dt. Entrega *</legend>
        <br />
        <label>
            <input type="text" name="dtEntrega" value="<% out.print(dtEntrega);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Médico *</legend>
        <br />
        <label>
            <select name="medico">
                <% List<Medico> lista = MedicoFacade.getInstance().getAllMedicos(); %>
                <option value=""> .:: Selecione ::.</option>
                <% for (Medico m : lista) { %>
                <option value="<% out.print(m.getId()); %>" <% if (m.getId().equals(medico.getId())) { %> selected="selected"<% } %>> <% out.print(m.getNome()); %></option>
                <% }%>
            </select>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Tipo de Exame *</legend>
        <br />
        <label>
            <select name="tipoExame">
                <% List<TipoExame> listas = ColetaFacade.getInstance().getAllTipoExames();
                %>
                <option value=""> .:: Selecione ::.</option>
                <% for (TipoExame t : listas) {
                %>
                <option value="<% out.print(t.getId()); %>" <% if (t.getId().equals(tipo.getId())) { %> selected="selected"<% } %>> <% out.print(t.getDescricao()); %></option>
                <% }%>
            </select>
        </label>
        <br />
    </fieldset>

    <div style="text-align:right;">
        <label>
            <input type="submit" name="acao" id="enviar" value="Salvar" />
        </label>
    </div>

</form>

<%@include file="../templates/trailer.jsp" %>
