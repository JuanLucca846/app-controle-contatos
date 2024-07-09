# API de controle de contatos

Essa API faz o controle de contatos dos usuários.

## Instalação

1. Clone esse repositório:

```bash
git clone https://github.com/JuanLucca846/app-controle-contatos.git
```

2. Instale as dependências com maven.

## Uso

1. Inicie a aplicação.
2. A API estará disponível em: http://localhost:8080
3. A documentação com Swagger estará disponível em: http://localhost:8080/swagger-ui/index.html
4. Deploy no Render estára disponível em: https://app-controle-contatos.onrender.com/swagger-ui/index.html

## Exemplo do ApplicationProperties
- spring.profiles.active=dev

- spring.springdoc.version:1.0.0
- spring.springdoc.api-docs.path:/api-docs
- spring.springdoc.swagger-ui.path:/swagger-ui.html
- spring.springdoc.swagger-ui.config-url:/api-docs/swagger-config
- spring.springdoc.swagger-ui.enabled:true

## Exemplo do ApplicationDevProperties
- spring.application.name=AppControleContatos

- spring.jpa.database=mysql
- spring.datasource.url=
- spring.datasource.username=
- spring.datasource.password=
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.database-platform:org.hibernate.dialect.MySQLDialect
- spring.jpa.show-sql=true
- spring.jpa.hibernate.ddl-auto=update

1. Banco utilizado MySQL.
2. Adicione a url, username e password do seu banco de dados.

## Exemplo do ApplicationProdProperties
- spring.application.name=AppControleContatos

- spring.jpa.generate-ddl=true
- spring.jpa.database=postgresql
- spring.datasource.url=jdbc:postgresql://${POSTGRESHOST}:${POSTGRESPORT}/${POSTGRESDATABASE}
- spring.datasource.username=${POSTGRESUSER}
- spring.datasource.password=${POSTGRESPASSWORD}

- spring.jpa.show-sql=true
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

- spring.jpa.properties.jakarta.persistence.sharedCache.mode=ENABLE_SELECTIVE

1. Banco utilizado no Deploy PostgreSQL.

## Exemplo do ApplicationTestProperties
- spring.datasource.url=jdbc:h2:mem:testdb
- spring.datasource.driver-class-name=org.h2.Driver
- spring.datasource.username=sa
- spring.datasource.password=
- spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

## Tecnologias

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## Endpoint de Auth

### Criar token
- **URL**: `http://localhost:8080/api/token?username=`
- **Method**: `GET`

## Endpoints de Pessoa

### Criar Pessoa

- **URL**: `/api/pessoas`
- **Method**: `POST`
- **Request Body Example**:
    ```json
    {
  "nome": "Juan Lucca",
  "endereco": "Rua Teste",
  "cep": "00000-000",
  "cidade": "São Paulo",
  "uf": "SP"
    }
    ```

### Buscar Pessoa por ID

- **URL**: `/api/pessoas/{id}`
- **Method**: `GET`

### Buscar Pessoa com maladireita por ID

- **URL**: `/api/pessoas/maladireita/{id}`
- **Method**: `GET`

### Buscar Todas Pessoas

- **URL**: `/api/pessoas`
- **Method**: `GET`

### Atualizar Pessoa por ID

- **URL**: `/api/pessoas`
- **Method**: `PUT`
- **Request Body Example**:
    ```json
    {
  "id": 1,
  "nome": "Nome Atualizazdo",
  "endereco": "Rua Atualizada",
  "cep": "00000-000",
  "cidade": "São Paulo",
  "uf": "SP",
    }
    ```

### Deletar Pessoa por ID

- **URL**: `/api/pessoas/{id}`
- **Method**: `DELETE`

## Endpoints de Contato

### Criar Contato

- **URL**: `/api/contatos`
- **Method**: `POST`
- **Request Body Example**:
    ```json
    {
  "tipo": 1,
  "contato": "912345678",
  "pessoa": 
    {
        "id": 1
    }
    }
    ```

### Buscar Contato por ID

- **URL**: `/api/contatos/{id}`
- **Method**: `GET`

### Buscar todos Contatos da Pessoa por ID

- **URL**: `/api/contatos/pessoa/{id}`
- **Method**: `GET`

### Atualizar Contato por ID

- **URL**: `/api/contatos`
- **Method**: `PUT`
- **Request Body Example**:
    ```json
    {
  "id": 1,
  "tipo": 0,
  "contato": "29460000",
  "pessoa": 
    {
        "id": 1
    }
    }
    ```

### Deletar Pessoa por ID

- **URL**: `/api/contatos/{id}`
- **Method**: `DELETE`