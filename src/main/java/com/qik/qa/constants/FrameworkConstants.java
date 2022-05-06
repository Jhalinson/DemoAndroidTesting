package com.qik.qa.constants;

import com.qik.qa.enums.ConfigProperties;
import com.qik.qa.utils.ReaderPropertyFile;

public class FrameworkConstants {

    private static final String SYSTEM_PATH = System.getProperty("user.dir");
    private static final String CONFIG_PATH = SYSTEM_PATH + "/src/test/java/resources/config.properties";
    private static final String EXCEL_PATH = SYSTEM_PATH + "/src/test/java/resources/dataTest.xlsx";
    private static final String PARALLEL_CONFIG_PATH = "src/test/java/resources/parallel.conf.json";
    private static final long PAGE_LOAD = 15;
    private static final int EXPLICIT_WAIT = 25;
    private static final String EXTENT_REPORT_PATH = SYSTEM_PATH + "/extent-test-output";

    private FrameworkConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static long getPageLoad() {
        return PAGE_LOAD;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    public static String getParallelConfigPath() {
        return PARALLEL_CONFIG_PATH;
    }

    public static String getExtentReportPath() throws Exception {

        return ReaderPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes") ? EXTENT_REPORT_PATH + "/" + "index.html" : "";

    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getConfigPath() {
        return CONFIG_PATH;
    }


}
