## Postgresql db

in un container docker, per creare il container  
```docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 --name postgresql postgres```  
per accedere al database dal container
```psql -h localhost -U postgres```
dobbiamo già avere il db(da automatizzare tramite docker):
```CREATE DATABASE traffico;```
entrare nel db
```\c traffico```
creare la tabella
```CREATE TABLE traffico(ID SERIAL PRIMARY KEY NOT NULL, MOTO INT NOT NULL, CAMION INT NOT NULL, MACCHINE INT NOT NULL, FOTOCAMERAID INT NOT NULL, ORARIO TIMESTAMP NOT NULL);```
provare a aggiungere dei record
```insert into traffico values(default,1,2,3,54,TIMESTAMP '1999-01-08 04:05:06');```

## SpringBoot
in application.proprieties:  
spring.jpa.hibernate.ddl-auto=update --> aggiorna i database in caso servissero nuove tabelle / dati ma non le elimina nel caso ci fossero già