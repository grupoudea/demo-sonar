# Demo Sonar

## To scan with sonar use the following command

```sh
mvn clean test org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar -Dmaven.test.skip=false -Dsonar.language=java -Dsonar.host.url=http://52.205.94.186:9000 -Dsonar.login=dd0ac679362ab8f219c7e83b69c6a4e0f21af1e8

```
