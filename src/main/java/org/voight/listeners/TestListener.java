package org.voight.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.logging.Logger;

public class TestListener implements ITestListener {
    private Logger log = Logger.getLogger("TestListener.class");


    public TestListener() {
        // By default, this is dumb simple. Just do nothing but log things.
        // If you like, you can extend this to be something like
        // JiraRequirementsReportingListener
    }

    /**
     * Do any setup here that you want to have long-lasting results for this
     * test. If you want to store the results before the test has even started,
     * for instance the exact millisecond it started, now is the time.
     * However, now is not the time to store results.
     * Maybe you want to inject a log message about the previous time this
     * test was run, it failed.
     * Maybe you want to inspect the name of the test to ensure that it contains the
     * appropriate tags.
     * You might have a half a dozen of these requirements listeners. You might
     * have a jira consumer, a github consumer, and a confluence consumer.
     * Maybe you have a jenkins remote server that needs to notify an admin that
     * somebody is about to start a test?
     *
     * @param iTestResult
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
        // Retrieve Previous Results and spit them out into the log. Stash them.
        log.info(iTestResult.getName() + " starting.");
    }

    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(iTestResult.getName() + " was successful.");
    }

    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // Could collect environment variables and whatnot to report to see what else might be wrong
        log.info(iTestResult.getName() + " failed.");
    }

    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(iTestResult.getName() + " was skipped.");
    }

    /**
     * For one, how dare you. For two,
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Reporter.log("How dare you.", true);
        log.info("How dare you.");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        String[] excludedGroups = iTestContext.getExcludedGroups();
        for (String excludedGroup : excludedGroups) {
            log.info(excludedGroup + " was excluded.");
        }
        String[] includedGroups = iTestContext.getIncludedGroups();
        for (String includedGroup : includedGroups) {
            log.info(includedGroup + " was included.");
        }
        log.info(iTestContext.getSuite().getName() + " - " + iTestContext.getName() + " starting.");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info(iTestContext.getName() + " finishing.");
    }
}
