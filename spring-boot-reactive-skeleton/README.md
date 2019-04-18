# spring-boot-default-skeleton
Spring Boot Default Skeleton — Spring Boot, LOGGER

### Secure Configurations Usage
Tool:
Download: `http://www.jasypt.org/`
Typical Usage: `./bin/encrypt.sh input=value password=${PASSWORD}`

Plain Configurations:
`mvn clean spring-boot:run`

Secure Sensitive Configurations:
`mvn clean -Djasypt.encryptor.password=${PASSWORD} spring-boot:run`

Secure Sensitive Configurations in IDEA:\
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

* Edit pom.xml: `artifactId`, `build.finalName` values (*e.g. app-server*)
* Edit maven package: edit `jacoco-maven-plugin`, `sonar-project.properties`, `ApplicationResourceBeans.java`
* Edit sonar-project.properties: `sonar.projectKey`, `sonar.projectName` values (*e.g. app-server*)
* Edit application-***.yml (files): `server.port`, `appConfigs.cors.enabled`
* Edit Jenkinsfile: `notifications() -> emailext ->  to` values (*e.g. $TEAM_DEVELOPERS*)
* Edit /jenkins: `APP`
* Edit docke scripts: `APP`
* Edit com.forcelate.Application.java: LOGGER message
* Edit README :)
* Deployment: https://github.com/forcelate/forcelate-skeletons/wiki/Deployment-Guide:-Spring-Boot-on-Ubuntu
