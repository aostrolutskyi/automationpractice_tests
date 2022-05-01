# automationpractice_tests
Test Framework for Automationpractice

## How to Run tests and setup

* First check/change webdrivers for Chrome and Firefox. You can find files in root folder. The webdrivers should be compatible with you operation system.
* Edit pom file in order to specify running tests in parralel. You can find value in section
```
<parallel>methods</parallel>
<threadCount>2</threadCount>
<forkCount>2C</forkCount>
   ```
  Set "threadCount" to value of treads you need. Value of "forkCount" can be used for process threads.
* To run the test run maven command:
```
mvn clean verify
```
* Test report will be located in "target/site/serenity" folder.

