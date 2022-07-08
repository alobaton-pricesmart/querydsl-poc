# querydsl-poc

Create a person

```bash
curl --location --request POST 'http://localhost:8080/person' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "TEST",
    "lastName": "TEST",
    "email": "test@domain.com",
    "birthdate": "1994-01-21",
    "carList": [
        {
            "plate": "DEVIL",
            "model": "2022"
        }
    ]
}'
```

Get persons using Rest Query Language

```bash
curl --location --request GET 'http://localhost:8080/person/paged?name=TEST&carList.plate=DEVIL'
```