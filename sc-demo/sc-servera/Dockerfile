FROM amazoncorretto:11
COPY target/sc-servera.jar /opt/
ENV TZ Asia/Shanghai
ENTRYPOINT ["java", "-XX:+UseG1GC", "-Xmx2048m", "-XX:MaxGCPauseMillis=200", "-jar", "/opt/sc-servera.jar"]