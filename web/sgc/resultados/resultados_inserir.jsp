<%@page import="br.com.self.sangao.coleta.facade.ColetaFacade"%>
<%@page import="br.com.self.sangao.entity.Coleta"%>
<%@page import="br.com.self.sangao.entity.Resultado"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<% 
    Resultado resultado = (Resultado) request.getAttribute("resultado");
%>

<div class="tituloPagina">
    
   <% 
       String id = "";
       String descricao = "";
       String coleta = "";
       
    if(resultado == null) {
        out.print("INSERIR RESULTADO");
    } else{
           id = ""+resultado.getId();
           descricao = resultado.getDescricao();
           coleta = ""+resultado.getIdExame().getId();
           
        out.print("EDITAR RESULTADO");
    }

 
%>

</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTESGC);%>Resultados" method="post">

    <input type="hidden" name="id" value="<% out.print(id);%>"/>
    
    <fieldset>

        <legend>Informações do Resultado</legend>
        <br />
        <legend>Descrição *</legend>
        <br />
        <label>
            <input type="text" name="descricao" value="<% out.print(descricao);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Nº do Exame</legend>
        <br />
        <label>
            <select name="coleta">
                <% for(Coleta o : ColetaFacade.getInstance().getAllColetas()) {%>
                <option value="<% out.print(o.getId());%>" <% if(coleta != ""){if(o.getId() == Integer.parseInt(coleta)){out.print("selected='selected'");}}%>> <% out.print(o.getId());%> </option>
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
