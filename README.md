# ProjectCountriesAPI

## Table of contents
* [Introduction](#Introduction)
* [Requirements](#Requirments)
* [Implementation](#Implementation)
* [Testing](#Testing)

## Introduction

- This project is a part of recruitmernt process, which aims to build an API based on extranl one. This API fetches data from 
the following web service https://countriesnow.space/.
- The task is to implement a microservice which provides a list of countries and, in addition, provides more detailed information per country  using spring framework.

## Requirements
![example workflow](https://github.com/ybarhoush/country-service/actions/workflows/main.yml/badge.svg)
`spring-boot`: 
- https://start.spring.io/

- https://spring.io/guides/gs/spring-boot/

`Use maven`

- https://spring.io/guides/gs/maven/  

- https://www.baeldung.com/maven


## Implementation
First function's signature : getCountries()
```
GET /countries/
```
Calling this function on browser or Postman should be as follows:
```
https://localhost:8080/countries
```
The response should be like:
```
response:
          {
                   [
                             {
                                       "name": "Finland",
                                       "country_code": "FI"
                             },
                             ...
                   ]
          }
```
Second function's signature : getCountryByName(String name)
```
GET /countries/{name}
```
Calling this function on browser or Postman should be as follows:
```
https://localhost:8080/Finland
```
The response should be like this:
```
response:
          {
                   "name": "Finland",
                   "country_code": "FI",
                   "capital": "Helsinki",
                   "population": 5491817,
                   "flag_file_url": "<url to the flag file>"
          }
```  
## Technologies
## Launch
