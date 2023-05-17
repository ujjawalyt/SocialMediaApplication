# SocialMediaApplication

This is a RESTful web service for a Social Media platform that provides secure CRUD operations with authentication and authorization using Spring Security. The API is built using Java and the Spring Framework.


### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman
- Spring Security
- Jwt-Token
- Jwt-Auth


### Modules
-  Authentication Module
-  Users Module
-  Follower Module
-  Like Module
-  Retweet Module
- Tweet Module


### ER Diagram
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
![socialmedia](https://github.com/ujjawalyt/SocialMediaApplication/assets/87421981/af601c85-0b2a-4d7e-8de5-a32d5d43fba2)


### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/ecomdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=*****
    spring.datasource.password=******
    
````
## API Root Endpoint

`https://localhost:8888/index.html`

`http://localhost:8888/swagger-ui.html`



### some screenshots of the Swagger UI 
![social medial](https://github.com/ujjawalyt/SocialMediaApplication/assets/87421981/7ca57368-7bc5-4f43-b2f9-545d572903b1)



#### For any feedback, report, suggestions, you can contact with me 
[Let's Connect...](https://www.linkedin.com/in/ujjawal-prakash/)
### THANK YOU

