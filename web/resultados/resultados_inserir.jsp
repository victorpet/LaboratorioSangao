<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    INSERIR RESULTADO
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>ResultadosServlet" method="post">

    <fieldset>

        <legend>Informa��es do Resultado</legend>
        <br />
        <legend>Descri��o *</legend>
        <br />
        <label>
            <input type="text" name="descricao"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>N� do Exame</legend>
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
