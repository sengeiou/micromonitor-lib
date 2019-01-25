FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    MICROMONITOR_SLEEP=0 \
    JAVA_OPTS=""

# Add a micromonitor user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh micromonitor
WORKDIR /home/micromonitor

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown micromonitor:micromonitor entrypoint.sh
USER micromonitor

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8082 5701/udp

ADD *.war app.war

