<p align="center">
  <a href="" rel="noopener">
 <img width=450px height=250px src="https://raw.githubusercontent.com/bcbrito/sticker-generator/main/data/image/readme/Capa.png" alt="Project logo"></a>
</p>

<h3 align="center">Projeto de imersão em JAVA - Gerador de Stickers</h3>

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

Conteúdo:
- [x] Reestruturação do projeto para consumir a Api da MARVEL.
- [x] Sobrescrita do método de saída no terminal com informações da nova Api;
- [x] Sobrescrita do método de geração de Stickers para imagens da nova Api;
- [x] Uso de uma classe de exceção personalizado;
- [x] Automatizar a criação da instância da interface <strong>StickerApi</strong> de acordo com o _endpoint_ a ser consumido;
- [x] Upgrade da JDK do projeto, versão 17, para implementar casos de uso com classes <strong>Record</strong>;
- [x] Uso de uma classe abstrata para o extrator, para separar os métodos relacionados aos dados, oriundos do consumo das Apis;
- [x] Criação de classes de testes;
- [x] Refatorações com base no SOLID e Design Pattern; 
- [x] Implementado mínimo de classificação para mandar apenas os que eu quero para Patricia
- [x] Criar CRUD para realizar o cadastro de novas linguagens
- [ ] Implementar testes para cada api que será consumida
- [ ] Criar api para listar as linguagens de programação topzeiras e gerar os stickers




## ⛏️ Ferramentas <a name = "ferramentas"></a>

- [Java](https://www.oracle.com/java/technologies/downloads/#java17) - Java JDK
- [Maven](https://maven.apache.org/download.cgi) - Apache Maven Project
- [Lombok](https://projectlombok.org/setup/eclipse) - Lombok para gerar o getters e setters automáticos :)


## ✍️ Colaboradores <a name = "colaboradores"></a>

- [@bcbrito](https://github.com/bcbrito/) - Trabalho inicial


## 🎉 Agradecimento <a name = "agradecimento"></a>

- A todos que participam e ajudaram a tirar do papel essa imersão
