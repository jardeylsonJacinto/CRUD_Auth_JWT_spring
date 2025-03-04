# CRUD API com JWT

## Descrição

A **CRUD API com JWT** é uma aplicação RESTful construída com **Spring Boot** que implementa as operações básicas de **CRUD** (Criar, Ler, Atualizar, Excluir) para gerenciar registros de pessoas. Além disso, inclui **autenticação baseada em JWT** para garantir a segurança dos endpoints.

Este projeto serve como uma base sólida para aplicações que precisam de um sistema de autenticação seguro e permite operações de gerenciamento de dados através de uma API RESTful.

## Tecnologias

- **Spring Boot 3.x**: Framework utilizado para criar a aplicação backend.
- **JWT (JSON Web Tokens)**: Sistema para autenticação seguro.
- **Spring Security**: Para proteger os endpoints com controle de acesso.
- **Spring Data JPA**: Para facilitar o acesso ao banco de dados.
- **MySQL**: Banco de dados utilizado para armazenar os dados da aplicação.
- **Swagger/OpenAPI**: Para gerar a documentação interativa da API.
- **Lombok**: Para reduzir o código boilerplate e melhorar a legibilidade.

## Funcionalidades

### 1. Autenticação

- **POST /auth/register**: Registra um novo usuário no sistema.
- **POST /auth/login**: Realiza o login de um usuário e gera um token JWT para autenticação futura.

### 2. CRUD de Pessoas

- **GET /pessoas**: Retorna a lista de todas as pessoas cadastradas.
- **GET /pessoas/{id}**: Retorna os detalhes de uma pessoa específica pelo ID.
- **POST /pessoas**: Cria uma nova pessoa.
- **PUT /pessoas/{id}**: Atualiza os dados de uma pessoa existente.
- **DELETE /pessoas/{id}**: Deleta uma pessoa do sistema.

## Como Rodar a Aplicação

### 1. Clone o repositório

Clone o projeto para o seu ambiente local com o comando:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Configure as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto e adicione as seguintes variáveis:

```env
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
```

- **DB_USERNAME**: O nome de usuário do banco de dados MySQL.
- **DB_PASSWORD**: A senha para o banco de dados MySQL.
- **JWT_SECRET**: A chave secreta usada para gerar os tokens JWT.

### 3. Instale as dependências

Use o Maven para instalar as dependências do projeto:

```bash
./mvnw install
```

### 4. Rode a aplicação

Para rodar a aplicação localmente, utilize o seguinte comando:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada no endereço [http://localhost:8080](http://localhost:8080).

## Exemplos de Uso

### 1. Registrar um novo usuário

**Requisição:**

```bash
POST /auth/register
Content-Type: application/json

{
  "login": "usuario",
  "password": "senha123",
  "role": "ADMIN"
}
```

**Resposta:**

```json
{}
```

### 2. Realizar login

**Requisição:**

```bash
POST /auth/login
Content-Type: application/json

{
  "login": "usuario",
  "password": "senha123"
}
```

**Resposta:**

```json
{
  "token": "seu-jwt-token-aqui"
}
```

### 3. Criar uma pessoa

**Requisição:**

```bash
POST /pessoas
Authorization: Bearer seu-jwt-token-aqui
Content-Type: application/json

{
  "nome": "Luiza"
}
```

**Resposta:**

```json
{
  "id": 4,
  "nome": "Luiza"
}
```

### 4. Consultar todas as pessoas

**Requisição:**

```bash
GET /pessoas
Authorization: Bearer seu-jwt-token-aqui
```

**Resposta:**

```json
[
  {
    "id": 1,
    "nome": "João"
  },
  {
    "id": 2,
    "nome": "Maria"
  }
]
```

## Como Contribuir

1. Faça um **fork** deste repositório.
2. Crie uma nova branch para a sua funcionalidade (`git checkout -b feature/nova-funcionalidade`).
3. Faça suas alterações e adicione os commits (`git commit -am 'Adicionando nova funcionalidade'`).
4. Envie a branch para o seu repositório (`git push origin feature/nova-funcionalidade`).
5. Abra um **Pull Request** para a branch `main`.

## Documentação da API

A documentação da API gerada pelo **Swagger** pode ser acessada na URL [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Esse modelo de **README** inclui todos os pontos essenciais para um projeto no GitHub, como:

- **Título e descrição do projeto**;
- **Tecnologias utilizadas**;
- **Instruções para rodar a aplicação**;
- **Exemplos de uso da API**;
- **Como contribuir**;
- **Documentação gerada pelo Swagger**;
- **Licença do projeto**.

Fique à vontade para modificar ou expandir conforme necessário!
