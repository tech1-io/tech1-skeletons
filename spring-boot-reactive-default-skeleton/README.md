# spring-boot-reactive-default-skeleton
Spring Boot Default Skeleton [Reactive] — Spring Boot, LOGGER

### Under Development
ONLY DRAFT...

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
* Edit sonar-project.properties: `sonar.projectKey`, `sonar.projectName` values (*e.g. app-server*)
* Edit application-***.yml (files): `server.port`, `appConfigs.cors.enabled`
* Edit com.forcelate.Application.java: LOGGER message
* Edit README :)
* Deployment: https://github.com/forcelate/forcelate-skeletons/wiki/Installation-Guide:-Spring-Boot-on-Ubuntu

### Verify

```bash
curl -X GET http://localhost:8484/api/user | json_pp
```

```bash
curl -X POST http://localhost:8484/api/message | json_pp
```