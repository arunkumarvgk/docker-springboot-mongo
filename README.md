# docker-springboot-mongo
Java spring boot microservices project with MongoDB dockerized 

1. Install docker  

2. Download mongo image and install it

      **docker run -p 27017:27107 --network mynetwork -v myvol  --name database mongo:4.4.1** 
   
      **-p**        : *Map container port 27017 to host port 27017 *  
      **--network** : *Connect a container to a network, required so that other containers can connect using name **mongodb://database/<DB-NAME>** 
                        (mynetwork should be created first)*  
      **-v**        : *Volume, Bind mount a volume (Volume should be created first) *  
      **--name**    : *Name the container which can be used later to connect *    
 3. Run shell into mongo container
    ** docker container exec -it database bash **  
    insert few record into EMS DB  
    
        Use EMS;
        db.employee.insert({name:"Sachin", age: 45, salary:45000});
        db.employee.insert({name:"Gilchrist", age: 46, salary:43000});
        db.employee.insert({name:"Kane", age: 30, salary:85000});
        db.department.insert({deptid: 1, name: "Cricket 1"});
        db.department.insert({deptid: 2, name: "Cricket 2"});
        db.department.insert({deptid: 3, name: "Cricket 3"});  
        
 3. Build and Run Employee service  
      **docker build -t employee-serv:1.0.0 .**  
      (Run it inside Employee-Service folder)  
      **docker container run -p 7070:7070 --network mynetwork  --name employee-serv employee-serv:1.0.0**  
      
 4. Build and Run Department service  
      **docker build -t department-serv:1.0.0 .**  
      (Run it inside Department-Service folder)  
      **docker container run -p 7272:7272 --network mynetwork  --name department-serv department-serv:1.0.0**
      
 You can access http://localhost:7272 and http://localhost:7070
