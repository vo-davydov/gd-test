# Java developer test Spring Boot application

## How to Run

- Java 8
- Maven 3.6.3
- PostgreSQL 10.10

1. Create database GD (admin/adminka) or edit application.properties
2. Download project
3. In cli 'mvn spring-boot:run'

## About the Service

It's simple REST test application.

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

## Retrieve a paginated list (default sort value is "DESC") find by attribute

```
client attributs (name, inn, shortName, address, okopf)
example:

GET http://localhost:8080/api/client/search?name=Exxon

bank attributs (name, BIK)
example:

GET http://localhost:8080/api/bank/search?BIK=12344

okopf attributs (name, code)
example:

GET http://localhost:8080/api/okopf/search?code=4422
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
    "id": "id",
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
POST http://localhost:8080/api/client

{
    "name": "Exxon Oil",
    "inn": 7708004769,
    "shortName": "Exxon",
    "address": "Russia, 105066, Moscow st. Staraya Basmannaya 16, building 1a",
    "okopfId": "okopfId"
}
```

## Update a client resource

```
PUT http://localhost:8080/api/client/{id}

example JSON:

{
    "name": "Exxon M",
    "inn": 7708004770,
    "shortName": "ExxonM",
    "address": "Russia",
    "okopfId": "okopfId"
}

Response: 

{
    "id": "id",
    "created": "2020-12-12 00:00:00.000",
    "updated": "2020-12-12 00:10:00.000",
    "name": "Exxon M",
    "inn": 7708004770,
    "shortName": "ExxonM",
    "address": "Russia",
    "okopfId": "okopfId"
}

```

## Create a bank resource

```
POST http://localhost:8080/api/bank

{
    "bik": "044525221",
    "name": "Chase Bank"
}
```

## Update a bank resource

```
PUT http://localhost:8080/api/bank/{id}

example JSON:

{
    "bik": "044525222",
    "name": "Chase B"
}

Response: 

{
    "id": "id",
    "created": "2020-12-12 00:00:00.000",
    "updated": "2020-12-12 00:10:00.000",
    "bik": "044525222",
    "name": "Chase B"
}

```

## Create a contribution resource


```
POST http://localhost:8080/api/contribution

{
    "openDate": "2020-07-07",
    "percent": 8,
    "periodInMonth": 12,
    "clientId": "clientId",
    "bankId": "bankId"
}
```

## Update a contribution resource

```
PUT http://localhost:8080/api/contribution/{id}

example JSON:

{
    "openDate": "2020-07-07",
    "percent": 8,
    "periodInMonth": 60,
    "clientId": "clientId",
    "bankId": "bankId"
}

Response: 

{
    "id": "id",
    "created": "2020-12-12 00:00:00.000",
    "updated": "2020-12-12 00:10:00.000",
    "openDate": "2020-07-07",
    "percent": 8,
    "periodInMonth": 60,
    "clientId": "clientId",
    "bankId": "bankId"
}

```
