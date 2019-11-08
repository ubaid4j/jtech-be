# cd apiGatewayServer
# mvn clean package -DskipTests
# cd ../chatClientService
# mvn clean package -DskipTests
# cd ../eurekaNamingServer
# mvn clean package -DskipTests
# cd ../messageService
# mvn clean package -DskipTests
# cd ../notificationService
# mvn clean package -DskipTests
# cd ../sessionService
# mvn clean package -DskipTests
# cd ../userService
# mvn clean package -DskipTests
# cd ../
sudo docker-compose up --build
