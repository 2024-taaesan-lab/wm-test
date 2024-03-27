
## Shortest Path App 

- Java 17

To install the project dependencies and execute unit tests, use the command.  
`mvn clean install`  

To build report site.  
`mvn test site`  
 [Test Report](./target/site/surefire-report.html)  

### Docker (Optional)

This step is optional and is solely for building the Docker image.

```Shell
mvn package -Dmaven.test.skip=true
docker build -t taaesan/shortest-path-app:latest . 
docker push taaesan/shortest-path-app:latest
```
