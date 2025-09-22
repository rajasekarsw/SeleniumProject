package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;

public class Listener implements ITestListener {

    ExtentReports reports;
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {

     extentTest= reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    extentTest.log(Status.PASS,"Passed");
    }

    @Override
    public void onStart(ITestContext context) {


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

        reports=new ExtentReports();
        ExtentSparkReporter reporter=new ExtentSparkReporter("reports1.html");
        reports.attachReporter(reporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL,"Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Skipped");
    }
}
