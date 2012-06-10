<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
   INSERIR MÉDICO
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>MedicosServlet" method="post">

    <fieldset>

        <legend>Informações do Médico</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>CRM *</legend>
        <br />
        <label>
            <input type="text" name="crm"/>
        </label>
        <br />
    </fieldset>

    <div style="text-align:right;">
        <label>
            <input type="submit" name="acao" id="enviar" value="Inserir" />
        </label>
    </div>

</form>

<%@include file="../templates/trailer.jsp" %>
