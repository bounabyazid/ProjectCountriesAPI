# ProjectCountriesAPI

## Introduction
This project is a part of recruitmernt process aims to implement a microservice which provides a list of countries and, in addition, provides more detailed information per country.
## Reuirements
make two functions

GET /countries/
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
GET /countries/{name}
response:
          {
                   "name": "Finland",
                   "country_code": "FI",
                   "capital": "Helsinki",
                   "population": 5491817,
                   "flag_file_url": "<url to the flag file>"
          }
  
## Technologies
## Launch
