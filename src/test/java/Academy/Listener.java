package Academy;

import Resources.Base;
import Resources.ExtendReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.*;
import org.testng.ITestResult;

import java.io.IOException;


public class Listener extends Base implements ITestListener {
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extend.flush();
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test passed");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testMethod = result.getMethod().getMethodName();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethod, driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ExtentReports extend = ExtendReporterNG.config();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onTestStart(ITestResult result) {
        test = extend.createTest(result.getMethod().getMethodName());
        ITestListener.super.onTestStart(result);
        extentTest.set(test);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }
}
