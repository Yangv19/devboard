FROM openjdk:11
COPY target/*.jar application.jar
COPY images images
COPY wait-for-it.sh wait-for-it.sh
EXPOSE 5000
CMD ["./wait-for-it.sh", "mongo:27017", "-t", "60", "--", "java", "-jar", "/application.jar"]
