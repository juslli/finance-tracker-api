# 📌 Finance Tracker API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de usuários em um sistema de controle financeiro.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- Bean Validation  
- H2 Database  
- Maven  

---

## 📂 Estrutura do projeto
# 📌 Finance Tracker API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de usuários em um sistema de controle financeiro.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- Bean Validation  
- H2 Database  
- Maven  

---

## 📂 Estrutura do projeto
# 📌 Finance Tracker API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de usuários em um sistema de controle financeiro.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- Bean Validation  
- H2 Database  
- Maven  

---

## 📂 Estrutura do projeto
src/main/java/com/junin/financetrackerapi
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── FinanceTrackerApiApplication.java


---

## ⚙️ Funcionalidades

- CRUD completo de usuários  
- Validação de dados com Bean Validation  
- Tratamento global de exceções  
- Respostas padronizadas da API  
- Integração com banco de dados via JPA  

---

## 🔗 Endpoints

### Health Check

GET /health


### Usuários

GET /users
GET /users/{id}
POST /users
PUT /users/{id}
DELETE /users/{id}


---

## 📥 Exemplo de requisição

### Criar usuário


POST /users


```json
{
  "name": "Junin",
  "email": "junin@email.com"
}
📤 Exemplo de resposta
{
  "message": "Usuário criado com sucesso",
  "data": {
    "id": 1,
    "name": "Junin",
    "email": "junin@email.com"
  }
}
❌ Exemplo de erro
{
  "timestamp": "2026-03-30T11:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Usuário não encontrado com id: 999",
  "path": "/users/999"
}
▶️ Como executar
Clonar o repositório
git clone https://github.com/juslli/finance-tracker-api.git
Entrar na pasta
cd finance-tracker-api
Rodar a aplicação
./mvnw spring-boot:run

No Windows:

.\mvnw.cmd spring-boot:run
🧪 Banco de dados

O projeto utiliza H2 (arquivo local) para desenvolvimento.

Console disponível em:

http://localhost:8080/h2-console
📈 Melhorias futuras
Paginação de usuários
Integração com PostgreSQL
Testes unitários e de integração
Documentação com Swagger/OpenAPI
👨‍💻 Autor

Desenvolvido por Junin