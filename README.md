# Hot to run:

### It uses Java 21 (LTS) version

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
