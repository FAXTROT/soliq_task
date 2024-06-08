# Hot to run:

### It uses Java 21 (LTS) version and runs in Linux

## First compile all microservices:

`./mvnw clean package` - run within each service (target/*.jar dir must appear in each service)

## Next run docker compose file

`docker-compose up -d`

### Visit http://localhost:8081 to see all up services

#### (it takes sometime to load them all, so first few seconds they might not be visible)

## In case you want to clear everything including images, containers and volumes:

`docker compose down --volumes --rmi all`

# User service API:

`[GET] http://localhost:8082/user/api/v1/user/{passportNumber}` - get user by passport number

`http://localhost:8082/user/api/v1/user/DD1230987` - example

# Card service API:

`[POST] http://localhost:8082/card/api/v1/transfer`

`{
    "senderCardNumber": 8600123333333333,
    "receiverCardNumber": 8600122222222222,
    "amount": 100
}` - example

# Communal payments service API:

`[POST] http://localhost:8082/communal/api/v1/topUp`

`{
    "title": "Water",
    "userPassportNumber": "AA1234567",
    "amount": 123
}` - example

#### In Insomnia do not forget to set Header Content-Type: application/json
