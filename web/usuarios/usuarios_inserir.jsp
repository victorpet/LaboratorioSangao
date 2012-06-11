<%@page import="br.com.self.sangao.entity.Usuario"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<% 
    Usuario user = (Usuario) request.getAttribute("usuario");
%>

<div class="tituloPagina">
    
    <% 
    
       String id = "";
       String nome = "";
       String username = "";
       String senha = "";
       
       
    if(user == null) {
        out.print("INSERIR USUÁRIO");
    } else{
           id = ""+user.getId();
           nome = user.getNome();
           username = user.getUsername();
           senha = user.getSenha();
           
        out.print("EDITAR USUÁRIO");
    }

 
%>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Usuarios" method="post">

    <input type="hidden" name="id" value="<% out.print(id);%>"/>
    
    <fieldset>

        <legend>Informações do Usuário</legend>
        <br />
        <legend>Nome *</legend>
        <br />
        <label>
            <input type="text" name="nome" value="<% out.print(nome);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Username *</legend>
        <br />
        <label>
            <input type="text" name="username" value="<% out.print(username);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Senha *</legend>
        <br />
        <label>
            <input type="password" name="senha" value="<% out.print(senha);%>"/>
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
