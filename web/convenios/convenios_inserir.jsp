<%@page import="br.com.self.sangao.entity.Paciente"%>
<%@page import="br.com.self.sangao.paciente.facade.PacienteFacade"%>
<%@page import="br.com.self.sangao.entity.Convenio"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<% 
    Convenio convenio = (Convenio) request.getAttribute("convenio");
%>

<div class="tituloPagina">
   <% 
   
    String matricula = "";
    String idPaciente = "";
    String natureza = "";
    String acomodacao = "";
    String validade = "";
    String abrangencia = "";
   
    if(convenio == null) {
        out.print("INSERIR CONVENIO");
    } else{
        matricula = ""+convenio.getMatricula();
        idPaciente = ""+convenio.getIdPaciente().getId();
        natureza = convenio.getNaturezaContratacao();
        validade = Utils.FORMATADOR_DATA.format(convenio.getValidade());
        acomodacao = convenio.getAcomodacao();
        abrangencia = convenio.getAbrangencia();
        
        out.print("EDITAR CONVENIO");
    }

 
%>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Convenios" method="post">

    <input type="hidden" name="matricula" value="<% out.print(matricula);%>">
    
    <fieldset>

        <legend>Informações do Convênio</legend>
        <br />
        <legend>Paciente *</legend>
        <br />
        <label>
            <select name="paciente">
                <% for(Paciente o : PacienteFacade.getInstance().getAllPacientes()) {%>
                <option value="<% out.print(o.getId());%>" <% if(idPaciente != ""){if(o.getId() == Integer.parseInt(idPaciente)){out.print("selected='selected'");}}%>> <% out.print(o.getNome());%> </option>
                <% }%>
            </select>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Natureza</legend>
        <br />
        <label>
            <select name="natureza">
                <option value="Pessoal" <% if(natureza.equals("Pessoal")){out.print("selected='selected'");}%>> Pessoal </option>
                <option value="Empresario" <% if(natureza.equals("Empresario")){out.print("selected='selected'");}%>> Empresarial </option>
            </select>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Acomodação</legend>
        <br />
        <label>
            <select name="acomodacao">
                <option value="Individual" <% if(acomodacao.equals("Individual")){out.print("selected='selected'");}%>> Individual </option>
                <option value="Coletiva" <% if(acomodacao.equals("Coletiva")){out.print("selected='selected'");}%>> Coletiva </option>
            </select>
        </label>
        <br />
    </fieldset>
    
    <fieldset>

        <legend>Validade</legend>
        <br />
        <label>
            <input type="text" name="validade" value="<% out.print(validade);%>"/>
        </label>
        <br />
    </fieldset>

    <fieldset>

        <legend>Abrangência</legend>
        <br />
        <label>
            <select name="abrangencia">
                <option value="Municipal" <% if(abrangencia.equals("Municipal")){out.print("selected='selected'");}%>> Municipal </option>
                <option value="Estadual" <% if(abrangencia.equals("Estadual")){out.print("selected='selected'");}%>> Estadual </option>
                <option value="Nacional" <% if(abrangencia.equals("Nacional")){out.print("selected='selected'");}%>> Nacional </option>
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
