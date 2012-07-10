<div id="exames" >
    <div id="clientes">
        <div class="innerClientes"></div>
        Pacientes
    </div>
    <div id="doctors">
        <div class="innerDoctors"></div>
        Médicos
    </div>
    <div id="content">
    </div>

    <form class="logon" id="logon" action="LoginCliente" method="POST">

        <fieldset id="loginFieldSet" style="float: left" >
            <legend>Login</legend>
            <p id="pLogin" style="margin-left: 30px; padding-bottom: 20px;">Para agendar exames, você precisa estar logado ou cadastrar-se.</p>
            <label for="usuarioCliente" style="margin-left: 30px;">Usuário</label>
            <input type="text" name="usuarioCliente" id="usuarioCliente" style="margin-left: 10px;"/><br /><br />

            <label for="senhaCliente" style="margin-left: 30px;">Senha</label>
            <input type="text" name="senhaCliente" id="senhaCliente" style="margin-left: 19px;"/>

            <div id="btLogin" onclick="document.getElementById('logon').submit()">
                <p>Entrar</p>
            </div>
        </fieldset>
        <div id="divisoriaLogin" style="border-right-width: 1px;border-right-color: #0e7709; border-right-style: dotted;  width: 5px; height: 200px; margin-left: 600px;">
            <div id="semCadastro" style="text-align: center; margin-left: 50px; width: 200px; margin-top:80px;position: absolute">
                Não é cadastrado? <br /><a href="#" style="text-decoration: none; color: #0e7709; font-weight: bold" id="btCadastrar">Clique aqui e cadastre-se.</a>
            </div>

        </div>
    </form>

    <form class="logon2" id="logon2" action="" method="POST">

        <fieldset id="loginFieldSet" style="float: left" >
            <legend>Agendamento de Exames</legend>
            <!--            <p id="pLogin" style="margin-left: 30px; padding-bottom: 20px;">Agende aqui seus exames de forma prática e segura.</p>-->
            <div id="exame_select">
                <label for="select_exame" style="padding-bottom: 5px;">Selecione os exames</label><br />
                <select onchange="preencheExames(this.value)" id="select_exame" name="select_exame">
                    <option value="">Selecione</option>
                    <option value="1">Hemograma</option>
                    <option value="2">Urina</option>
                    <option value="3">Fezes</option>
                    <option value="4">Imunológica completa</option>

                </select><br /><br />
                <div id="txtarea">
                </div> <br />
            </div>            

            <label for="dataExame" style="margin-left: 40px; float: left">Data</label>
            <input type="text" name="dataExame" id="dataExame" style="margin-left: 40px;"/><br /><br />

            <label for="crmMedico" style="margin-left: 40px; float: left">CRM do Médico</label>
            <input type="text" name="crmMedico" id="crmMedico" style="margin-left: 40px;"/><br /><br />

            <div id="divisoriaLogin2" style="border-right-width: 1px;border-right-color: #0e7709; border-right-style: dotted;  width: 5px; height: 250px; float: right; margin-right: -60px; margin-top: -180px;">
                <div id="semCadastro2" style="text-align: center; margin-left: 50px; width: 200px; margin-top:80px;position: absolute">
                    <p style="color: #0e7709; font-size: 18px; text-align: center ">Após o agendamento, um de nossos colaboradores entrará em contato para confirmar a coleta.</p>
                </div>

            </div>

            <div id="btLogin2" onclick="submeterExame()">
                <p>Agendar</p>
            </div>
        </fieldset>
    </form>

    <form class="formPacientes" id="form1" action="javascript:void" method="POST">

        <div id="status" style="display: none; position: absolute; margin-top: 200px; margin-left: 400px;">
            <img src='images/load.gif' alt='Enviando' />
        </div>

        <span style="margin-top: -20px;">Para agendar exames, você precisa estar logado ou cadastrar-se.</span>
        <br />
        <fieldset>
        </fieldset>

        <div class="innerExame">

            <label for="nomePaciente">Nome completo</label>
            <input type="text" name="nomePaciente" id="nomePaciente" style="margin-left: 2px;"/>

            <span style="margin-left: 15px; font-size: 12px">Sexo</span>
            <span style="margin-left: 35px; font-size: 12px">Masculino<input type="radio" name="sexo" id="sex" value="M"/></span>
            <span style="font-size: 12px; margin-left: 15px">Feminino<input type="radio" name="sexo" id="sex" value="F"/></span><br /><br />

            <label for="enderecoPaciente" >Endereço</label>
            <input type="text" name="enderecoPaciente" id="enderecoPaciente" style="margin-left: 37px;"/>

            <label for="bairroPaciente" style="margin-left: 15px;">Bairro</label>
            <input type="text" name="bairroPaciente" id="bairroPaciente" style="margin-left: 28px;"/><br /><br />

            <label for="cidadePaciente">Cidade</label>
            <input type="text" name="cidadePaciente" id="cidadePaciente" style="margin-left: 52px;"/>

            <label for="estadoPaciente" style="margin-left: 15px;">Estado</label>
            <input type="text" name="estadoPaciente" id="estadoPaciente" style="margin-left: 24px;"/><br /><br />

            <label for="telefone1Paciente">Telefone</label>
            <input type="text" name="telefone1Paciente" id="telefone1Paciente" style="margin-left: 42px;"/>

            <label for="emailPaciente" style="margin-left: 15px;">Email</label>
            <input type="text" name="emailPaciente" id="emailPaciente" style="margin-left: 33px;"/><br /><br />

            <label for="usuarioPaciente">Usuário</label>
            <input type="text" name="usuarioPaciente" id="usuarioPaciente" style="margin-left: 45px;"/>

            <label for="senhaPaciente" style="margin-left: 15px;">Senha</label>
            <input type="text" name="senhaPaciente" id="senhaPaciente" style="margin-left: 30px;"/>


            <!--            <input type="submit" value="Cadastrar"/>-->
            <div id="btCadastrarPaciente" onclick="submeter()"><p>Cadastrar</p></div>
            <div id="btCancelarCadastrarPaciente"><p>Cancelar</p></div>
        </div>
    </form>

    <form class="formDoctors" id="form2" action="#" method="POST">

        <span style="margin-top: -20px;">Cadastre-se para acessar os exames de seus pacientes</span>
        <br />
        <fieldset>
        </fieldset>

        <div class="innerExame">

            <label for="nomeMedico">Nome completo</label>
            <input type="text" name="nomeMedico" id="nomeMedico" style="margin-left: 2px;"/>

            <label for="crmMedico" style="margin-left: 15px;">CRM</label>
            <input type="text" name="crmMedico" id="crmMedico" style="margin-left: 25px;"/><br /><br />

            <label for="emailMedico">Email</label>
            <input type="text" name="emailMedico" id="emailMedico" style="margin-left: 59px;"/>

            <label for="telefoneMedico" style="margin-left: 15px;">Telefone</label>
            <input type="text" name="telefoneMedico" id="telefoneMedico" style="margin-left: 5px;"/>

            <input type="submit" value="CADASTRAR"/>
        </div>

    </form>
