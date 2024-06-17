package utils;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import driver_init.DriverInit;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class MyAllureTestListeners implements ITestListener {
    static TestRail testRail;
    static Run run;
    static List<ResultField> resultFieldList;

    @Override
    public void onStart(ITestContext context) {
        String testRailUrl = "https://monkey1997.testrail.io/";
        String password = "maestro26&Kitty";
        String userName = "shadeofkitty@game.cmm";
        testRail = TestRail
                .builder(testRailUrl, userName, password)
                .applicationName("TestRailIntergation").build();
        String time = String.format("%1$tH:%1$tM", new Date());
        run = testRail.runs().add(1, new Run().setName("Idea Run " + time)).execute();
        resultFieldList = testRail.resultFields().list().execute();
    }
    @Override
    public void onFinish(ITestContext context) {
        testRail.runs().close(run.getId()).execute();
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " skipped!!!");
        testRail.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(4), resultFieldList).execute();
    }
    public static int returnCaseId(String methodName) {
        return Integer.parseInt(methodName.split("_C")[1]);
    }
    public static void makeScreenShot(String name) {
        File screenshotFile = ((TakesScreenshot) DriverInit.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + name + ".png"));
        } catch (IOException e) {
        }
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " passed!!!");
        testRail.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(1), resultFieldList).execute();
    }
    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenShot(result.getMethod().getMethodName());
        testRail.results().addForCase(run.getId(), returnCaseId(result.getMethod().getMethodName()), new Result().setStatusId(5), resultFieldList).execute();
    }
}
