# QuarkusForSpringBootDevelopers

## 1. Create Quarkus Project

Create project with extensions

### For Linux & MacOS users
```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create -DprojectGroupId=sk.p8z -DprojectArtifactId=quarkus-app -Dextensions="spring-data-jpa,spring-web,spring-di,jdbc-postgres" -DclassName="sk.p8z.quarkus.GreetingResource" -Dpath="/hello"
```

### For Windows users
- CMD
```cmd
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create -DprojectGroupId=sk.p8z -DprojectArtifactId=quarkus-app -Dextensions="spring-data-jpa,spring-web,spring-di,jdbc-postgres" -DclassName="sk.p8z.quarkus.GreetingResource" -Dpath="/hello"
```
- Powershell
```powershell
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create "-DprojectGroupId=sk.p8z" "-DprojectArtifactId=quarkus-app" "-Dextensions=spring-data-jpa,spring-web,spring-di,jdbc-postgres" "-DclassName=sk.p8z.quarkus.GreetingResource" "-Dpath=/hello"
```