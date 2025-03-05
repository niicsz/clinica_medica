# Clínica Médica - Sistema de Gerenciamento

Sistema web para gerenciamento de uma clínica médica desenvolvido com Spring Boot, permitindo o cadastro de usuários, pacientes, médicos e agendamento de consultas.

## 📋 Funcionalidades

- **Gerenciamento de Usuários**: Cadastro e listagem de usuários do sistema
- **Gerenciamento de Pacientes**: Cadastro e listagem de pacientes
- **Gerenciamento de Médicos**: Cadastro e listagem de médicos e suas especialidades
- **Agendamento de Consultas**: Agendamento e listagem de consultas médicas

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA**: Para persistência de dados
- **Thymeleaf**: Para templates HTML
- **Bootstrap 5**: Para interface responsiva
- **H2 Database**: Banco de dados em memória para desenvolvimento
- **Lombok**: Para redução de código boilerplate
- **Jakarta Validation**: Para validação de dados

## 📦 Estrutura do Projeto

```
clinica-medica/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── clinicamedica/
│   │   │               ├── ClinicaMedicaApplication.java
│   │   │               ├── config/
│   │   │               │   └── TestDataConfig.java
│   │   │               ├── controllers/
│   │   │               │   ├── api/
│   │   │               │   │   └── ClinicaMedicaController.java
│   │   │               │   └── web/
│   │   │               │       ├── HomeController.java
│   │   │               │       ├── WebUsuarioController.java
│   │   │               │       ├── WebPacienteController.java
│   │   │               │       ├── WebMedicoController.java
│   │   │               │       └── WebConsultaController.java
│   │   │               ├── entities/
│   │   │               │   ├── Usuario.java
│   │   │               │   ├── Paciente.java
│   │   │               │   ├── Medico.java
│   │   │               │   └── Consulta.java
│   │   │               ├── repositories/
│   │   │               │   ├── UsuarioRepository.java
│   │   │               │   ├── PacienteRepository.java
│   │   │               │   ├── MedicoRepository.java
│   │   │               │   └── ConsultaRepository.java
│   │   │               └── services/
│   │   │                   ├── UsuarioService.java
│   │   │                   ├── PacienteService.java
│   │   │                   ├── MedicoService.java
│   │   │                   └── ConsultaService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── styles.css
│   │       │   └── js/
│   │       │       └── scripts.js
│   │       └── templates/
│   │           ├── index.html
│   │           ├── layout/
│   │           │   └── main.html
│   │           ├── usuarios/
│   │           │   ├── lista.html
│   │           │   └── form.html
│   │           ├── pacientes/
│   │           │   ├── lista.html
│   │           │   └── form.html
│   │           ├── medicos/
│   │           │   ├── lista.html
│   │           │   └── form.html
│   │           └── consultas/
│   │               ├── lista.html
│   │               └── form.html
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── clinicamedica/
│                       └── ClinicaMedicaApplicationTests.java
└── pom.xml
```

## 🚀 Instalação e Execução

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

### Passos para execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/clinica-medica.git
   cd clinica-medica
   ```

2. **Compile o projeto**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação**
   - Interface web: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:clinicamedica`
     - Usuário: `sa`
     - Senha: ``

## 🔀 API REST

A aplicação também disponibiliza uma API REST para integração com outros sistemas:

### Endpoints de Usuários

- **GET** `/api/usuarios`: Lista todos os usuários
- **POST** `/api/usuarios`: Cadastra um novo usuário

### Endpoints de Pacientes

- **GET** `/api/pacientes`: Lista todos os pacientes
- **GET** `/api/pacientes/cpf/{cpf}`: Busca paciente por CPF
- **POST** `/api/pacientes`: Cadastra um novo paciente

### Endpoints de Médicos

- **GET** `/api/medicos`: Lista todos os médicos
- **GET** `/api/medicos/{id}`: Busca médico por ID
- **POST** `/api/medicos`: Cadastra um novo médico

### Endpoints de Consultas

- **GET** `/api/consultas`: Lista todas as consultas
- **POST** `/api/consultas`: Agenda uma nova consulta

## 👥 Contribuição

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Adicione suas mudanças (`git add .`)
4. Comite suas mudanças (`git commit -m 'Add some AmazingFeature'`)
5. Faça o Push da Branch (`git push origin feature/AmazingFeature`)
6. Abra um Pull Request

## 🔧 Configurações Adicionais

O arquivo `application.properties` contém as configurações da aplicação:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:clinicamedica
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Hibernate DDL Auto
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Logging
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=ERROR

# Server Port
server.port=8080

# Ative o perfil de teste
spring.profiles.active=test
```****
