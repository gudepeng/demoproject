FROM amazoncorretto:8
COPY target/scgateway.jar /opt/
ENV TZ Asia/Shanghai
ENTRYPOINT ["java", "-XX:+UseG1GC", "-Xmx2048m", "-XX:MaxGCPauseMillis=200", "-jar", "/opt/scgateway.jar"]