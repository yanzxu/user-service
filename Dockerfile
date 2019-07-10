FROM openjdk:8

ADD mydata/build/libs/*.jar /app/
ADD run.sh /app

EXPOSE 8081 8082

WORKDIR /app

RUN mv *.jar app.jar && \
    chmod +x run.sh

CMD ./run.sh

