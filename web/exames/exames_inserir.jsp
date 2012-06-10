<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
   INSERIR EXAME
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>ExamesServlet" method="post">

    <fieldset>

        <legend>Informações do Exame</legend>
        <br />
        <legend>Data Coleta *</legend>
        <br />
        <label>
            <input type="text" name="dtcoleta"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Data Entrega *</legend>
        <br />
        <label>
            <input type="text" name="dtentrega"/>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Tipo do Exame *</legend>
        <br />
        <label>
            <input type="text" name="tipoexame"/>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Paciente</legend>
        <br />
        <label>
            <input type="text" name="paciente"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Medico</legend>
        <br />
        <label>
            <input type="text" name="medico"/>
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
