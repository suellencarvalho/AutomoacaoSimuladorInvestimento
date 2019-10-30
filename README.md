


História:
Com o propósito de Simular um Investimento na Poupança
como um Associado,
eu gostaria de preencher o formulário de simulaçãoS
e ver a tabela de resultado com Mês e Valor.

Critério de aceitação:

O associado preencher todos os campos corretamente e visualizar o formulário de simulação
O associado preencher o valor inferior a “R$ 20.00” e receber a mensagem de orientação “Valor mínimo de R$ 20.00”.

Cenários de teste:

CT-1:	

Cenário: Validar seleção do radio-button de pessoa física
Dado: que foram informados campos com valores válidos
Quando: clicar no botão simular 
Então: o sistema exibe o resultado da simulação com mês e valor

CT-2:

Cenário: Validar seleção do radio-button de pessoa jurídica
Dado: que foram informados campos com valores válidos
Quando: clicar no botão simular
Então: o sistema exibe o resultado da simulação com mês e valor

CT-3:

Cenário: validar campos de preenchimento obrigatórios
Dado: que não foram preenchidos os campos obrigatórios
Quando: clicar no botão simular 
Então: o sistema apresenta mensagem informativa e não simula o investimento

CT-4:

Cenário: validar valor inferior que 20.00
Dado: que foram informados nos campos de valor para investimento e valor a Aplicar um valor inferior a R$ 20.00
Quando: clicar no botão simular
Então: o sistema exibe a mensagem "Valor mínimo de R$ 20.00" e não simula o investimento

CT-5:

Cenário: validar tabela com resultado da simulação com o período meses
Dado: que o campo período seja informado com menos de 12 meses e os demais campos com dados válidos
Quando: clicar no botão simular
Então: o sistema exibe o resultado da simulação com mês e valor.
E: Deve apresentar tabela com 4 opções além da escolhida pelo usuário.

CT-6:

Cenário: validar tabela com resultado da simulação com o período anos
Dado: que o campo período seja informado com anos e os demais campos com dados válidos
Quando: clicar no botão simular
Então: o sistema exibe o resultado da simulação com mês e valor.
E: Deve apresentar tabela com 4 opções além da escolhida pelo usuário.

CT-7:

Cenário: Validar link de limpar formulário
Dado: que os campos estejam preenchidos
Quando: clicar na opção Limpar formulário
Então: o sistema limpa os dados preenchidos
E: A tela volta ao seu estado inicial.

CT-8:

Cenário: Validar limite campo valor Aplicar e valor Investir
Dado: sejam informados os campos com valores acima do esperado
Quando: preencher o formulário
Então: o campo apresenta mensagem "Máximo de 9999999.00"
E: Não permite simulação.

CT-9:

Cenário: Validar limite para período meses
Dado: sejam informados o campo período com valores acima do esperado
Quando: preencher o formulário com a opção meses selecionada
Então: o campo permite a inclusão de até 3 dígitos
E: permite a simulação.

CT-10:

Cenário: Validar limite para período anos
Dado: sejam informados o campo período com valores acima do esperado
Quando: preencher o formulário com valor 999 e com a opção anos selecionada
Então: O sistema apresenta mensagem "Valor esperado não confere"
E: Não permite a simulação.
 
CT-11:

Cenário: Validar botão Refazer simulação
Dado: que após realizar simulção desejo clicar no botão Refazer Simulação
Quando: estiver na tela de resultados
Então: o sistema retorna para a tela de simulação em seu estado inicial.


A classe de teste "testApi" realiza uma validação básica via Rest Assured na API Rest.

Também foi realizado teste utilizando SoapUI, o arquivo xml exportado está presente na pasta Resource (src>main>Resouce).

O mapeamento da página foi realizado utilizando o padrão PageObject com a inteção de reduzir o acoplamento entre os casos de teste e a aplicação, onde temos uma mehor organização, leitura e manutenção do código.


Utilizado o Selenium WebDriver , o mesmo faz chamadas diretamente ao navegador, deixando os testes escritos com o WebDriver mais realistas, pois ele chama os elementos a serem testados diretamente do navegador.
