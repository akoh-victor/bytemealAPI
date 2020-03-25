# bytemealAPI
A RESTFUL API that allow developers to order for food from a vendor, . The core functionalities of this API are 
1 Register as a developer.
2 Login
3 Orderfood




# Sample REST CRUD API with Spring Boot, Mysql, JPA and Hibernate 

##  Setup instructions

**1. Clone the application**

```bash
https://github.com/ideal-it-solutions/bytemealAPI.git
```

**2. Requirements**

```bash
Your are required to have setep your java development environment.
if you have not, follow this link  https://www.oracle.com/java/technologies/getstarted-setup-java-programming.html for installation details.
```

**3. Build and run the app using maven**
 Run the app without packaging -

```bash
 
 ./mvnw spring-boot:run

```
**4. You will accessing secured resources so make sure to register and aquire token**
# registers a new developer
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "yourUsername",
    "password": "yourPassword"
    "firstName": "Yourfirstname",
    "lastName": "Yourlastname",
}' http://localhost:8080/api/v1/developer/register
 -

```bash
 
 ./mvnw spring-boot:run

```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    POST /api/v1/order/create
    
    POST /api/v1/developer/register
   
    POST /foodMenus

    POST /locations
    
    PUT /deliveryOptions
    
    DELETE /paymentOptions



