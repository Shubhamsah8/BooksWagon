package com.bookswagon.qa.listener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bookswagon.qa.baseclass.BaseClass;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        extentReports.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentReports.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        extentReports.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        //extentReports.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }
}
