<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
   INSERIR USUÁRIO
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>UsuariosServlet" method="post">

    <fieldset>

        <legend>Informações do Usuário</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Username *</legend>
        <br />
        <label>
            <input type="text" name="username"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Senha *</legend>
        <br />
        <label>
            <input type="password" name="senha"/>
        </label>
        <br />
    </fieldset>

    <div style="text-align:right;">
        <label>
            <input type="submit" name="acao" id="enviar" value="inserir" />
        </label>
    </div>

</form>

<%@include file="../templates/trailer.jsp" %>
