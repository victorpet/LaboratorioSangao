<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    INSERIR RESULTADO
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>ResultadosServlet" method="post">

    <fieldset>

        <legend>Informações do Resultado</legend>
        <br />
        <legend>Descrição *</legend>
        <br />
        <label>
            <input type="text" name="descricao"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Nº do Exame</legend>
        <br />
        <label>
            <input type="text" name="exame"/>
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
