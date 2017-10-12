package com.epam.lab;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    private static final Logger LOG = Logger.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info("Test just start" + iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info("Test succesfull" + iTestResult.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.info("Test fail" + iTestResult.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.info("Test skipped" + iTestResult.getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult ) {
        LOG.info("Test fail but within success percentage" + iTestResult.getTestName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOG.info("Test start" + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOG.info("Test finish" + iTestContext.getName());
    }
}
