# bytemealAPI
bytemealAPI API help developers order food from their favorite vendor. The core functionalities of this API are 
1 Register as a developer.
2 Login
3 Orderfood




# Built with Spring framework  Spring Boot 2.3.0.M3  and Java 

##  Setup instructions

**1. Clone the application**

```bash
https://github.com/ideal-it-solutions/bytemealAPI.git
```

**2. Requirements**

```bash
Your are required to setep your java development environment.
if you have not, follow this link  https://www.oracle.com/java/technologies/getstarted-setup-java-programming.html for installation details.
```

**3. Build and run the app using maven**
 Run the app without packaging -

```bash 
 ./mvnw spring-boot:run

```
**4. You will accessing secured resources so make sure to register and aquire token**

```bash
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "yourUsername",
    "password": "yourPassword"
    "firstName": "Yourfirstname",
    "lastName": "Yourlastname",
}' http://localhost:8080/api/v1/developer/register -

```


The app will start running at <http://localhost:8080>.

## Explore Rest APIs


    POST /order/create
    
    POST /developer/register

    POST /login
   
    POST /foodMenus

    POST /locations

    POST /login
    
    POST /deliveryOptions
    
    DELETE /paymentOptions

    GET order/vendor/pending/{vendor_id}

    GET order/vendor/completed/{vendor_id}

    GET order/vendor/paymentOption/{vendor_id}/{payment_id}

    GET order/vendor/deliveryOption/{vendor_id}/{delivery_id}


