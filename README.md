# PruebaTecnicaSpringMongoDB

## To generate a JWT use the following accesses:

    "username":"admin",
    "password":"password"


## Deploying Spring Boot and MongoDB as Containers Using Docker and Docker Compose

### Steps & Commands

 1. pull mongo image from docker hub 
    
    
         docker pull mongo:latest
    
 2. run mongo image
   
   
        docker run -d -p 27017:27017 --name testmongodb mongo:latest
    
    
 3. dockerize spring boot application
 
 
         docker build -t test-promerica:1.0 .
    
 4. run spring boot docker image and link that container to mongo container
    
    
         docker run -p 8080:8080 --name test-promerica --link testmongodb:mongo -d test-promerica:1.0
 
 5. check docker running containers docker ps it should display two container ids
 
 6. check logs of spring boot image 
   
         
        docker logs test-promerica
 
 

