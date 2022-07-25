# APIRestPedidos
Produto Back-End para disponibilizar dados para um Aplicativo Mobile e armazenar os pedidos de vendas recebidos do App

HIS-01 – Desenvolver uma aplicação back-end em Java com Spring

# HISTÓRIA DE USUÁRIO
Como Administrador, em um servidor Web, eu preciso armazenar os dados de clientes e produtos para disponibilizar os mesmos para o aplicativo mobile e armazenar os pedidos de venda recebidos do aplicativo.

# CRITÉRIOS DE ACEITE
Deve armazenar as seguintes informações para o 
# cliente:
Código, Nome,
Tipo de Pessoa (Física/Jurídica),
CPF/CNPJ,
Telefone,
E-mail.


Deve armazenar as seguintes informações para o 
# produto:
Código,
Nome,
Preço


Deve armazenar as seguintes informações para o 
# pedido de venda:
Pedido:
Número do Pedido,
Cliente,
Data de Emissão,
Data de Entrega,
Total do Pedido,
Status do Pedido.
Item do Pedido:
Número Sequencial,
Produto,
Quantidade,
Preço Unitário,
Desconto,
Total do Item.


Deve exportar os clientes cadastrados para o aplicativo mobile via API Rest;
Deve exportar os produtos cadastrados para o aplicativo mobile via API Rest;
Deve receber os pedidos emitidos no aplicativo mobile via API Rest;


A aplicação deve estar coberta com testes unitários;
# Regras do pedido recebido do aplicativo mobile:
Verificar se total do pedido e igual ao somatório dos totais dos itens;
Verificar se desconto do item foi calculado corretamente (preço unitário X total do item)
Devem existir testes automatizados para as chamadas das APIs Rest utilizando JUnit e Spring Boot Test;
A aplicação deve rodar em um ambiente Docker;
A aplicação deve rodar em banco de dados SQL Server no Docker





# HIS-02 – Desenvolver um aplicativo mobile com TotalCross
HISTÓRIA DE USUÁRIO
Como Vendedor, no meu smartphone, eu preciso emitir pedidos de venda para os meus clientes de forma off-line para ter mais liberdade e poder fazer o meu trabalho sem depender de um notebook ou conexão com a internet.

# CRITÉRIOS DE ACEITE
Deve receber a lista dos clientes via consulta Rest ao aplicativo back-end;
Deve receber a lista dos produtos via consulta Rest ao aplicativo back-end;
Deve armazenar os dados de clientes e produtos em um banco local;
Deve permitir a emissão de pedidos de venda:
Deve ser informado um cliente para o pedido;
Deve ser gravada a data de emissão do pedido;
A data de entrega do pedido deve ser maior ou igual a data atual;
Deve haver ao menos um item no pedido de venda;
Não deve permitir a inserção de um item no pedido com valor igual a zero;
A soma do valor dos itens do pedido deve ser igual ao valor total do pedido;
Deve permitir salvar o pedido para ser continuado posteriormente;
Deve permitir fechar o pedido, para envio ao aplicativo back-end;
Deve exibir os pedido emitidos em uma lista;
Deve permitir continuar os pedido que não foram fechados;
Não deve permitir a edição de pedidos fechados ou já enviados;
A aplicação deve estar coberta com testes unitários;
Ex.: regras do pedido;
Deve enviar os pedidos de venda fechados para o aplicativo back-end via API Rest;
Pedidos já enviados não devem ser enviados novamente para o aplicativo back-end;


DÚVIDAS
Pontuar as dúvidas sobre a história de usuário, a serem esclarecidas com o Gestor de Produto (dúvidas em regras de negócio) ou Mentores (dúvidas técnicas) em uma agenda a ser marcada com ambas as pessoas.
