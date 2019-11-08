sudo chmode +x mvnw
cd apiGatewayServer
./mvnw clean package -DskipTests
cd ../chatClientService
./mvnw clean package -DskipTests
cd ../eurekaNamingServer
./mvnw clean package -DskipTests
cd ../messageService
./mvnw clean package -DskipTests
cd ../notificationService
./mvnw clean package -DskipTests
cd ../sessionService
./mvnw clean package -DskipTests
cd ../userService
./mvnw clean package -DskipTests
cd ../
sudo docker-compose up --build
