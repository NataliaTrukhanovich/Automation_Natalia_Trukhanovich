package testNGUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 1;
    private static final int MAX_RETRY = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < MAX_RETRY) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                System.out.println("Retrying once again");
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
