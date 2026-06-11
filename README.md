# Fight Club API

API REST para gerenciamento de academia com foco em cadastro de alunos, matrículas e relatórios financeiros.

## Stack
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- Flyway
- PostgreSQL
- Springdoc OpenAPI (Swagger UI)
- Maven

## Estrutura do projeto
- `src/main/java/dev/zenetodev/fightclub/config`: configuração (OpenAPI)
- `src/main/java/dev/zenetodev/fightclub/controller`: endpoints REST
- `src/main/java/dev/zenetodev/fightclub/service`: regras de negócio
- `src/main/java/dev/zenetodev/fightclub/repository`: acesso a dados
- `src/main/java/dev/zenetodev/fightclub/domain`: entidades JPA
- `src/main/java/dev/zenetodev/fightclub/dto`: contratos de entrada/saída
- `src/main/java/dev/zenetodev/fightclub/specification`: filtros dinâmicos
- `src/main/resources/db/migration`: migrations Flyway
- `src/test`: testes

## Banco de dados
As migrations Flyway estão em:
- `V1__create_academia_schema.sql`
- `V2__insert_dados_iniciais.sql`
- `V3__inserir_dados_financeiro.sql`

## Configuração de ambiente
1. Copie `src/main/resources/application.properties.example` para `src/main/resources/application.properties`.
2. Preencha:
   - `spring.datasource.url`
   - `spring.datasource.username`
   - `spring.datasource.password`

## Como executar
```bash
# Linux/macOS
chmod +x mvnw
./mvnw spring-boot:run

# alternativa
sh mvnw spring-boot:run
```

## Testes
```bash
sh mvnw test
```

## Endpoints principais
### Alunos (`/alunos`)
- `POST /alunos` — cadastra aluno
- `GET /alunos` — lista paginada com filtros (`nome`, `email`, `celular`, `cidade`, `estado`)
- `GET /alunos/{id}` — busca por ID
- `PUT /alunos/{id}` — atualiza aluno
- `DELETE /alunos/{id}` — remove aluno

### Relatórios (`/relatorios`)
- `GET /relatorios/faturamento-mensal`
- `GET /relatorios/alunos-por-cidade`
- `GET /relatorios/faturas-em-aberto`

## Documentação da API
Com a aplicação em execução, acesse o Swagger UI:
- `http://localhost:8080/swagger-ui/index.html`

## Observações
- O projeto usa `spring.jpa.hibernate.ddl-auto=validate`; o schema deve estar compatível com as migrations.
- Atualmente não há camada de autenticação/autorização implementada.
