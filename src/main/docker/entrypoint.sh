#!/bin/sh

echo "The application will start in ${MICROMONITOR_SLEEP}s..." && sleep ${MICROMONITOR_SLEEP}
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.war" "$@"
