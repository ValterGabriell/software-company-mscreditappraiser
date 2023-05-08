<h1 align="center">Microserviços de avaliação de créditos dos clientes - Empresa de Software</h1>
<p align="center"><i>Repositório responsável avaliar quanto crédito será disponibilizado para um usuário e enviar essa requisição para a fila no RabbitMQ.</i></p>

##  Sobre esse projeto
Este é um projeto que deve ser rodado após o Eureka Server estar rodando, para que se registre no discovery server.


## Indíce
<!--ts-->
   * [Como usar?](#como-usar)
   * [Endpoints](#endpoints)
   * [Creditos](#creditos)
<!--te-->
  
<h1>Como usar?</h1>
<p>O Eureka Server deve estar rodando, acesse-o <a href="https://github.com/ValterGabriell/bank-system-eureka-server">aqui</a>.</br>
<p>Clone ou baixe o repositório e start ele através de sua IDE de preferência rodando o método main da classe principal na pasta raíz da aplicação, feito isso, basta começar a usar :). O ideal é startar todos os outros microserviços antes de testar a aplicação.</p>
<p>Além disso, é fundamental ter um container do RabbitMQ no Docker rodando com usuario e senha padrao (guest, guest) para o microserviço poder enviar o código para a fila.</p>

1 -> <a href="https://github.com/ValterGabriell/bank-system-eureka-server">Eureka Server</a></br>
2 -> <a href="https://github.com/ValterGabriell/bank-system-mscards">Microserviço responsável por criar cartões para os usuários</a></br>
3 -> <a href="https://github.com/ValterGabriell/bank-system-msaccount">Microserviço responsável por criar contas dos usuários</a></br>
4 -> <a href="https://github.com/ValterGabriell/software-company-mslead">Microserviço responsável pela criação dos líderes das squads</a></br>
5 -> <a href="https://github.com/ValterGabriell/software-company-mscolaborators">Microserviço responsável pela criação dos colaboradores das squads</a></br>
6 -> <a href="https://github.com/ValterGabriell/bank-system-gateway">Gateway para fazer o loadbalancer dos microserviços</a></br>
7 -> <a href="https://github.com/ValterGabriell/software-company-msjobs">Microserviço responsável pela criação dos trabalhos dos colaboradores</a></br>

  
<h1>Endpoints</h1>
<h3>BASE URL</h3>

```bash
http://localhost:8080/credit
``` 
<h1>POST</h1></br>

<h2>Criar conta</h2>

<table>
  <tr>
    <th>Request</th>
    <th>Response</th>
    <th>Query</th>
    <th>Restrições</th>
    <th>URL</th>
  </tr>
  <tr>
    <td>/request</td>
    <td>requisitar cartão</td>
    <td>cpf do cliente</td>
    <td>Um limite precisa ser definido antes (chegar métodos GET)</td>
    <td>http://localhost:9090/credit/request?cpf=cpfCliente</td>
    
  </tr>
</table>
<h3>Resposta esperada</h3></br>

```bash
{
	"protocolValue": "6b4bfe45-ec55-4d48-9998-6aa5d777bd0b",
	"cpf": "22324671912",
	"limitApproved": 2925.00
}
```

<h1>GET</h1></br>


<h2>Definir um limite para um cliente</h2>
<table>
  <tr>
    <th>Request</th>
    <th>Response</th>
    <th>Query</th>
  </tr>
  <tr>
    <td>/limit</td>
    <td>Seta um limite para o cliente</td>
    <td>id</td>
  </tr>
</table>



<h3>Resposta esperada</h3></br>

```bash
1400.000
```

</br>
<h2>Recuperar dados do cliente</h2>
<table>
  <tr>
    <th>Request</th>
    <th>Response</th>
    <th>Query</th>
  </tr>
  <tr>
    <td>/account-data</td>
    <td>Recupera dados do cliente ao conversar com o microserviço de conta de cliente.</td>
    <td>id</td>
  </tr>
</table>



<h3>Resposta esperada</h3></br>

```bash
{
	"cpf": "22324671912",
	"birthDate": "2005-06-25",
	"accountDate": "2023-04-10",
	"clientName": "nome teste",
	"clientPhoneNumber": "5589541222659",
	"clientEmail": "email@gmail.com",
	"gender": "FEMALE",
	"password": "12345",
	"income": 6500.00
}
```

<h1>Testes</h1>
```
 @Test
    void itShouldReturnDifferenceBetweenYears() {
        int year = LocalDate.of(2022, 04, 03).getYear();
        int currentYeat = LocalDate.now().getYear();
        int total = currentYeat - year;
        assertEquals(1, total);
    }
    
```

<h1>Créditos</h1>

---

<a href="https://www.linkedin.com/in/valter-gabriel">
  <img style="border-radius: 50%;" src="https://user-images.githubusercontent.com/63808405/171045850-84caf881-ee10-4782-9016-ea1682c4731d.jpeg" width="100px;" alt=""/>
  <br />
  <sub><b>Valter Gabriel</b></sub></a> <a href="https://www.linkedin.com/in/valter-gabriel" title="Linkedin">🚀</ a>
 
Made by Valter Gabriel 👋🏽 Get in touch!

[![Linkedin Badge](https://img.shields.io/badge/-Gabriel-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/valter-gabriel/ )](https://www.linkedin.com/in/valter-gabriel/)

