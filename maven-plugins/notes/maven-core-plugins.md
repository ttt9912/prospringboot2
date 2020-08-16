# Core Plugins

## Maven Surefire Plugin
Executing tests

### Goals
- `test` - run tests (bound to the **test** phase of the default build lifecycle, and the 
command mvn test will execute it.)

### Test naming pattern
Executes tests mathching the naming pattern:

_Test*.java, *Test.java, *Tests.java, *TestCase.java_

Change this configuration using the `excludes` and `includes` parameters in pom.

### Reports
Generates XML reports in the directory `target/surefire-reports`.

### Configuration
- includes/excludes

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        ...
     </configuration>
</plugin>
```


## Maven Failsafe Plugin
integration tests

### Goals
- `integration-test` – run integration tests (bound to the **integration-test** phase)
- `verify` – verify that the integration tests passed (**verify** phase)

A test failure in the integration-test phase doesn't fail the build straight away, allowing the phase 
**post-integration-test** to execute, where clean-up operations are performed.

Failed tests, if any, are only **reported** during the verify phase, after the integration test 
environment has been torn down properly.

### Test naming pattern
Executes tests mathching the naming pattern:

_IT*.java, *IT.java, *ITCase.java_

### Reports
Generates XML reports in the directory `target/failsafe-reports`.

### Failsafe vs. Surefire
Both execute tests and can be configured the same way

**Surefire** fails the build immediately if any test fails (best for unit tests)

**Failsafe** decouples failing the build if there are test failures from actually running the tests
using 2 goals (best for integration tests)


## Maven Compiler Plugin
Compiles the source code of a Maven project

### Goals
- `compile` – compile main source files (bound to **compile** phase)
- `testCompile` – compile test source files (**test-compile** phase)

### Configuration

#### Java version
- `<source>` and `<target>` in the `<configuration>` section
- `<maven.compiler.source>` `<maven.compiler.source>` in `<properties>`

#### javac arguments
`<compilerArgs>` in the `<configuration>` section


## Maven Verifier Plugin
Verifies the existence or non-existence of files and directories

### Goals
- `verify` - (bound to the **integration-test** phase)

### verification file
xml describing files to verify for existence and content


## Maven Install plugin
Adds artifacts to the local repository

### Goals
- `install` - (bound to the **install** phase)
- `install-file` - automatically install external artifacts into the local repository

### No extra config needed
This plugin is included in the super POM, therefore a POM doesn't need to explicitly include it.

In most cases, the install plugin doesn't need any custom configuration. 


## Maven Deploy Plugin
Pushing artifacts to a remote repository (e.g. Nexus)

### Goals
- `deploy` - (bound to the deploy phase)
- `deploy-file` - deploying an artifact in a remote repository


## Maven Enforcer Plugin
Used to guarantee the level of compliance in our project

### Goals
- `enforce` - executes rules specified in the configuration
- `display-info` - shows current information about the built-in rules that are present in the project's pom.xml

### Define rules
Define rules in `<executions>` section

### Available rules
- `<banDuplicatePomDependencyVersions/>` - for multi-module projects
- `<requireMavenVersion>`
- `<requireJavaVersion>`
- `<requireEnvironmentVariable>`
- `<requireActiveProfile>`
- `<bannedPlugins>`
- ...

### Breaking rules
By default, build is broken

Let build succeed and only log broken rule using `<level>WARN</level>`

### Create custom rules
Extend `EnforceRule` and implement `execute()`.
Just throw an `EnforcerRuleException` when rule is broken.