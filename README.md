# Hot to run:

`docker-compose up -d`


## In case you want to clear everything including images and containers

`docker compose down --volumes --rmi all`

# User service API:
`http://localhost:8082/user/api/v1/user/{passportNumber}` - get user by passport number
