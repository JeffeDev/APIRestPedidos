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
			/produto-imagem

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

#### GET cliente e POST cliente
````
https://localhost:8080/cliente

{
    "timestamp": "2022-07-26T22:58:42.215+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "path": "/cliente"
}

````

#### GET cliente e POST cliente Update
````
https://localhost/cliente/{id}
````

#### DELETE Cliente e PATCH cliente-deletar
````
https://localhost:8080/cliente-deletar/{id}

localhost:8080/cliente-deletar/62e07002b69a2d785bbb443d

````



#### GET produto e POST produto
````
https://localhost/produto
````

#### GET produto e POST produto Update

````
https://localhost/produto/{id}
````

#### DELETE Produto e PATCH produto-deletar
````
https://localhost/produto-deletar/{id}
````



#### GET pedido e POST pedido
````
https://localhost/pedido
````

#### GET pedido e POST pedido Update
````
https://localhost/pedido/{id}
````

#### DELETE Pedido e PATCH pedido-deletar
````
https://localhost/pedido-deletar/{id}
````



#### GET itenspedido e POST itenspedido
````
https://localhost/itenspedido
````

#### GET itenspedido e POST itenspedido Update
````
https://localhost/itenspedido/{id}
````

#### DELETE itenspedido e PATCH itenspedido-deletar
````
https://localhost/itenspedido-deletar/{id}
````



## 📒 Conteúdos  

**BackEnd**: [Consumir API cliente, produto, pedido e itenspedido e exibir dados criar um gerador de imagens para os produtos](https://github.com/JeffeDev)

**FrontEnd**: construir um APP para ler e enviar dados via Rest para o Back, utilizando ferramentas TotalCross com Spring Framework e um banco de dados NoSQL.




## 🎯 O que o projeto bak-end faz:
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




