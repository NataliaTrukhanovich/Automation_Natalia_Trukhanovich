package Lecture9;

import lombok.extern.log4j.Log4j;
import org.testng.Reporter;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
@Log4j
public class Lecture9_1Test extends BaseTest {

    @BeforeTest(groups = "test91")
    public void beforeTest() {log.debug("Hello i am @BeforeTest");}

    @BeforeMethod(groups = "test91")
    public void beforeMethod() {log.debug("Hello i am @BeforeMethod");}

    @BeforeClass(groups = "test9")
    public void beforeClass() {log.debug("Hello i am @BeforeClass");}

    @BeforeSuite(groups = "test9")
    public void beforeSuite() {log.debug("Hello i am @BeforeSuite");}

    @BeforeGroups(groups = "test9")
    public void beforeGroups() {log.debug("Hello i am @BeforeGroups");}

    @Test(groups = "test9")
    public void test1() {
        Reporter.log("Hello i'm Test1");
        log.debug("Hello i am @Test 1");}

    @Test(groups = "test9new")
    public void test2() {
        log.debug("Hello i am @Test 2");
    }

    @AfterTest(groups = "test9")
    public void afterTest() {
        log.debug("Hello i am @AfterTest");
    }

    @AfterSuite(groups = "test9")
    public void afterSuite() {
        log.debug("Hello i am @AfterSuite");
    }

    @AfterGroups(groups = "test9")
    public void afterGroups() {
        log.debug("Hello i am @AfterGroups");
    }

    @AfterMethod
    public void afterMethod() {
        log.debug("Hello i am @AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        log.debug("Hello i am @AfterClass");
    }
}
