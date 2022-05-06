package com.qik.qa.listeners;

import com.qik.qa.reports.ExtentLogger;
import com.qik.qa.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite arg0) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            System.err.println("Error on listener class:::: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ISuite arg0) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext arg0) {
        /*
         * We don't any special implementation
         */
    }

    @Override
    public void onStart(ITestContext arg0) {
        /*
         * We don't any special implementation
         */

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        /*
         * For now, it won't be used.
         */

    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(result.getThrowable().getMessage());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {


        try {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
            ExtentLogger.pass(result.getTestName());

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
