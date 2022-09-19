FinalSurge automatic tests

Final Surge® is the coach, team, club, and athlete training platform that won Triathlete magazine's 2018 Face Off for Best Online Training Log. Always free to athletes, Final Surge empowers athletes and coaches to reach fitness and performance excellence like never before.
Prerequisites installed
1. Java JDK 18.0.1.1 and 1.8.0_341
2. Maven version 3.8.6

Continuous Integration: Jenkins

Setting up config
1. Clone this repository.

2. Enter email and password in config.properties.

3. You can specify the browser (Chrome or Firefox) you want to use in the parameters "browser" of the regression.xml, negative.xml, smoke.xml files, the default is Chrome.

Checklist
1. Verify that user can log in the system.

2. Verify that user can't log in the system with invalid password or email.

3. Verify that user can log out of the system.

4. Verify that user can add workout.

5. Verify that user can add abd delete equipment (a bike).

6. Verify that user can use ‘Other Calculators’ to calculate daily caloric needs.

7. Verify that user can't use ‘Other Calculators’ to calculate daily caloric needs without entering all needed data.

8. Verify that user can use ‘Other Calculators’ to calculate pace.

9. Verify that user can view daily vitals for the selected time period.

10. Verify that user can report on workouts of the selected type for the selected period.

11. Verify that user can open print page with workouts for the selected time period.

Test suites
1. Regression tests
To execute the test suite, simply run: mvn -DsuiteXmlFile="regressionTest.xml" test

2. Smoke tests
To execute the test suite, simply run: mvn -DsuiteXmlFile="smokeTest.xml" test

3. Negative tests
To execute the test suite, simply run: mvn -DsuiteXmlFile="negativeTest.xml" test


Running tests
Run tests using mvn clean test command
mvn clean test

Running a single test and running a set of methods in a single test class
1. mvn -Dtest=BikeTest test

2. mvn -Dtest=OtherCalculatorsTest#paceCalculatorTest test

3. mvn -Dtest=LoginTest#logoutTest+negativeLoginTest test