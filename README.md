# Java developer test Spring Boot application

## How to Run

- Java 11
- Maven 3.6.3
- PostgreSQL 10.10


## About the Service


## Get information about clients, banks, contributions, okopf.

```
GET http://localhost:8080/api/client
GET http://localhost:8080/api/bank
GET http://localhost:8080/api/contribution
GET http://localhost:8080/api/okopf
```

## Retrieve a paginated list (default sort value is "DESC")

```
GET http://localhost:8080/api/client?page=0&size=10&sort=asc
GET http://localhost:8080/api/bank?page=0&size=10&sort=asc
GET http://localhost:8080/api/contribution?page=0&size=10&sort=asc
GET http://localhost:8080/api/okopf?page=0&size=10&sort=asc
```

## Delete object by id

```
DELETE http://localhost:8080/api/client/{id}
DELETE http://localhost:8080/api/bank/{id}
DELETE http://localhost:8080/api/contribution/{id}
DELETE http://localhost:8080/api/okopf/{id}
```

## Create a okopf resource

```
POST http://localhost:8080/api/okopf

example JSON:

{
    "name": "Public joint stock companies",
    "code": "12247"
}

Response: 

{
    "id": 1,
    "created": "2020-12-12 00:00:00.000",
    "updated": null,
    "name": "Public joint stock companies",
    "code": "12247"
}

```

## Update a okopf resource

```
PUT http://localhost:8080/api/okopf/{id}

example JSON:

{
    "name": "Closed joint stock companies",
    "code": "12248"
}

Response: 

{
    "id": "id",
    "created": "2020-12-12 00:00:00.000",
    "updated": "2020-12-12 00:10:00.000",
    "name": "Closed joint stock companies",
    "code": "12248"
}

```


## Create a client resource

```
{
    "name": "Exxon Oil",
    "inn": 7708004769,
    "shortName": "Exxon",
    "address": "Russia, 105066, Moscow st. Staraya Basmannaya 16, building 1a",
    "okopfId": 
}
```

## Create a bank resource

```
{
    "bik": "044525221",
    "name": "Chase Bank"
}
```

## Create a contribution resource


```
{
    "openDate": "2020-07-07",
    "percent": 8,
    "periodInMonth": 12,
    "clientId": ,
    "bankId": 
}
```

