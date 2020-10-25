# Java developer test Spring Boot application

## How to Run

- Java 11
- Maven 3.6.3
- PostgreSQL 10.10


## About the Service


## Get information about clients, banks, contributions, okopf.

```
http://localhost:8080/api/client
http://localhost:8080/api/bank
http://localhost:8080/api/contribution
http://localhost:8080/api/okopf
```

## Create a okopf resource

```
{
    "name": "Public joint stock companies",
    "code": "12247"
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

