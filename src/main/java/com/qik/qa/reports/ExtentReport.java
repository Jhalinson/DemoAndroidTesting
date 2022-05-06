package com.qik.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qik.qa.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {

    }

    public static void initReports() throws Exception {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Reef Android Automation Report");
            extent.attachReporter(spark);
        }
        extent.setSystemInfo("Company Name", "Reef Technology");
        extent.setSystemInfo("Project Name", "Reef Mobile");
        extent.setSystemInfo("Dept", "QA");
        extent.setSystemInfo("SDET Name", "Jhalinson Acosta");


    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createTest(String testCaseName) {

        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

}
