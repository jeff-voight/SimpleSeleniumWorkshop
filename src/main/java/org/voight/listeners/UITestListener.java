package org.voight.listeners;

import java.util.logging.Logger;

public class UITestListener extends TestListener {
    private static final String BROWSER = "browser";
    private Logger log = Logger.getLogger("UITestListener.class");

//    public UITestListener() {
//        super();
//    }
//
//    @Override
//    public void onStart(ITestContext context){
//        super.onStart(context);
//        context.setAttribute(BROWSER, DeviceFactory.getDevice("chrome"));
//    }
//
//    /**
//     * This is where you would publish the results.
//     *
//     * @param iTestResult
//     */
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        super.onTestFailure(iTestResult);
//        ITestContext testContext = iTestResult.getTestContext();
//        WebDriver driver = ((RemoteWebDriver)testContext.getAttribute(BROWSER));
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//        String methodName = iTestResult.getName();
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/failsafe-reports";
//            File destFile = new File(reportDirectory + "/failure_screenshots/" + methodName + "_" + formatter.format(calendar.getTime()) + ".png");
//            FileUtils.copyFile(scrFile, destFile);
//            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
//        } catch (IOException e) {
//           log.severe(e.getMessage());
//        }
//        log.severe(iTestResult.getName() + " failed.");
//    }
//
//    /**
//     * For one, how dare you. For two,
//     * This is where you would publish the results.
//     *
//     * @param iTestResult
//     */
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        onTestFailure(iTestResult);
//        log.info("How dare you.");
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        super.onFinish(iTestContext);
//        WebDriver driver = ((RemoteWebDriver)iTestContext.getAttribute(BROWSER));
//        driver.quit();
//    }

}
