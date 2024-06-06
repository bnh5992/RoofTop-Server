FROM gradle:8.7-jdk17 as builder

WORKDIR /build
COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /build
RUN gradle build -x test --parallel

FROM openjdk:17.0-slim
WORKDIR /app

COPY --from=builder /build/build/libs/RoofTop-0.0.1-SNAPSHOT.jar .
EXPOSE 80

USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "-Djava.security.egd=file:/dev/./urandom",              \
    "-Dsun.net.inetaddr.ttl=0",                             \
    "Product-0.0.1-SNAPSHOT.jar"              \
]