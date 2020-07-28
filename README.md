# read-replica-connector-j
Little test project to validate the use of MySQL read replicas using Spring Boot.

For such, we use the MySQL Connector/J JDBC URL syntax in the Spring Boot properties file:

```
spring.datasource.url=jdbc:mysql:replication://localhost:3306,localhost:8082/demo?createDatabaseIfNotExist=true&useSSL=false
```

For full description of the syntax, read their documentation: https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-source-replica-replication-connection.html.

In this example, I'm running two MySQLs instances, one on the host machine (main instance), the other on a Docker container (replica instance), started with the following CLI command:

```
docker run -dit -p 8082:3306 --name mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=1 mysql
```

As for the setup, that's it! Now, to route the DB connection to the replica, you just need to use the Spring `Transactional` annotation (`org.springframework.transaction.annotation.Transactional`) with the value `readOnly = true`, so:
```
@Transactional(readOnly = true)
```

You can use it directly on `Repository` methods (to route only that methods) or even on `Controller` methods (so you can route all DB connections to your replica).

To run on command line `mvn spring-boot:run` 

## Using the docker-compose file

Install docker-compose on your machine https://docs.docker.com/compose/install/. Then copy [src/main/resources/application-compose.properties.sample](src/main/resources/application-compose.properties.sample) to [src/main/resources/application.properties](src/main/resources/application.properties), command: `cp src/main/resources/application-compose.properties.sample src/main/resources/application.properties`.
Then start the serever with `docker-compose up -d`. And to run  `mvn spring-boot:run` 
