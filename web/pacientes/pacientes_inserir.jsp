<%@page import="br.com.self.sangao.entity.Paciente"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<% 
    Paciente paciente = (Paciente) request.getAttribute("paciente");
%>

<div class="tituloPagina">
        <% 
    
       String id = "";
       String nome = "";
       String endereco = "";
       String telefone = "";
       String dtNascimento = "";
       
       
    if(paciente == null) {
        out.print("INSERIR PACIENTE");
    } else{
           id = ""+paciente.getId();
           nome = paciente.getNome();
           endereco = paciente.getEndereco();
           telefone = paciente.getTelefone();
           dtNascimento = Utils.FORMATADOR_DATA.format(paciente.getDtNascimento());
           
        out.print("EDITAR PACIENTE");
    }

 
%>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Pacientes" method="post">
    
    <input type="hidden" name="id" value="<% out.print(id);%>"/>

    <fieldset>

        <legend>Informações do Paciente</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome" value="<% out.print(nome);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Dt. Nasc *</legend>
        <br />
        <label>
            <input type="text" name="dtnasc" value="<% out.print(dtNascimento);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Endereço *</legend>
        <br />
        <label>
            <input type="text" name="endereco" value="<% out.print(endereco);%>"/>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Telefone *</legend>
        <br />
        <label>
            <input type="text" name="telefone" value="<% out.print(telefone);%>"/>
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
