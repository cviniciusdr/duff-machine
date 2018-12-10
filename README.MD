# Documentação
http://localhost:8080/swagger-ui.html

# Build

Na pasta do projeto fazer o package do projeto
```sh
mvn clean package
```


# Docker Build

Compilar a imagem do docker
```sh
docker build . -t cviniciusdr/duff-machine:1.0
```
# Docker Run
Execução
```sh
docker run -p 8080:8080 cviniciusdr/duff-machine:1.0
```


### Todos
Esse período está bem corrido pra mim, não dispus do tempo que gostaria para colocar no projeto.
Ele está com algumas "pendências", como vcs poderão ver, a meu ver säo: 

 - Mais Testes! Apesar de estar tentando adotar o TDD na minha vida, ainda não sou tão "rápido" nessa metodologia e optei pelo desenvolvimento "comum" pela falta de tempo.
 - Credenciais hard-codded: Eu coloquei direto no código pra testar e não tive tempo de voltar e alterar. 
 - Inclusão te cachê

### Considerações

- A parte de deploy eu coloquei o build da imagem com docker. Hoje eu trabalho com Jenkins, onde ele baixa/builda o dockerfile e disponibiliza no Openshift
- Usei o h2 pra não precisar configurar o docker-compose


