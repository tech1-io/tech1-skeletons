# spring-boot-default-skeleton
Spring Boot Default Skeleton — Spring Boot, LOGGER

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
