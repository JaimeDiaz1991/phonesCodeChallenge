# PhoneChallenge

# Overview
This repository contains a project with a microservices approach using:
- Eureka 
- Spring Feign Client 
- Spring Boot
- Hystrix
- H2 in memory database
- Spring Data JPA

# Modules
### Eureka Server:  
Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port.

### Phones Service
This service returns a collection of phones, and their prices.each phone should contain a reference to its image, the name, the description, and its price.
Uses a sql script to insert test data in the H2 memory database

### Orders Service
This service receives an order that contains the customer information name, surname, and email, and the list of phones that the customer wants to buy.
  - Calculate the total prices of the order.
  - log in Json format at the final order to the console.
  - with a feign-Client calls to phones-service to validate the order

