<div class="loginBox" id="loginBox">

    <form style="z-index: 11000;">
        <label for="tipoAcesso" style="margin-bottom: 0px;">Selecione o tipo do acesso</label>
        <select class="tipoAcesso" id="tipoAcesso">
            <option value="1">Paciente</option>
            <option value="2">Médico</option>
        </select><br />
        
        <label for="field" id="protocoloCrm">Protocolo</label>
        <input type="text" id="field" value="" class="roundBordersP"/>
        
        <label for="senha">Senha</label>
        <input type="password" id="senha" value="" class="roundBordersP"/>
        
        <div class="clear"></div>

        <div id="btOkExame" class="roundBordersP">
            <p id="btOkp">OK</p>
        </div>
<!--        <input type="submit" value="OK" class="dir">-->

    </form>

</div>