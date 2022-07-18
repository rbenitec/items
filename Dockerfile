FROM openjdk:11
COPY "./target/customer-0.0.1-SNAPSHOT.jar" "customer.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","customer.jar"]