</div>

<div id="quem-somos">
    <div id="outer">
    </div>
    <p class="title">Quem somos</p>
    <fieldset>
    </fieldset>

    <p class="history">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales odio eget libero consectetur non posuere risus sollicitudin. Sed sed arcu purus. Curabitur dui justo, mollis non eleifend sed, viverra in lacus. Donec enim ligula, pellentesque ac luctus quis, faucibus nec ipsum. Donec quis ligula adipiscing mauris sollicitudin placerat. Aliquam porttitor porttitor iaculis. Nam at eros dui, at sollicitudin lorem.</p>
    <p class="history">Vivamus adipiscing vestibulum leo, viverra interdum ante varius et. Integer molestie, ante ut viverra semper, nibh turpis aliquet dolor, nec vehicula enim tellus nec ligula. Nulla lacus elit, facilisis vel malesuada vel, ultrices ut risus. Morbi aliquet placerat rutrum. Donec odio nibh, rutrum sit amet laoreet non, convallis in dolor. Quisque tincidunt hendrerit pulvinar. Duis sem justo, gravida at gravida et, pellentesque sed sapien. Sed et justo mauris. Quisque adipiscing aliquam elit. In adipiscing est nec metus cursus accumsan. Fusce ut orci nisl. Vestibulum eget magna est. Sed convallis ornare tortor, ut tempor elit aliquam quis. Aenean vitae enim nisi.</p>
</div>

<div id="convenios">
    <div class="outer">
    </div>

    <p class="title">Convênios</p>
    <fieldset></fieldset>
    <p class="history">Durante mais de 32 anos de história fizemos parcerias e amigos que duram até hoje. Muitos vieram e já foram, mas muitos persistem até hoje como parceiros em nosso negócio.</p>

    <p class="history">Veja alguns dos <b>convênios atendidos</b> em nosso laboratório:</p><br />
    <div style="float: left;padding-right: 70px; padding-bottom: 20px;">
        <ul class="firsList">
            <li>AMIL</li>
            <li>BANESCAIXA</li>
            <li>CASSI</li>
            <li>CESAN</li>
            <li>CORREIOS</li>
            <li>CODESA</li>
            <li>CVRD</li>
        </ul>
    </div>
    <div style="float: left;padding-right: 70px">
        <ul>
            <li>GAMA</li>
            <li>GEAP</li>
            <li>GOLDEN CROSS</li>
            <li>MEDSERVICE</li>
            <li>MEDIAL SAÚDE</li>
            <li>SAÚDE CAIXA</li>
            <li>PHS</li>
        </ul>
    </div>
    <div style="float: left;padding-right: 70px">
        <ul>
            <li>SAMES / SAMP</li>
            <li>SÃO BERNARDO</li>
            <li>SAUDE BRADESCO</li>
            <li>SULAMERICA</li>
            <li>UNIBANCO</li>
            <li>UNIMED</li>
            <li>VIX SAÚDE (APENAS PREVENTIVO)</li>
        </ul>
    </div>
