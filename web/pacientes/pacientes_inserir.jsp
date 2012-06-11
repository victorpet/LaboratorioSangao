<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    INSERIR PACIENTE
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Pacientes" method="post">

    <fieldset>

        <legend>Informações do Paciente</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Dt. Nasc *</legend>
        <br />
        <label>
            <input type="text" name="dtnasc"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Endereço *</legend>
        <br />
        <label>
            <input type="text" name="endereco"/>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Telefone *</legend>
        <br />
        <label>
            <input type="text" name="telefone"/>
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
