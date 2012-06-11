<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
   INSERIR CONVÊNIO
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Convenios" method="post">

    <fieldset>

        <legend>Informações do Convênio</legend>
        <br />
        <legend>Paciente *</legend>
        <br />
        <label>
            <select name="paciente">
                <option value="2"> COCO </option>
            </select>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Natureza</legend>
        <br />
        <label>
            <select name="natureza">
                <option value="Pessoal"> Pessoal </option>
                <option value="Empresario"> Empresarial </option>
            </select>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Acomodação</legend>
        <br />
        <label>
            <select name="acomodacao">
                <option value="Individual"> Individual </option>
                <option value="Coletiva"> Coletiva </option>
            </select>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Validade</legend>
        <br />
        <label>
            <input type="text" name="validade"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Abrangência</legend>
        <br />
        <label>
            <select name="abrangencia">
                <option value="Municipal"> Municipal </option>
                <option value="Estadual"> Estadual </option>
                <option value="Nacional"> Nacional </option>
            </select>
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
