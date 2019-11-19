FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=target/ContainerApp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT["java","-cp","app:app/lib/*","com.docker.test.ContainerApp.App"]