FROM eclipse-temurin:23-noble AS builder

WORKDIR /src

# copy files
COPY mvnw .
COPY pom.xml .

COPY .mvn .mvn
COPY src src

# make mvnw executable
RUN chmod a+x mvnw && /src/mvnw package -Dmaven.test.skip=true

FROM eclipse-temurin:23-jre-noble

WORKDIR /app

COPY --from=builder /src/target/rsvpDB-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/party
ENV SPRING_DATASOURCE_USERNAME=fred
ENV SPRING_DATASOURCE_PASSWORD=password

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar