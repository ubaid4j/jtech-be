sudo chmod +x mvnw
cd apiGatewayServer
sudo ./mvnw clean package -DskipTests
cd ../chatClientService
sudo ./mvnw clean package -DskipTests
cd ../eurekaNamingServer
sudo ./mvnw clean package -DskipTests
cd ../messageService
sudo ./mvnw clean package -DskipTests
cd ../notificationService
sudo ./mvnw clean package -DskipTests
cd ../sessionService
sudo ./mvnw clean package -DskipTests
cd ../userService
sudo ./mvnw clean package -DskipTests
cd ../
sudo docker-compose up --build
