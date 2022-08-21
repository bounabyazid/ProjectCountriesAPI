# ProjectCountriesAPI

## Introduction
This project is a part of recruitmernt process aims to implement a microservice which provides a list of countries and, in addition, provides more detailed information per country.
## Reuirements
Make two functions (countries and ) using spring framework

First function's signature : getCountries()
```
GET /countries/
```
Calling this function on browser or Postman should be as follows:
```
https://localhost:8080/countries
```
The response should be as follows:
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
The response should be as follows:
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
