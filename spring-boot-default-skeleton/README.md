# spring-boot-default-skeleton
Spring Boot Default Skeleton — Spring Boot, LOGGER

### Secure Configurations Usage
Tool:  
Download: `http://www.jasypt.org/`  
Typical Usage: `./bin/encrypt.sh input=value password=${PASSWORD}`  

Plain Configurations:  
`mvn clean spring-boot:run`

Secure Sensitive Configurations:  
`mvn clean -Dspring-boot.run.arguments=--jasypt.encryptor.password=${PASSWORD} spring-boot:run`

Secure Sensitive Configurations in IDEA:  
Add `jasypt.encryptor.password` and `${PASSWORD}` as `Name | Value` under Environment Variables

### Password
$PASSWORD = `FRC`  
Delete section in production app

### Setup 
* Cleanup

```bash
$ rm -rf .idea
$ rm -rf .sonar
$ rm -rf target
$ find . -name '*.iml' -delete
```
* Copy (attention: on */.* )

```bash
$ cp -fR $SOURCE_PATH/. $TARGET_PATH
```

* Edit pom.xml: `artifactId` value (*e.g. app-server*)
* Edit source package: `com.forcelate` -> `com.company.project`
    * `jacoco-maven-plugin`: update each `configuration->excludes->exclude` section with proper package name (*e.g. com/company/project/Application.class*)
    * `sonar-project.properties`: update property `sonar.exclusions` with proper package name (*e.g. src/main/java/com/company/project/Application.java*)
    * `ApplicationResourceBeans.java`: update annotation `@ComponentScan("com.forcelate.resource")` with proper package name (*e.g. @ComponentScan("com.company.project.resource")*)
* Edit sonar-project.properties: `sonar.projectKey`, `sonar.projectName` values (*e.g. app-server*)
* Edit application-***.yml (files): `server.port`, `appConfigs.cors.enabled`
* Edit Jenkinsfile: `notifications() -> emailext ->  to` values (*e.g. $TEAM_DEVELOPERS*)
* Edit docker scripts: update `APP` property with current application name in each docker script - `docker-build.sh`, `docker-push.sh`, `docker-run.sh`
* Edit com.forcelate.Application.java: LOGGER message
* Edit README :)
* Deployment: https://github.com/forcelate/forcelate-skeletons/wiki/Deployment-Guide:-Spring-Boot-on-Ubuntu

### Tips 
* **git-commit-id-plugin known issue**  
  You should make at least one initial commit into your git repository for proper project build. Without any commits, you will receive next error during project build: 
  ```bash
  [ERROR] Failed to execute goal pl.project13.maven:git-commit-id-plugin:3.0.1:revision (default) 
  on project forcelate-xchange-server: Could not complete Mojo execution...: Error: Could not get HEAD Ref, 
  are you sure you have some commits in the dotGitDirectory? -> [Help 1]
  ```
