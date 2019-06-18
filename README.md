# Diff app WAES Assignment

# Goal

The goal of this assignment is to show your coding skills and what you value in software engineering. We value new ideas so next to the original requirement feel free to improve/add/extend. 

# The Assignment

• Provide 2 http endpoints that accepts JSON base64 encoded binary data on both endpoints 
o <host>/v1/diff/<ID>/left and <host>/v1/diff/<ID>/right 
• The provided data needs to be diff-ed and the results shall be available on a third end point o <host>/v1/diff/<ID> 
• The results shall provide the following info in JSON format 
o If equal return that o If not of equal size just return that o If of same size provide insight in where the diffs are, actual diffs are not needed. 
▪ So mainly offsets + length in the data 
• Make assumptions in the implementation explicit, choices are good but need to be communicated 

## Author
* Mateus Augusto Oliveira

## Tech Stack
* Java 8
* Spring
  * Core (framework)
  * Web
  * Boot
* Lombok
* H2
* Swagger2

## Structure
waes-domain: Bussines Logic
waes-infra: core of application
waes-rest: api/client

## Decisions
I've used H2 database in memory for test and on file for running app.

## How to

Run tests: mvn clean test
Compile: mvn clean compile
Local install: mvn clean install

Check all rest API documentation in http://localhost:8080/swagger-ui.html

## Endpoints

GET http://localhost:8080/v1/diff

PUT http://localhost:8080/v1/diff/ID/left

PUT http://localhost:8080/v1/diff/ID/right

## Curl test

Post Data: 

Json: {"data": "d2Flcy10ZXN0ZQ=="}

curl -X POST \
  http://localhost:8080/v1/diff/4/right \
  -H 'content-type: application/json' \
  -d '{"data": "d2Flcy10ZXN0ZQ=="}'
  
Get Data

curl -X GET \
  http://localhost:8080/v1/diff/4


## Things to consider:

1. Install lombok plugin in your IDE
2. See the full documentation in http://localhost:8080/swagger-ui.html


### Improvements

1. Improve case of test with mock and documentation.
2. Use some design pattern like strategy patter to abstract the left and right side
3. Security with oauth2 an JWT



  
