<%@page import="br.com.self.sangao.entity.Medico"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<% 
    Medico medico = (Medico) request.getAttribute("medico");
%>

<div class="tituloPagina">
    
    <% 
    
       String id = "";
       String nome = "";
       String crm = "";
       
       
    if(medico == null) {
        out.print("INSERIR M�DICO");
    } else{
           id = ""+medico.getId();
           nome = medico.getNome();
           crm = medico.getCrm();
           
        out.print("EDITAR M�DICO");
    }

 
%>
 
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Medicos" method="post">

    <input type="hidden" name="id" value="<% out.print(id);%>"/>
    
    <fieldset>

        <legend>Informa��es do M�dico</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome" value="<% out.print(nome);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>CRM *</legend>
        <br />
        <label>
            <input type="text" name="crm" value="<% out.print(crm);%>"/>
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
