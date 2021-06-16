package com.nopcommerce.demo.customListener;

import com.nopcommerce.demo.utility.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("Test start : \t"+iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

       System.out.println("Test success : \t"+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("Test fail : \t"+iTestResult.getName());
        // This step take screenshot and store in to test-output/html folder
        String screenshotName = null;
        try {
            screenshotName = Utility.takeScreenShot(iTestResult.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //This line required for reportNG
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href="+screenshotName+"><img src="+screenshotName+" height=200 width=200></img></a>");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

      //  System.out.println("Test skipped "+iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
