# limit-service - Centralized Configuration for Microservices




![CHEESE](https://github.com/Adnan-edu/limit-service/blob/main/limit-service/img.png)


Main benefits of using this approach is all your configurations related to your application are centralized.
Connecting the entire chain: Limits Microservice with spring cloud config server to the git repo.
Initially add spring cloud config server in git repo. To make it a spring cloud config server, we have to use @EnableConfigServer annotation in the application class of the config server. 

We also have to assign the git repo URL in the properties file of the config server:

spring.cloud.config.server.git.uri=file:///git-local-config-repo

Limit microservice can read properties from spring cloud config server and inorder to do that we have to add dependency in limit microservice which would help us to talk to the config server. 
Config Client
URL of the config server - In Application properties file of limit microservice we can introduce the config server:

spring.config.import=optional:configserver:http://localhost:8888


Name of the limit service application has to match with the same name of the properties file in the config server. 
For example if the application name is (spring.application.name = ) limits-service then the property file name in the config server must be limits-service.properties.

It would use the limits-service as an id to talk to the config server to get the configuration back.

Values in application.properties in the limits microservice has less priority compared with the values which are present in the git repo config server. 

Store separate configuration in config server: 
 
If we want to handle multiple environment properties in microservices then we can create multiple copies for dev and production in the config server for example, to create properties file for different environment

limits-service-dev.properties and limits-service-prod.properties 


 To support multiple environment in spring application, we can go for a concept for profiles. To configure that in application.properties file in limits microservice:

spring.profiles.active = dev
spring.cloud.config.profile = dev
