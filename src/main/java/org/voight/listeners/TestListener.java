package org.voight.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.logging.Logger;

public class TestListener extends RunListener {
    private Logger log = Logger.getLogger("TestListener.class");


    public TestListener() {
        // By default, this is dumb simple. Just do nothing but log things.
        // If you like, you can extend this to be something like
        // JiraRequirementsReportingListener
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        super.testRunFinished(result);
    }

    @Override
    public void testSuiteStarted(Description description) throws Exception {
        super.testSuiteStarted(description);
    }

    @Override
    public void testSuiteFinished(Description description) throws Exception {
        super.testSuiteFinished(description);
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        super.testAssumptionFailure(failure);
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
    public void testRunStarted(Description description) throws Exception {
        super.testRunStarted(description);
    }

    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void testFinished(Description description) {
        log.info(description.getMethodName()+ " was successful.");
    }

    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */



    /**
     * This is where you would publish the results.
     *
     * @param iTestResult
     */
    @Override
    public void testIgnored(Description description) {
        log.info(description.getMethodName() + " was skipped.");
    }

//    /**
//     * For one, how dare you. For two,
//     * This is where you would publish the results.
//     *
//     * @param iTestResult
//     */
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        Reporter.log("How dare you.", true);
//        log.info("How dare you.");
//    }

    @Override
    public void testStarted(Description description) {
//        String[] excludedGroups = iTestContext.getExcludedGroups();
//        for (String excludedGroup : excludedGroups) {
//            log.info(excludedGroup + " was excluded.");
//        }
//        String[] includedGroups = iTestContext.getIncludedGroups();
//        for (String includedGroup : includedGroups) {
//            log.info(includedGroup + " was included.");
//        }
        log.info(description.getTestClass().getName() + " - " + description.getDisplayName() + " starting.");
    }

}
