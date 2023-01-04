# marcapagina

### Em andamento

API para registro e acompanhamento de evolução de leitura. 
Utiliza o Keycloak para autenticação e autorização.

### Para rodar localmente

#### Configurando Keycloak

**CUIDADO!** Os secrets da aplicação estão no [docker-compose.yml](docker-compose.yaml), que está sendo utilizado
para facilitar o desenvolvimento, porém, para fins de produção, os secrets 
nunca devem ser colocados em um repositorio.

1. Suba o SQL Server e o Keycloak com o comando `docker-compose up`. 
Este comando irá iniciar e configurar o banco de dados,
inicializar o schema, que pode ser visto em [schema.sql](src/main/resources/sql/schema.sql)
e também configurar o Keycloak.
2. Acesse o painel do Keycloak em http://localhost:8080/auth/admin. 
Login e senha são `admin`, de acordo com o definido no [docker-compose.yml](docker-compose.yaml).
3. Deve-se criar o realm e client-id no painel do Keycloak. 
Para criação de realm e client-id, siga as instruções [aqui](https://www.baeldung.com/spring-boot-keycloak). 
Segue o que foi configurado para esta aplicação:
   - client-id: login-app
   - realm: marca-pagina
4. A configuração é mantida se o container for parado e iniciado novamente.

#### Rodando aplicação
1. Definir a variável de ambiente DB_SENHA_MARCAPAGINA. A senha do banco encontra-se no [docker-compose.yml](docker-compose.yaml).
2. Rodar direto da IDE a classe `MarcapaginaApplication`, lembrando de informar o profile para a jvm com `-Dspring.profiles.active=dev`. 
Se estiver utilizando o IntelliJ, inclua o comando em `Add VM options` na configuração de Run/Debug.
3. (Alternativa) `mvn spring-boot:run -Drun.profiles=dev`.
4. Acessar http://localhost:8081/hello-world e criar um novo usuário ou autenticar com o usuário criado.



