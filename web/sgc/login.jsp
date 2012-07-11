<%-- 
    Document   : index
    Created on : Jun 11, 2012, 7:47:53 PM
    Author     : victor
--%>

<%@page import="br.com.self.sangao.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="/LaboratorioSangao/sgc/login.css">
    </head>
    <body>
        <div id="infosHolder">
			
		<div class="infos">
			Laboratório Sangão<br>
                        
			<span>Mato Grosso do Sul</span>
		</div>
		
		<div class="setaBox">
		</div>
		
		<div class="abaleft">
		</div>
		
			<div class="box">
				
				<!-- TITULO -->
				<div class="ambienteTitle">
				</div>
				<!-- // TITULO -->
				
				<div class="form">
					
					<form action="LoginServlet" method="post" class="ajax_form">
					
						<div style="padding-bottom:12px;">
							<input name="username" type="text" class="input login" id="username" >
						</div>
						<div style="padding-bottom:12px;">
							<input name="password" type="password" class="input senha" id="password">
						</div>
						<div class="botoes">
												
							<input type="reset" name="limpar" id="limpar" value="limpar" class="bt">
							<input type="submit" name="login" id="enviar" value="entrar" class="bt">
						</div>
						
						
					</form>			
					
				</div>
				
			</div>	
		
		<div class="abaright">
		</div>
	
	</div>
    </body>
</html>
