# Some Cloud Project

MSA관련 기술학습을 하고 싶어 주제를 생각하다가 마땅한 주제가 없어 일단 기획



## Environment

- Java 8
- Spring Boot 2.4.3
- Spring Cloud 2020.0.1
- Apache Kafka 2.7.0
- MongoDB 4.0.21

  ...



## Menu/API Description

- ...





## Project setup

```bash
mvnw.cmd clean package
```



### Run config-server

```bash
cd config-server/target/
java -jar -Dencrypt.key=${encrypt-key} config-server-0.0.1-SNAPSHOT.jar
```

${encrypt-key}에 비밀번호를 넣고 실행한다.



### Run service-registry

```bash
cd ../../service-registry/target/
java -jar service-registry-0.0.1-SNAPSHOT.jar
```



### Run some-service

```bash
cd ../../some-service/target/
java -jar some-service-0.0.1-SNAPSHOT.jar
```



### Run some-client

```bash
cd ../../some-client/target/
java -jar some-client-0.0.1-SNAPSHOT.jar
```
