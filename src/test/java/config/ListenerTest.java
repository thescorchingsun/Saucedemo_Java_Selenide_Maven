package config;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
@Slf4j
public class ListenerTest extends TestListenerAdapter implements ITestListener {

        @Override
        public void onFinish(ITestContext Result) {
        }

        @Override
        public void onStart(ITestContext Result) {
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
        }

        @Override
        public void onTestFailure(ITestResult Result) {
            log.info(" Название упавшего теста: " + Result.getName());
        }

        @Override
        public void onTestSkipped(ITestResult Result) {
            log.info(" Название пропущенного теста: " + Result.getName());
        }

        @Override
        public void onTestStart(ITestResult Result) {
            log.info("{} Тест запущен", Result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult Result) {
            log.info(" Название пройденного теста: " + Result.getName());
        }
}

