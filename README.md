# Itavest API

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de usuários, compras e pagamentos.  
O sistema simula uma estrutura básica de processamento de compras e controle de pagamentos, aplicando regras de negócio e organização em arquitetura em camadas.

---

# Arquitetura do Projeto

O projeto segue uma **arquitetura em camadas**, comum em aplicações backend com Spring Boot, separando responsabilidades para facilitar manutenção e escalabilidade.

As principais camadas são:

### Controller
Responsável por receber as **requisições HTTP**, processar os dados de entrada e retornar as respostas da API.

### Service
Camada onde ficam as **regras de negócio do sistema**, como validações de pagamento, verificação de status e controle de operações.

### Repository
Responsável pela **persistência de dados**, utilizando **Spring Data JPA** para comunicação com o banco de dados.

### Entities
Representam os **objetos do domínio do sistema** e seu mapeamento com as tabelas do banco de dados através do **Hibernate/JPA**.

---

# Entidades Principais

O sistema possui as seguintes entidades:

### Usuario
Representa o usuário do sistema.

Atributos principais:
- id
- nome
- email
- telefone
- senha

Relacionamentos:
- Um usuário pode possuir **várias compras**

---

### Compra
Representa uma operação de compra realizada por um usuário.

Atributos principais:
- id
- dataCompra
- status da compra

Relacionamentos:
- Uma compra pertence a **um usuário**
- Uma compra possui **vários itens**
- Uma compra pode possuir **um pagamento**

---

### CompraItem
Representa os itens pertencentes a uma compra.

Atributos principais:
- quantidade
- preço
- subtotal

Relacionamentos:
- Um item pertence a **uma compra**

---

### Pagamento
Representa o pagamento associado a uma compra.

Atributos principais:
- dataPagamento
- status do pagamento

Relacionamentos:
- Um pagamento pertence a **uma compra**

---

# DTO (Data Transfer Object)

O projeto utiliza **DTOs** para controlar os dados enviados e recebidos pela API.

Objetivos dos DTOs:

- evitar exposição direta das entidades
- controlar os dados retornados pela API
- permitir validações específicas para cada operação
- desacoplar a API da estrutura interna do banco

Exemplo:

- `UsuarioInsertDTO` → utilizado para criação de usuário
- `UsuarioDTO` → utilizado para retorno de dados do usuário

---

# Tratamento de Exceções

O sistema possui um **tratamento centralizado de exceções** para garantir respostas padronizadas da API.

### ResourceExceptionHandler

Classe responsável por interceptar exceções da aplicação utilizando `@ControllerAdvice` e transformar essas exceções em respostas HTTP apropriadas.

Exemplos de exceções tratadas:

- `ResourceNotFoundException`
- `BusinessException`

---

Essa abordagem melhora a consistência da API e facilita a comunicação com clientes que consomem os endpoints.

---

# Regras de Negócio

Algumas regras implementadas no sistema:

- Um pagamento não pode ser processado se já existir pagamento associado à compra
- O valor do pagamento deve ser positivo
- O pagamento não pode ser processado caso esteja cancelado
- O status da compra é atualizado automaticamente conforme o status do pagamento

---

# Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Validation
- Maven

---

# Próximas Melhorias

Possíveis evoluções do sistema:

- Implementação de autenticação e autorização com Spring Security
- Adição de testes unitários
- Documentação da API com Swagger/OpenAPI
- Containerização da aplicação com Docker
- Implementação de logs e observabilidade

---

# Organização das Atividades

Durante o desenvolvimento do projeto, foi utilizado o **Trello** para organização das tarefas.

As atividades foram divididas em cartões contendo checklists com:

- criação das entidades
- definição dos atributos
- implementação de construtores
- criação de getters e setters
- definição dos relacionamentos conforme o modelo relacional
- implementação das regras de negócio

Essa organização permitiu acompanhar o progresso do desenvolvimento e garantir consistência na implementação das funcionalidades.

---

# Autor

Mel Ferreira
