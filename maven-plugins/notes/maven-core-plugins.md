# Core Plugins

## Surefire plugin
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


## Failsafe plugin
integration tests

### Goals
- `integration-test` – run integration tests (bound to the **integration-test** phase)
- `verify` – verify that the integration tests passed (**verify phase**)

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
