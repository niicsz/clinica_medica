# Sistema de Gerenciamento de Clínica Médica

Um sistema completo para gerenciamento de clínicas médicas, com funcionalidades para cadastro de médicos, pacientes, usuários e agendamento de consultas.

## Funcionalidades

- **Gerenciamento de Usuários**: Cadastro, edição e exclusão de usuários do sistema
- **Gerenciamento de Pacientes**: Cadastro, consulta, edição e exclusão de pacientes
- **Gerenciamento de Médicos**: Cadastro, edição e exclusão de médicos e suas especialidades
- **Agendamento de Consultas**: Agendamento, edição e cancelamento de consultas médicas
- **Validação de Dados**: Validação completa em todos os formulários (CPF, e-mail, datas, etc.)
- **API REST**: Endpoints REST para integração com outros sistemas

## Tecnologias Utilizadas

- **Backend**:
  - Java 17
  - Spring Boot 3.4.3
  - Spring Data JPA
  - Spring Validation
  - H2 Database (para ambiente de desenvolvimento)
  - Lombok
  
- **Frontend**:
  - Thymeleaf
  - Bootstrap 5
  - Bootstrap Icons
  - HTML5, CSS3, JavaScript

## Pré-requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven 3.6 ou superior

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/niicsz/clinica_medica.git
   cd clinica-medica
   ```

2. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse pelo navegador:
   ```
   http://localhost:8080
   ```

4. Para acessar o console do banco de dados H2:
   ```
   http://localhost:8080/h2-console
   
   JDBC URL: jdbc:h2:mem:clinicamedica
   Username: sa
   Password: (deixe em branco)
   ```

## Estrutura do Projeto

```
src/main/java/com/example/clinica_medica/
├── config/           # Configurações do Spring Boot e perfis
├── controller/       # Controladores REST e Web
│   ├── api/          # Endpoints da API REST
│   └── web/          # Controladores Web (Thymeleaf)
├── entities/         # Entidades JPA
├── exceptions/       # Tratamento de exceções
├── repositories/     # Repositórios JPA
└── services/         # Camada de serviços

src/main/resources/
├── static/           # Recursos estáticos (CSS, JavaScript)
├── templates/        # Templates Thymeleaf
│   ├── consultas/    # Templates de consultas
│   ├── layout/       # Templates de layout
│   ├── medicos/      # Templates de médicos
│   ├── pacientes/    # Templates de pacientes
│   └── usuarios/     # Templates de usuários
└── application.properties  # Configurações da aplicação
```

## Perfis da Aplicação

- **test**: Perfil de desenvolvimento com banco de dados H2 em memória e dados de teste carregados automaticamente

## Entidades

- **Usuario**: Usuários do sistema (administradores, recepcionistas, etc.)
- **Paciente**: Pacientes da clínica
- **Medico**: Médicos da clínica e suas especialidades
- **Consulta**: Agendamento de consultas entre pacientes e médicos

## API REST

A API REST está disponível no contexto `/api` e oferece endpoints para todas as entidades:

### Usuários
- `GET /api/usuarios` - Lista todos os usuários
- `GET /api/usuarios/{id}` - Busca usuário por ID
- `POST /api/usuarios` - Cria novo usuário
- `PUT /api/usuarios/{id}` - Atualiza um usuário existente
- `DELETE /api/usuarios/{id}` - Remove um usuário

### Pacientes
- `GET /api/pacientes` - Lista todos os pacientes
- `GET /api/pacientes/{id}` - Busca paciente por ID
- `GET /api/pacientes/cpf/{cpf}` - Busca paciente por CPF
- `POST /api/pacientes` - Cria novo paciente
- `PUT /api/pacientes/{id}` - Atualiza um paciente existente
- `DELETE /api/pacientes/{id}` - Remove um paciente

### Médicos
- `GET /api/medicos` - Lista todos os médicos
- `GET /api/medicos/{id}` - Busca médico por ID
- `POST /api/medicos` - Cria novo médico
- `PUT /api/medicos/{id}` - Atualiza um médico existente
- `DELETE /api/medicos/{id}` - Remove um médico

### Consultas
- `GET /api/consultas` - Lista todas as consultas
- `GET /api/consultas/{id}` - Busca consulta por ID
- `POST /api/consultas` - Agenda nova consulta
- `PUT /api/consultas/{id}` - Atualiza uma consulta existente
- `DELETE /api/consultas/{id}` - Cancela uma consulta

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Crie um Pull Request
