FROM gradle:jdk17
WORKDIR /app
COPY . /app
RUN ./gradlew clean build -x test
CMD ["java", "-jar", "./build/libs/easy-bookkeeping-system-0.0.1-SNAPSHOT.jar"]