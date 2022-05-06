package com.qik.qa.utils;

import com.qik.qa.vendors.APIClient;

import java.util.HashMap;
import java.util.Map;

public class TestRailManager {

    private static final String TEST_RUN_ID = "9630";
    private static final String TESTRAIL_USERNAME = "jason.choi@reeftechnology.com";
    private static final String TESTRAIL_PASS = "testrail123!";
    private static final String TESTRAIL_ENGINE_URL = "https://reef.testrail.io/";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    public static final int TEST_CASE_SKIPPED_STATUS = 3;
    static APIClient client;


    private TestRailManager() {
    }

    public static void addResultForTestCase(String testCaseId, int status, String localizedMessage) throws Exception {
        Map<String, Object> data;
        String testRunId = TEST_RUN_ID;
        client = new APIClient(TESTRAIL_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASS);
        data = new HashMap<>();
        data.put("status_id", status);
        data.put("comment", "Test");
        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"", data);

    }

}
