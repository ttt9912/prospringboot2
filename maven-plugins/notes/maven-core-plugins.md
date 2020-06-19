# Core Plugins

## Surefire
By default, this plugin generates XML reports in the directory `target/surefire-reports`.

**goals**: `test`  
(This goal is bound to the test phase of the default build lifecycle, and the 
command mvn test will execute it.)

By default, surefire automatically includes all test classes whose name starts with Test, or ends with Test, Tests or TestCase.
Change this configuration using the `excludes` and `includes` parameters in pom.
