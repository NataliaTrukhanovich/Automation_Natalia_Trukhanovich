package Lecture9;

import lombok.extern.log4j.Log4j;
import pageObjects.baseObjects.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import testNGUtils.Retry;

import static org.testng.TestRunner.PriorityWeight.priority;

@Log4j
public class Lecture9_2Test extends BaseTest {

        int count = 1;
        int timeout = 4;

        @Test(enabled = false, priority = 1)
        public void test1() {
            log.debug("Hello i'm test 1");
        }

        @Test(enabled = true, priority = 2)
        public void test2() {
            log.debug("Hello i'm test 2");
        }

        @Test(timeOut = 1000, description = "Test 3 from lecture 9", expectedExceptions = ThreadTimeoutException.class, priority = 3)
        public void test3() {
            pause(3);
            log.debug("Hello i'm test 3");
        }

        @Test(dependsOnMethods = "test3", priority = 4)
        public void test4() {
            log.debug("Hello i'm test 4");
        }

        @BeforeMethod
        public void beforeMethod() {
            log.debug("Hello i'm  @BeforeMethod");
        }

        @Test(invocationCount = 5, threadPoolSize = 5, priority = 5)
        public void test5() {
            pause(1);
            log.debug("Hello i'm test 5 and this is my repeat #" + count++);
        }

        @AfterMethod
        public void afterMethod() {
            log.debug("Hello i'm @AfterMethod");
        }

        @Test(timeOut = 1000, priority = 6, retryAnalyzer = Retry.class)
        public void test6() {
            timeout--;
            pause(timeout);
            log.debug("Hello i'm test 6 with timeout #" + timeout);
        }

        private void pause(long timeout) {
            try {
                Thread.sleep(timeout * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
