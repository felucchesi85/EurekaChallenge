# eurekaChallenge

# Stock Market API Service

Expose an API endpoint where I can POST my data and sign up for an API key that will be used later.
Expose an API endpoint where I can hit and get stock market information, as a security mechanism use the API key obtained previously in order to validate user and make sure that no authorized user will consume the service (use request header for that purpose). 

Here are some examples of stock symbols
- Facebook (FB)
- Apple (AAPL)
- Microsoft (MSFT)
- Google (GOOGL)
- Amazon (AMZN)

The system will make use of a web service called Alpha Vantage, this will provide stock market information.

Information that will be retrieved in the response of the service as json format will contain:
- Open price
- Higher price
- Lower price
- Variation between last 2 closing price values.

**Alpha Vantage API**
```
https://www.alphavantage.co/documentation/
API Key: X86NOH6II01P7R24
```

API call sample to get stock prices from Facebook:

`https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=FB&outputsize=compact&apikey=X86NOH6II01P7R24`

**Considerations:**
- URL structure is up to you.
- Initial data for sign up: name, last name, email.
- Validation rules for signup data are up to you.
- Json structure is up to you.
- It will be a big plus if you deploy the services somewhere in the cloud (heroku, gcloud, aws, azure, etc). It's ok if you just do it locally.
- Use github (or other git repo).
- Programming language: Java with spring boot framework
- BONUS: If you can implement API throttling, that's a big one. Throttling rules are up to you (1 API call per second allowed or 10 API calls per minute, etc).
- Log every API call received, log format is up to you.

**No frontend development is required, challenge will be reviewed using postman**


## Eureka Stock Market Challenge ##

+ Java
+ Spring Boot.
+ Spring Security JWT
+ JUNIT 5
+ Swagger 
+ Heroku

## Git ##

Versioned with git

## Service startup Installation ##

+ mvn spring-boot:run

+Clone the project from github https://github.com/felucchesi85/eurekaChallenge
Download the code or clone from git IDE: File/Open : Repo once the ide recognized the maven project. find the
EurekaApplication class and give it Run.

+From Spring Tool :
Clone the project to a local IDE repo : File/Open Projects from file System/Directory : find the repo that recognizes the
IDE the project as an Eclipse Projects/Finish If necessary on the Maven Update Projects project to
update dependencies In application properties you can modify the port if necessary About the project /Run
As /Spring Boot App: to run the spring boot project

## How to use the project ##

Link where the heroku cloud application is deployed :  https://eureka-challenge-springboot-he.herokuapp.com/swagger-ui.html#/

The app will be able to be tested through Swagger

The app will contain two methods

+ GET /stockmarket/stocks 

+ You have to indicate a stock symbols for example

- Facebook (FB)
- Apple (AAPL)
- Microsoft (MSFT)
- Google (GOOGL)
- Amazon (AMZN)

This method will return the provide stock market information

 return example:
 
{
  "openPrice": "190.8000",
  "higherPrice": "192.2800",
  "lowerPrice": "185.9110",
  "twoDayVariation": "5.400000000000006"
}

+ POST /stockmarket/users/signup

This method will return a valid token so that a user can log in to the application, it is necessary to provide the following data in JSON format:

Example: 
{
  "email": "t@t.com",
  "firstName": "fer",
  "lastName": "test"
}

This method will return the token with this format:

{
  "firstName": "fer",
  "lastName": "test",
  "email": "t@t.com",
  "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJFVVJFS0EiLCJzdWIiOiJ0QHQuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY0NzQ0MDc1NiwiZXhwIjoxNjQ3NDQxMzU2fQ.JCe0fMQS4RxHQrWbglsS86QIYUBZ33GMlP6e0ejKVd6j7Iu544hkRC_KvAEAQcjp7dg0NTk0mzcIhTZQTbxCOg"
}

## Junit 5 ##

Junit: eureka/src/test/java/com/eureka/springboot/web/app/stockmarket/entities/UserTest.java
Junit and Mockito library to service Alpha Vantage: eureka/springboot/web/app/stockmarket/service/StockMarketServiceImplTest.java

## Properties Port 8181 ##
+  path: eureka/src/main/resources/application.properties   server.port=8181 

## Localhost URL ##
+ http://localhost:8181/swagger-ui.html

## Swagger URL ##

+ http://localhost:8181/swagger-ui.html
 
## Cloud Heroku ##
+https://eureka-challenge-springboot-he.herokuapp.com/swagger-ui.html#/
