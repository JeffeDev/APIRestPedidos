<div align="center">
  <h1>API Pedidos</h1>
  <p>
	  API desenvolvida  para enviar e receber dados de um app🤿 ☕ <br>
	  Desenvolvido com 💙 por Jefferson Cesar de Souza.<br>
	  Como Portifólio em meu Git
  </p>
</div>

## ⚙️ Funcionalidades 

- GET de 	/cliente 
			/pedido
			/produto 
	

- POST de 	/cliente 
			/pedido 
			/produto 

- PATCH 
* /cliente/{id} 
		update altera tabela de clientes
	
* /pedido/{id}
 		update altera tabela de pedido-de-venda
 		
 * /produto/{id}
 		update altera tabela de produto e produto-imagem
  		
 		
		
- DELETE de 	/cliente/id
 				/pedido/id 
 				/produto/id 



## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot Web, Spring Web
>> Banco de dados MongoDb

- App será feito em TotalCross Java 8

>> Banco de Dados local ( ainda estou decidindo )



## 🖥️ Endpoints

#### @Document(collection = "cliente")
````
	@Id
	private String id;
	
	private String nome;
	private String tipoPessoa="FISICA";
	private String telefone;
	private String email;
	private String documento; //cpf ou cnpj

````

#### GET cliente e POST cliente
````
https://localhost:8080/cliente

````

#### GET cliente e POST cliente Update
````
https://localhost:8080/cliente/{id}
````

#### DELETE Cliente e PATCH cliente-deletar
````
https://localhost:8080/cliente-deletar/{id}

localhost:8080/cliente-deletar/62e07002b69a2d785bbb443d

````


#### @Document(collection = "produto")
````
	@Id
	private String id;
	
	private String nome;
	private String image;
	private BigDecimal preco;

````

#### GET produto e POST produto
````
https://localhost:8080/produto
````

#### GET produto e POST produto Update

````
https://localhost:8080/produto/{id}
````

#### DELETE Produto e PATCH produto-deletar
````
https://localhost:8080/produto-deletar/{id}
````



#### @Document(collection = "pedido-de-venda")
````
	@Id
	private String id;
	
	private Long numeroPedido;
	private String cliente_id;
	private Date dataEmissao;
	private Date dataEntrega;
	private BigDecimal totalPedido;
	
	private String statusPedido="ABERTO";

````

#### GET pedido e POST pedido
````
https://localhost:8080/pedido
````

#### GET pedido e POST pedido Update
````
https://localhost:8080/pedido/{id}
````

#### DELETE Pedido e PATCH pedido-deletar
````
https://localhost:8080/pedido-deletar/{id}
````



#### @Document(collection = "pedido-itens")
````
	@Id
	private String id;
	
	private String produto_id;
	private String pedido_id;
	
	private Integer sequencia;
	private BigDecimal quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal desconto;
	private BigDecimal totalItem;

````



#### GET itenspedido e POST itenspedido
````
https://localhost:8080/itenspedido
````

#### GET itenspedido e POST itenspedido Update
````
https://localhost:8080/itenspedido/{id}
````

#### DELETE itenspedido e PATCH itenspedido-deletar
````
https://localhost:8080/itenspedido-deletar/{id}
````



## 📒 Conteúdos  

**BackEnd**: [Consumir API cliente, produto, pedido e itenspedido e exibir dados criar um gerador de imagens para os produtos](https://github.com/JeffeDev)

**FrontEnd**: construir um APP para ler e enviar dados via Rest para o Back, utilizando ferramentas TotalCross com Spring Framework e um banco de dados NoSQL.




## 🎯 O que o projeto faz:
  - [X] CRUD (Create, Read, Update e Delete) para se poder atualizar e excluir 
  		um cliente, produto, pedido, itenspedido cadastrados;



## 📸 Screenshots
####  📌 Back-End e Front-End 
aplicação back-end usando as tecnologias Java com Spring;
aplicação mobile usando a tecnologia TotalCross;

O Modelo ER deve ser disponibilizado também no projeto do Github, 
como arquivo original da ferramenta de modelagem utilizada e também como imagem/pdf;

Deve seguir os princípios de clean code e TDD;
Deve utilizar o Maven para gerenciar as dependências;
Deve utilizar o formato JSON para integração entre as aplicações.


## ❔ Dúvidas?!
Se tiver alguma dúvida sobre este repositório, envie para jeffe.info@gmail.com




