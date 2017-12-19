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

* Edit pom.xml: `artifactId`, `build.finalName` values (*e.g. app-server*)
* Edit sonar-project.properties: `sonar.projectKey`, `sonar.projectName` values (*e.g. app-server*)
* Edit application-***.yml (files): `server.port`, `appConfigs.cors.enabled`
* Edit com.forcelate.Application.java: LOGGER message
* Edit README :)