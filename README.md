# Database-service

This service is used to access the database of the Bill-Management project. It'll make available 
APIs to perform operation on the database. To run service, first you need to create the database. 
Use the following commands to create billmanagement database:

```text
docker run -d -p 5432:5432 --name billmanagement -e POSTGRES_PASSWORD=password postgres
docker exec -it billmanagement bash
    psql -U postgres
        CREATE DATABASE billmanagement;
        \l
```

Next, create a image of the service. Execute the following commands on base repository:

```text
gw clean build
docker build --build-arg JAR_FILE=build/libs/*.jar -t database-service-01 .
```

After that, run docker-compose up on the base repository:

```text
docker-compose up
```

After that, the service is ready to receive requests.




