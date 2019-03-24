# jinternals-event-bus-demo

#### build images:
mvn clean install docker:build

### Rabbitmq Example: 

#### deploy containers:
docker-compose -f docker-compose-rabbitmq.yml up -d

#### stop containers:
docker-compose -f docker-compose-rabbitmq.yml stop

#### remove containers:
docker-compose -f docker-compose-rabbitmq.yml rm


### Activemq Example: 

#### deploy containers:
docker-compose -f docker-compose-activemq.yml up -d

#### stop containers:
docker-compose -f docker-compose-activemq.yml stop

#### remove containers:
docker-compose -f docker-compose-activemq.yml rm

