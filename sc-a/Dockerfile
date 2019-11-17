FROM amazoncorretto:8
COPY target/sca.jar /opt/
ENV TZ Asia/Shanghai
ENTRYPOINT ["java", "-XX:+UseG1GC", "-Xmx2048m", "-XX:MaxGCPauseMillis=200", "-jar", "/opt/sca.jar"]