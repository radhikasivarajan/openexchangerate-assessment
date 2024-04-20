This is a Maven project built using Java-Cucumber intending to test Open Exchange Rate API with just a single endpoint covered- "https://open.er-api.com/v6/latest/USD"

Pre-Requisites: 

  Java 17 or higher
  
  Maven 3.8.1 or higher
  
  Any Java IDE
  

The project follows the standard Java Test framework folder structure. The feature file is located at src/test/resources/features/ExchangeRates.feature and it has a single test that covers all the acceptance criteria mentioned in the 
assessment. The API endpoint is currently passed as a test input from this feature file. 

The test can be executed either via Terminal/Command Prompt by running the command - 'mvn clean test' or via Junit or Cucumber Run configuration using any standard IDEs. The runner class resides at src/test/java/org/assessment/tests/testrunner.java
and the test reports are available in 3 different formats in the output folder 'target' as
JSON = target/cucumber-reports-api/Cucumber.json
XML = target/cucumber-reports-api/Cucumber.xml
HTML = target/cucumber-reports-api/report.html

