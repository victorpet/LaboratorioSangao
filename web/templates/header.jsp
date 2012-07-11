<%-- 
    Document   : header
    Created on : Jun 20, 2012, 11:12:13 AM
    Author     : Prado
--%>

<%@page import="br.com.self.sangao.front.servlets.LoginCliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.self.sangao.entity.Usuario"%>
<%@page import="br.com.self.sangao.usuario.facade.UsuarioFacade"%>
<%@page import="br.com.self.sangao.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laboratório Pró-Fórmula</title>
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/reset.css">
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/960.css">
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/padrao.css">
        <link rel="stylesheet" href="<% out.print(Utils.ABSOLUTEPATH);%>styles/login.css">

        <link href="<% out.print(Utils.ABSOLUTEPATH);%>styles/jimgMenu.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-easing-1.3.pack.js"></script>
        <script type="text/javascript" src="js/jquery-easing-compatibility.1.2.pack.js"></script>
        <script type="text/javascript" src="js/reflection.js"></script>
        <script type="text/javascript" src="js/jquery.scrollTo-1.4.2-min.js"></script>
        <script type="text/javascript" src="js/jquery.localscroll-1.2.7-min.js"></script>
        <script type="text/javascript" src="js/jquery.serialScroll-1.2.2-min.js"></script>
        <script type="text/javascript" src="js/jquery.infieldlabel.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/formSubmit.js"></script>
        <!--        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>-->

        <% String sessao = (String) session.getAttribute("logado");
            String idPaciente = (String) session.getAttribute("id");
            boolean logado = false;

            if ("true".equals(sessao)) {
                logado = true;
            }

            String act = request.getParameter("act");
            if (act != null) {
                if ("logout".equals("logout")) {
                    logado = false;
                }
            }%>

        <script type="text/javascript">
            
            //            var center = new google.maps.LatLng(-20.4806307,-54.6065936);
            //            var browserSupportFlag =  new Boolean();
            //            var marker;
            //            var map;
            //
            //            function initialize() {
            //                var myOptions = {
            //                    zoom: 16,
            //                    center: center,
            //                    mapTypeId: google.maps.MapTypeId.ROADMAP
            //                };
            //                map = new google.maps.Map(document.getElementById("map"), myOptions);
            //  
            //                marker = new google.maps.Marker({
            //                    map: map,
            //                    draggable: true,
            //                    animation: google.maps.Animation.BOUNCE,
            //                    position: center,
            //                    //                    position: center,
            //                    title:"LaboratÃ³rio PrÃ³-FÃ³rmula"
            //                });
            //                
            //                //                google.maps.event.addListener(marker, 'click', toggleBounce);
            //                
            //            }
            
            $(document).ready(function () {
                
                //                initialize();
                
                document.onclick=evento; 
                function evento(e){ 
                    var target = (e && e.target) || (event && event.srcElement); 
                    var obj = document.getElementById('loginBox'); 
                    var obj2 = document.getElementById('logar'); 
                    checkParent(target)?null:$("#loginBox").hide(300); 
                    target==obj2?obj.style.display='block':null; 
                } 
                function checkParent(t){ 
                    while(t.parentNode){ 
                        if(t==document.getElementById('loginBox') || t==document.getElementById('logar')){ 
                            return true 
                        } 
                        t=t.parentNode 
                    } 
                    return false 
                } 
                
                // find the elements to be eased and hook the hover event
                $('div.jimgMenu ul li a').hover(function() {
    
                    // if the element is currently being animated (to a easeOut)...
                    if ($(this).is(':animated')) {
                        $(this).stop().animate({width: "310px"}, {duration: 450, easing:"easeOutQuad"});
                    } else {
                        // ease in quickly
                        $(this).stop().animate({width: "310px"}, {duration: 400, easing:"easeOutQuad"});
                    }
                }, function () {
                    // on hovering out, ease the element out
                    if ($(this).is(':animated')) {
                        $(this).stop().animate({width: "78px"}, {duration: 400, easing:"easeInOutQuad"})
                    } else {
                        // ease out slowly
                        $(this).stop('animated:').animate({width: "78px"}, {duration: 450, easing:"easeInOutQuad"});
                    }
                });
                
                
                $('#tipoAcesso').change( function() {
                    //                    ('#protocoloCrm').html('CRM');
                    if (document.getElementById("protocoloCrm").innerHTML == 'Protocolo'){
                        document.getElementById("protocoloCrm").innerHTML ='CRM';  
                    } else {
                        document.getElementById("protocoloCrm").innerHTML ='Protocolo';  
                    }
                });
                
                
            });
            
            var bool = false;
            $(document).ready(function(){
                $("#logar").click(
                function(){
                    $("#loginBox").show(300);
                });

                //                $(document).click(function(e) {
                //                    if(bool === true){
                //                        $("#loginBox").hide(500, function(){});
                //                        bool = false;
                //                    }
                //                });
                //                $("#loginBox").hover(function(){bool = false;}, function(){bool = true;});
            });
            
            function fill(e){
                if (e == "medico"){
                    document.getElementById("field").value = "CRM";
                } else {
                    document.getElementById("field").value = "IdentificaÃÂ§ÃÂ£o";
                }
            }
            
            function clean(e) {
                if (document.getElementById(e).value == "IdentificaÃÂ§ÃÂ£o" || 
                    document.getElementById(e).value == "CRM"){
                    document.getElementById(e).value = "";
                }
            }
            
            function logar(){
                $('#logon').submit();
            }
            
            function cadastrarMedico(){
                $('#form2').submit();
            }
            
            function refill(e){
                
                if (document.getElementById(e).value == ""){
                    if (document.getElementById("medico").checked == true) {
                        document.getElementById("field").value = "CRM";
                    } else {
                        document.getElementById("field").value = "IdentificaÃÂ§ÃÂ£o";
                    }
                }
            }
            
            function setFocus(idaba){
                //                alert(idaba);
                var aba=document.getElementById(idaba);
                //                    alert(aba);
                var nAbas="2"; <!-- colocar o nÃÂºmero de abas  1-->
                for(var i="1";i<=nAbas;i++){
                    var id="aba"+i;
                    //                        alert(id);
                    document.getElementById(id).className="";
                    //                        alert('OK');
                }
                //                    alert('vai mostrar');
                aba.className="selected";
            }
            //            
            //            $(document).ready(function(){
            //                $("label").inFieldLabels();
            //            });
            
            function submeterExame(){
                $('#logon2').submit();
            }
            
            function submeter(){
                $('#form1').submit();
            }
                
            function logar(){
                $('#logon').submit();
            }
            
            // when the DOM is ready...
            $(document).ready(function () {
                
                $(function($) {
                    // Quando o formulário for enviado, essa função é chamada
                    $("#logon2").submit(function() {
                        // Colocamos os valores de cada campo em uma variavel para facilitar a manipulaÃ§Ã£o
                        var idPaciente = <%=idPaciente%>;
                        var crmMedico = $("#crmMedico").val();
                        var data = $("#dataExame").val();
                        var exames = $('#txtarea').find('div');
                        var array = new Array(exames.size());
                        for (var i = 0; i < exames.size(); i++){
                            alert(($('#txtarea').children().eq(i)).name);
                        }
                    
                        // Exibe mensagem de carregamento
                        $("#status").html("<img src='images/load.gif' alt='Enviando' />");
                        // Fazemos a requisÃ£o ajax com o arquivo envia.php e enviamos os valores de cada campo atravÃ©s do mÃ©todo POST
                        $.post('ExamesClientes', {idPaciente: idPaciente, data: data, crmMedico: crmMedico, array: array}, 
                        function(resposta) {
                            // Quando terminada a requisiÃ§Ã£o
                            // Exibe a div status
                            $("#status").slideDown();
                            // Se a resposta Ã© um erro
                            if (resposta != false) {
                                // Exibe o erro na div
                                $("#status").html(resposta);
                            } 
                            // Se resposta for false, ou seja, nÃ£o ocorreu nenhum erro
                            else {
                                // Exibe mensagem de sucesso
                                $("#logon2").hide('slow').after('<div id="resp"><h1 id="thx">Cadastro realizado com sucesso!<br />A partir de agora vocÃª jÃ¡ pode agendar seus exames on-line.</h1><br /><button id="novo" onclick="mostra()">Agendar</button></div>');
                                $('#status').slideUp();
                            }
                        });
                    });
                });
                
                $(function($) {
                    // Quando o formulário for enviado, essa função é chamada
                    $("#form2").submit(function() {
                        // Colocamos os valores de cada campo em uma variavel para facilitar a manipulaÃ§Ã£o
                        var nome = $('#nomeMedico').val();
                        var crm = $('#crm').val();
                        var email = $('#emailMedico').val();
                        var telefone = $('#telefoneMedico').val();
                    
                        // Exibe mensagem de carregamento
                        $("#status").html("<img src='images/load.gif' alt='Enviando' />");
                        // Fazemos a requisÃ£o ajax com o arquivo envia.php e enviamos os valores de cada campo atravÃ©s do mÃ©todo POST
                        $.post('Doctors', {nome: nome, crm: crm, email: email, telefone: telefone}, 
                        function(resposta) {
                            // Quando terminada a requisiÃ§Ã£o
                            // Exibe a div status
                            $("#status").slideDown();
                            // Se a resposta Ã© um erro
                            if (resposta != false) {
                                // Exibe o erro na div
                                $("#status").html(resposta);
                            } 
                            // Se resposta for false, ou seja, nÃ£o ocorreu nenhum erro
                            else {
                                // Exibe mensagem de sucesso
                                $("#form2").hide('slow').after('<div id="resp"><h2 id="thx">Cadastro realizado com sucesso!<br />Você receberá em seu email uma senha para acessar os nossos serviços.</h1><br /><button id="novo" onclick="mostra()">Voltar</button></div>');
                                $('#status').slideUp();
                            }
                        });
                    });
                });
                
                $(function($) {
                    // Quando o formulário for enviado, essa função é chamada
                    $("#form1").submit(function() {
                        // Colocamos os valores de cada campo em uma variavel para facilitar a manipulaÃ§Ã£o
                        var nome = $("#nomePaciente").val();
                        var sexo = document.getElementById('sex').value;
                        var endereco = $("#enderecoPaciente").val();
                        var bairro = $("#bairroPaciente").val();
                        var cidade = $("#cidadePaciente").val();
                        var estado = $("#estadoPaciente").val();
                        var telefone = $("#telefone1Paciente").val();
                        var email = $("#emailPaciente").val();
                        var usuario = $("#usuarioPaciente").val();
                        var senha = $("#senhaPaciente").val();
                    
                        // Exibe mensagem de carregamento
                        $("#status").html("<img src='images/load.gif' alt='Enviando' />");
                        // Fazemos a requisÃ£o ajax com o arquivo envia.php e enviamos os valores de cada campo atravÃ©s do mÃ©todo POST
                        $.post('Clientes', {nome: nome, sexo: sexo, endereco: endereco, bairro: bairro, cidade: cidade, 
                            estado: estado, telefone: telefone, email: email, usuario: usuario, senha: senha}, 
                        function(resposta) {
                            // Quando terminada a requisiÃ§Ã£o
                            // Exibe a div status
                            $("#status").slideDown();
                            // Se a resposta Ã© um erro
                            if (resposta != false) {
                                // Exibe o erro na div
                                $("#status").html(resposta);
                            } 
                            // Se resposta for false, ou seja, nÃ£o ocorreu nenhum erro
                            else {
                                // Exibe mensagem de sucesso
                                $("#form1").hide('slow').after('<div id="resp"><h1 id="thx">Cadastro realizado com sucesso!<br />A partir de agora você já pode agendar seus exames on-line.</h1><br /><button id="novo" onclick="mostra()">Fazer login</button></div>');
                                $('#status').slideUp();
                            }
                        });
                    });
                });
               
                $(function($) {
                    // Quando o formulÃ¡rio for enviado, essa funÃ§Ã£o Ã© chamada
                    $("#logon").submit(function() {
                        alert("Entrou no submit");
                        // Colocamos os valores de cada campo em uma vÃ¡riavel para facilitar a manipulaÃ§Ã£o
                        var usuario = $("#usuarioCliente").val();
                        var senha = $("#senhaCliente").val();
                        // Exibe mensagem de carregamento
                        $("#status").html("<img src='images/load.gif' alt='Enviando' />");
                        // Fazemos a requisÃ£o ajax com o arquivo envia.php e enviamos os valores de cada campo atravÃ©s do mÃ©todo POST
                        $.post('LoginCliente', {usuario: usuario, senha: senha}, 
                        function(resposta) {
                            //                            alert(resposta);
                            // Quando terminada a requisiÃ§Ã£o
                            // Exibe a div status
                            $("#status").slideDown();
                            // Se a resposta Ã© um erro
                            if (resposta != false) {
                                alert("true");
                                // Exibe o erro na div
                                //                                $("#status").html(resposta);
                            } 
                            // Se resposta for false, ou seja, nÃ£o ocorreu nenhum erro
                            else {
                                // Exibe mensagem de sucesso
                                alert('false');
                                $("#form1").hide('slow').after('<div id="resp"><h1 id="thx">Cadastro realizado com sucesso!<br />A partir de agora vocÃª jÃ¡ pode agendar seus exames on-line.</h1><br /><button id="novo" onclick="mostra()">Agendar</button></div>');
                                $('#status').slideUp();
                            }
                        });
                    });
                });
                
                
                
                $('#btCadastrar').click(function () {
                    $('#logon').fadeOut(300, function() {
                        $('#exames').animate({height: '270px'});
                        $('#content').animate({height: '270px'});
                        $('#form1').show();
                        $('#clientes').fadeIn(300);
                        $('#doctors').fadeIn(300);
                    });
                    
                });
                
                $('#clientes').click(function () {
                    $('#form2').fadeOut(function() {
                        $('#form1').fadeIn(300);
                    });
                    $('.innerDoctors').css({background: "darkorange"});
                    $('.innerClientes').css({background: "#55ea55"});
                    $('#form2')[0].reset();
                    $('#content').animate({height: "270px"}, 600);
                
                });
            
                $('#doctors').click(function () {
                    $('#form1').fadeOut(function(){
                        $('#logon').hide();
                        $('#logon2').hide();
                        $('#form2').fadeIn(300);
                    });
                    $('.innerClientes').css({background: "darkorange"});
                    $('.innerDoctors').css({background: "#55ea55"});
                    $('#form1')[0].reset();
                    $('#content').animate({height: "160px"}, 600);
                });
                
                
                $('#contatoEndereco').click(function () {
                    //                    $('.contatoTelefonico').hide(300);
                    //                    $('.contatoForm').hide(300);
                    $('#contato').animate({height: '550px'}, 600);
                    $('#contato .outer').animate({height: '550px'}, 600);
                    $('#map').slideDown('slow', function() {
                        google.maps.event.trigger(map, 'resize');
                        map.setZoom( map.getZoom() );
                        map.setCenter(center);
                    });
                    $('#fechar').fadeIn(1000);
                
                });
                
                $('#fechar').click(function() {
                    $('#fechar').fadeOut(600);
                    $('#map').hide('slow');
                    $('#contato').animate({height: '400px'}, 600);
                    $('#contato .outer').animate({height: '400px'}, 600);
                });
                
                $('#contatoForm').click( function () {
                    if ($('#formSend').css('display') == 'none'){
                        $('#formSend').show(800); 
                    }
                });
                
                $('#cancelarContato').click( function () {
                    $('#form3')[0].reset();
                    $('#formSend').hide(600);
                });
                
                        
                $('#btCancelarCadastrarMedico').click(function() {
                    $('#form2').fadeOut(300, function() {
                        $('#doctors').hide();
                        $('#clientes').hide();
                        $('#exames').animate({height: "200px"});
                        $('#content').animate({height: "200px"});
                        $('#logon').fadeIn(300);
                    });
                });
                
                $('#btCancelarCadastrarPaciente').click( function() {
                    $('#form1').fadeOut(300, function () {
                        $('#doctors').hide();
                        $('#clientes').hide();
                        $('#exames').animate({height: "200px"});
                        $('#content').animate({height: "200px"});
                        $('#logon').fadeIn(300);
                    });
                            
                });
                //
            });
            
            function preencheExames(e) {
                if (e != ""){
                    var str = "";
                    
                    $("#select_exame option:selected").each(function () {
                        str = $(this).text() + " ";
                    })
                    
                    $('#txtarea').append("<div class='bt_cancel' id='" + e + "' name='exames' onclick='excluiExame(this.id)'><input type='hidden' name='files[]' id='files[]' value='"+e+"' /><img src='images/cancel.png' /><span name='" + e + "'> " + str + "</span></div>");
                }
            }
            
            $("#select_exame").click(function () {
                $('#select_exame').show('slow');
            });
            
            $("#teste").click(function () {
                $('#slider').hide('slow');
            });
            
            
            
            function esconder(e){
                $('#' + e).hide('slow');
            }
            
            function resize (){

                // reduz a largura e altura da imagem
                $('#menu').animate({height: "30px"}, 600);
            }
            
            function fadein(e){
                $('#' + e).hide(300);
            }
            
            function fadeout(e){
                $('#' + e).hide(300);
            }
            
            
            function mostrar(e){
                
                if (e == 'exames'){
                    
                    
                    if (<%=logado%>){
                        //                        alert('logado');
                        $('#quem-somos').hide();
                        $('#convenios').hide();
                        $('#contato').hide();
                        $('#equipe').hide();
                        $('#logon').hide();
                        $('#form1').hide();
                        $('#logon2').show();
                        $('#exames').show('slow');
                        $('#exames').animate({height: "250px"});
                        $('#content').animate({height: "250px"});
                    } else {
                        //                        alert('não logado');
                        $('#quem-somos').hide();
                        $('#convenios').hide();
                        $('#contato').hide();
                        $('#equipe').hide();
                        $('#logon2').hide();
                        $('#form1').hide();
                        $('#logon').show();
                        $('#exames').show('slow');
                        $('#exames').animate({height: "200px"});
                        $('#content').animate({height: "200px"});
                    }
                } else if (e == 'quem-somos') {
                    $('#exames').hide('slow');
                    $('#convenios').hide('slow');
                    $('#contato').hide('slow');
                    $('#equipe').hide('slow');
                    $('#quem-somos').show('slow');
                } else if (e == '') {
                    $('#quem-somos').hide('slow');
                    $('#exames').hide('slow');
                    $('#contato').hide('slow');
                    $('#convenios').hide('slow');
                    $('#equipe').hide('slow');
                } else if (e == 'convenios') {
                    $('#quem-somos').hide('slow');
                    $('#exames').hide('slow');
                    $('#contato').hide('slow');
                    $('#equipe').hide('slow');
                    $('#convenios').show('slow');
                } else if (e == 'contato') {
                    $('#quem-somos').hide('slow');
                    $('#exames').hide('slow');
                    $('#convenios').hide('slow');
                    $('#equipe').hide('slow');
                    $('#contato').show('slow');
                } else if (e == 'equipe') {
                    $('#quem-somos').hide('slow');
                    $('#exames').hide('slow');
                    $('#convenios').hide('slow');
                    $('#contato').hide('slow');
                    $('#equipe').show('slow');
                }
                //                resize();
                
            }
            
            function excluiExame(e) {
                $('#' + e).remove();
            }
            
            function mostra(){
                $('#form1')[0].reset();
                $('#form2')[0].reset();
                $('#thx').remove();
                $("#novo").remove();
                $("#logon").show('slow');
                $('#exames').animate({height: "200px"});
                $('#content').animate({height: "200px"});
            }
        </script>

    </head>
    <body>

        <div class="banner">
            <img src="images/back.jpg" class="reflect rheight80 ropacity25" alt=""/>
        </div>

        <!-- TOPO -->
        <div class="container_12 topo">

            <div id="usuarioLogado">
                <%
                    if (logado) {
                        String nome = (String) session.getAttribute("nome");
                        out.print("Bem vindo(a) " + nome + ".&nbsp;&nbsp;&nbsp;<a id='fimSessao' href='index.jsp?act=logout'>Finalizar sessão</a>");
                    } else {
                        out.print("Usuário não logado");
                    }
                %>
            </div>

            <div class="logo">
                <a href="index.jsp" />
                <img src="images/logo.png" />
            </div>



            <div class="logar dir roundBordersP">

                <p id="logarP">Acesse aqui o resultado<br />do seu exame</p>
                <a href="javascript:void(0)" id="logar">
                    <img src="images/entrar_bt.png"/>
                </a>
                <%@include file="../templates/exame_online.jsp" %>
            </div>

            <div class="jimgMenu" id="menu" style="padding-bottom: 120px">
                <ul>
                    <li id="teste" class="landscapes" onclick="mostrar('')" ><a href="#"><img src="images/landscapes.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                    <li class="people" onclick="mostrar('equipe')"><a href="#"><img src="images/equipe.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                    <li class="nature" onclick="mostrar('exames')"><a href="#"><img src="images/exame.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                    <li class="abstract" onclick="mostrar('quem-somos')"><a href="#"><img src="images/whoarewe.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                    <li class="abstract" onclick="mostrar('convenios')"><a href="#"><img src="images/convenios.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                    <li class="urban" onclick="mostrar('contato')"><a href="#"><img src="images/fale-conosco.jpg" class="reflect rheight60 ropacity25" alt="" style="height: 200px"/></a></li>
                </ul>
            </div>

            <div class="grid_12">

                <div class="clear"></div>	

            </div>

            <div class="clear"></div>

        </div>

        <!-- CONTEUDO -->
        <div class="conteudoContainer">

            <div id="conteudo">

                <div class="container_12">

                    <div class="grid_12">
