<p align="center">
  <a href="" rel="noopener">
 <img width=450px height=250px src="https://i.ytimg.com/vi/WdT90ffB-0Q/maxresdefault.jpg#vitrinedev" alt="Project logo"></a>
</p>

<h3 align="center">PROJETO DE IMERSÃO EM JAVA</h3>

<div align="center">

[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-green)]()

</div>

---

<p align="center"> Projeto iniciado na imersão, com o intuito de conhecer outras ferramentas, bibliotecas e técnicas para aprimorar o meu conhecimento no desenvolvimento WEB com Java.
<br> 
</p>


## 📝 Sumário

- [Sobre](#sobre)
- [Começando](#comecando)
- [Execução](#execucao)
- [Saída](#saida)
- [Desenvolvimento](#desenvolvimento)
- [Ferramentas](#ferramentas)
- [Colaboradores](#colaboradores)
- [Agradecimento](#agradecimento)


## 🧐 Sobre <a name = "sobre"></a>

Código a ser desenvolvido ao longo dessa imersão, aplicando o meu conhecimento em Java.


## 🏁 Começando <a name = "comecando"></a>

Necessário conhecimento básico da linguagem Java. Faz uso da JDK 17, podendo ser alterado para qualquer versão, mas atenção, nesse cenário haverá alta possibilidade de quebra, corrija os erros na refatoração. Veja a seção de [Desenvolvimento](#desenvolvimento) para saber o que vem por aí.

### Pre-requisitos

Verifique a versão do Java, que está instalado na sua máquina com o seguinte comando:

```
java --version
```

### Instalação

Caso não tenha instalado, ou precise atualizar para uma versão mais recente, existe muitos tutoriais na internet que ajudam a fazer isso, de acordo com seu sistema operacional. Caso tenha dificuldade, só enviar um email, ou mensagem no Discord, que tentarei ajudar.


## 🚀 Execução <a name = "execucao"></a>

Faça os seguintes passos:

### Compilando e empacotando o projeto para gerar o arquivo _JAR_ :

```
mvn clean package
```


## 🎈 Saída <a name="saida"></a>

Exemplos da saída atual:

![Geração personalizada de Stickers da API do IMDB](https://raw.githubusercontent.com/bcbrito/sticker-generator/main/data/image/readme/Aula2comDesafios.png)

![Geração de Sticker da Api da MARVEL](https://raw.githubusercontent.com/bcbrito/sticker-generator/main/data/image/readme/Aula3comDesafios.png)

## 🔧 Desenvolvimento <a name = "desenvolvimento"></a>

Conteúdo a partir da Aula 03 e refatorações para Aula 04:
- [x] Reestruturação do projeto para consumir a Api da MARVEL.
- [x] Sobrescrita do método de saída no terminal com informações da nova Api;
- [x] Sobrescrita do método de geração de Stickers para imagens da nova Api;
- [x] Uso de uma classe de exceção personalizado;
- [x] Automatizar a criação da instância da interface <strong>StickerApi</strong> de acordo com o _endpoint_ a ser consumido;
- [x] Upgrade da JDK do projeto, versão 17, para implementar casos de uso com classes <strong>Record</strong>;
- [x] Uso de uma classe abstrata, para separar os métodos relacionados aos dados, oriundos do consumo das Apis;
- [x] Adição de campo imagem e campos para cálculo de pontuação no modelo utilizado em uma terceira Api, desenvolvida em um Challenge de Back-end na Alura, para ser utilizada como um microsserviço: [Spring Boot API](https://github.com/bcbrito/bcbrito-challenge-spring-api)
- [x] Implementação para consumo da Api Alura Challenge em localhost;
- [x] Criação de classes de testes;
- [ ] Implementar testes para cada api que será consumida
- [x] Refatorações com base no SOLID e Design Pattern; 



## ⛏️ Ferramentas <a name = "ferramentas"></a>

- [Java](https://www.oracle.com/java/technologies/downloads/#java17) - Java JDK
- [Maven](https://maven.apache.org/download.cgi) - Apache Maven Project
- [Lombok](https://projectlombok.org/setup/eclipse) - Lombok para gerar o getters e setters automáticos :)


## ✍️ Colaboradores <a name = "colaboradores"></a>

- [@bcbrito](https://github.com/bcbrito/) - Trabalho inicial


## 🎉 Agradecimento <a name = "agradecimento"></a>

- A todos que participam e ajudaram a tirar do papel essa imersão
