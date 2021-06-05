# transaction-service 

## It's a simple application to maintain transaction history in banking domain

## Commands to run the app:
* Run `./gradlew clean build`
* Run `./gradlew bootRun`
* Transaction history controlled can be accessed here:
  `http://localhost:8080/swagger-ui/#/transaction-history-controller`
  Default credentials of swagger page:
  username is `user` and password will be displayed on Console.

## Out of scope:
* Authentication/Authorization of user is out of scope
* Test coverage is out of scope

## Assumptions:
* User cannot transfer amount to her own account so user_id and counter_party_id will be always different
* DateFilter: startDateTime is always earlier than or equal to endDateTime
* DateFilter: endDateTime is earlier than or equal to currentDateTime

## Some more use cases which can be covered
* If endDateTime is not given, api can consider currentDateTime as endDateTime
* Can Provide Transaction-status filter
* etc




  
  

  


