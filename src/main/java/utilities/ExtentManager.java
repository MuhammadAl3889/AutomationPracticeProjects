package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void createTest(String testName) {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        test = extent.createTest(testName);
    }

    public static void passScenario(String scenario, String message) {
        test.pass(message);
    }

    public static void failScenario(String scenario, String message) {
        test.fail(message);
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