</div>

<div id="contato">
    <div class="outer"></div>

    <p class="title">Contato</p>
    <fieldset></fieldset>

    <p class="history">
        Aqui na área de contato da Pró-Fórmula você conta com dois canais de atendimento. Escolha o que for mais conveniente pra você.
    </p>

    <div id="contatoTelefonico">
        <img src="images/contact.png" />
        <p><b>Telefones para contato:</b><br /><br />
            (67) 3340-3321<br />
            (67) 3340-3321<br /><br />
            <b>Horário de atendimento:</b><br /><br />
            De segunda a sexta-feira<br /> de <b>08:00h</b> as <b>17:30h.</b><br />
            Sábado de <b>08:00h</b> as <b>12:00h</b></p>
    </div>
    <!--    <div class="clear"></div>-->

    <div id="contatoEndereco">
        <img src="images/map.png" />
        <p>Não sabe onde nos achar? Não se preocupe. Clique aqui e conheça nossa localização.</p>
        <div id="map"></div>

    </div>
    <div id="fechar"><p>Fechar</p></div>

    <div id="contatoForm">
        <img src="images/message.png" />
        <p>Se preferir, deixe-nos uma mensagem com suas dúvidas, críticas ou elogios</p>
        <div id="formSend">

            <form id="form3">
                <div style="float: left">
                    <label for="nomeContato">Nome</label><br />
                    <input type="text" name="nomeContato" id="nomeContato" style="margin-left: 2px;margin-bottom: 5px"/><br />

                    <label for="emailContato">Email</label><br />
                    <input type="text" name="emailContato" id="emailContato" style="margin-left: 2px; margin-bottom: 5px"/><br />

                    <label>Assunto</label><br />
                    <select id="selectAssuntoContato">
                        <option value="">Selecione</option>
                        <option value="">Informações</option>
                        <option value="">Críticas</option>
                        <option value="">Elogios</option>
                    </select>
                </div>
                <div id="txtContato">
                    <label >Mensagem</label><br />
                    <textarea id="mensagemContato" name="mensagemContato" cols="39" rows="7"></textarea>
                </div>
                <div id="btGroupContato" >
                    <div id="enviarContato">
                        <p>Enviar</p>
                        <!--                        <img src="images/enviarContato.png" />-->
                    </div>
                    <div id="cancelarContato">
                        <p>Cancelar</p>
                        <!--                        <img src="images/cancelarContato.png" />-->
                    </div>
                    <!--                    <input type="submit" value="Enviar" style="width: 100px; margin-bottom: 20px"/><br />-->
                    <!--                    <input type="button" value="Cancelar" id="cancelar" style="width: 100px"/>-->
                </div>
            </form>
        </div>
    </div>
</div>

<div id="equipe">
    <div class="outer"></div>

    <p class="title">Nossa equipe</p>
    <fieldset></fieldset>

    <p class="overallEquipe">Nossa equipe é formada por profissionais comprometidos com a excelência nas realizações e focados nas necessidades de nossos clientes.

        Procuramos estar atentos aos mais sutis detalhes das publicações que produzimos (assim como a seus objetivos e aplicações) e às relações profissionais com nossos Clientes.

        Isso visa garantir a qualidade no serviço prestado e na relação de trabalho de toda a cadeia produtiva.</p>

    <div id="funcionario1" class="funcionarios">
        <img src="images/profile.png" />
        <p class="nomeEquipe">Dr Roberto Fulano da Silva</p>
        <p class="descricaoEquipe">In quis sapien nec tellus tincidunt fermentum ac ut urna. Suspendisse non accumsan mauris. 
            Phasellus sit amet sem eu purus tempus vehicula. Cras at nulla velit. Praesent consectetur 
            sapien, eget venenatis felis tempor et.</p>
    </div>

    <div class="clear"></div>

    <div id="funcionario2" class="funcionarios">
        <img src="images/profile.png" />
        <p class="nomeEquipe">Dra Ana Flávia dos Santos</p>
        <p class="descricaoEquipe">In quis sapien nec tellus tincidunt fermentum ac ut urna. Suspendisse non accumsan mauris. 
            Phasellus sit amet sem eu purus tempus vehicula. Cras at nulla velit. Praesent consectetur 
            sapien, eget venenatis felis tempor et.</p>
    </div>

    <div class="clear"></div>

    <div id="funcionario3" class="funcionarios">
        <img src="images/profile.png" />
        <p class="nomeEquipe">Dr Hugo Estavanato Moreira</p>
        <p class="descricaoEquipe">In quis sapien nec tellus tincidunt fermentum ac ut urna. Suspendisse non accumsan mauris. 
            Phasellus sit amet sem eu purus tempus vehicula. Cras at nulla velit. Praesent consectetur 
            sapien, eget venenatis felis tempor et.</p>
    </div>
</div>



