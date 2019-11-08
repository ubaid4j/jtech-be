cd apiGatewayServer
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../chatClientService
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../eurekaNamingServer
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../messageService
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../notificationService
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../sessionService
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../userService
sudo chmod +x mvnw
sudo ./mvnw clean package -DskipTests
cd ../
sudo docker-compose up --build
