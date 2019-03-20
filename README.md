# jinternals-event-bus-demo

#### build images:
mvn clean install docker:build

#### deploy containers:
docker-compose -f docker-compose-rabbitmq.yml up -d

#### stop containers:
docker-compose -f docker-compose-rabbitmq.yml stop

#### remove containers:
docker-compose -f docker-compose-rabbitmq.yml rm


