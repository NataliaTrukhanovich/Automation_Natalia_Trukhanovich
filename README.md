# Automation_Natalia_Trukhanovich
PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn versions:display-dependency-updates**
[INFO] Scanning for projects...
[INFO]
[INFO] --------------< groupId:Automation_Natalia_Trukhanovich >---------------
[INFO] Building Automation_Natalia_Trukhanovich 1.0-SNAPSHOT                   
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]                                                                                                                
[INFO] --- versions-maven-plugin:2.12.0:display-dependency-updates (default-cli) @ Automation_Natalia_Trukhanovich ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ................. 4.4.0 -> 4.5.0
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS                                                           
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.942 s                                                    
[INFO] Finished at: 2022-09-29T18:08:45+03:00                                  
[INFO] ------------------------------------------------------------------------


PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn versions:display-dependency-updates**
[INFO] Scanning for projects...
[INFO]
[INFO] --------------< groupId:Automation_Natalia_Trukhanovich >---------------
[INFO] Building Automation_Natalia_Trukhanovich 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions-maven-plugin:2.12.0:display-dependency-updates (default-cli) @ Automation_Natalia_Trukhanovich ---
[INFO]   org.seleniumhq.selenium:selenium-java ................. 4.4.0 -> 4.5.0
[INFO]
[INFO] --- versions-maven-plugin:2.12.0:use-latest-versions (default-cli) @ Automation_Natalia_Trukhanovich ---
[INFO] Major version changes allowed
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:4.4.0 to version 4.5.0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.041 s
[INFO] Finished at: 2022-09-29T18:18:00+03:00
[INFO] ------------------------------------------------------------------------


PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn clean test**
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 22.818 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  32.787 s
[INFO] Finished at: 2022-09-29T18:25:56+03:00
[INFO] ------------------------------------------------------------------------

PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn clean test -DsuiteXmlFile=Lecture8**     
[ERROR] Tests run: 2, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 73.886 s <<< FAILURE! - in TestSuite
[ERROR] Lecture8.Lecture8_2.FileDownloadTest  Time elapsed: 62.519 s  <<< FAILURE!
java.lang.AssertionError: File not found expected [true] but found [false]
at Lecture8.Lecture8_2.FileDownloadTest(Lecture8_2.java:87)
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:23 min
[INFO] Finished at: 2022-09-29T18:33:36+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project Automation_Natalia_Trukhanovich: There are test failures
.
[ERROR]
[ERROR] Please refer to C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


Запуск через имя класса
PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn -Dtest="Lecture10LoginTestSaucedemoParametersTest" test -Dusername="standard_user" -Dpassword="se
cret_sauce"**

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.202 s - in Lecture10.Lecture10LoginTestSaucedemoParametersTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  24.734 s
[INFO] Finished at: 2022-09-29T18:58:14+03:00
[INFO] ------------------------------------------------------------------------


Запуск конкретного теста класса
PS C:\Users\Anoosha\Projects\AQA_16-onl\Automation_Natalia_Trukhanovich> **mvn -Dtest="Lecture10LoginTestSaucedemoParametersTest#loginTest" test -Dusername="standard_user" -Dpa
ssword="secret_sauce"**

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.332 s - in Lecture10.Lecture10LoginTestSaucedemoParametersTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.670 s
[INFO] Finished at: 2022-09-29T18:54:27+03:00
[INFO] ------------------------------------------------------------------------

