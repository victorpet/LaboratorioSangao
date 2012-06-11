<%@page import="br.com.self.sangao.utils.Utils"%>
<%@include file="../templates/header.jsp" %>

<div class="tituloPagina">
    Convenios - <a href="<% out.print(Utils.ABSOLUTEPATH);%>Convenios?acao=inserir">Inserir novo Convênio</a>
</div>

<div class="clear"></div>

<form action="<% out.print(Utils.ABSOLUTEPATH);%>Convenios" method="post">

    <table width="940" border="0" cellspacing="0" cellpadding="0" id="tableList">

        <!-- HEADER DA TABELA -->
        <thead>
            <tr class="header">

                <!-- HEADERS -->

                <td>&nbsp;</td>

                <td class="principal">
                    Paciente
                </td>
                
                <td class="principal">
                    Natureza
                </td>

                <td class="principal">
                    Acomodação
                </td>

                <td class="principal">
                    Validade
                </td>

                <td class="principal">
                    Abrangência
                </td>

                <td>&nbsp;</td>

            </tr>
        </thead>
        <!-- FIM HEADER TABELA -->

        <tbody>

            <!--Linha para Registro !-->
            <tr>

                <!-- Checkbox!-->
                <td align="center">
                    <input type="checkbox" />
                </td>

                <td class="principal">
                    Paciente
                </td>

                <td class="principal">
                    Natureza
                </td>
                
                <td class="principal">
                    Acomodação
                </td>

                <td class="principal">
                    Validade
                </td>

                <td class="principal">
                    Abrangência
                </td>

                <!--Editar !-->
                <td class="principal">
                    
                </td>

            </tr>
        </tbody>

    </table>

    <div style="float:left">
        <select name="acao" id="acao" style="margin-top:10px;" class="select">
            <option value="">.:: Opções ::.</option>
            <option value="excluir">Excluir marcados</option>
        </select>
        <input name="ok" id="submitBT" type="submit" value="ok"/>
    </div>

</form>

<%@include file="../templates/trailer.jsp" %>
