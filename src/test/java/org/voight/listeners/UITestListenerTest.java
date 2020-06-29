package org.voight.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class UITestListenerTest {

    private static final String BROWSER = "browser";
    private WebDriver driver;
    private UITestListener r = new UITestListener();

    private ITestContext context;

    @BeforeMethod
    public void setupContext(ITestContext context) {
        this.context = context;
        driver = (WebDriver) context.getAttribute(BROWSER);
    }

    private ITestResult getDummyITestResult() {
        return new ITestResult() {
            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public void setStatus(int status) {

            }

            @Override
            public ITestNGMethod getMethod() {
                return null;
            }

            @Override
            public Object[] getParameters() {
                return new Object[0];
            }

            @Override
            public void setParameters(Object[] parameters) {

            }

            @Override
            public IClass getTestClass() {
                return null;
            }

            @Override
            public Throwable getThrowable() {
                return null;
            }

            @Override
            public void setThrowable(Throwable throwable) {

            }

            @Override
            public long getStartMillis() {
                return 0;
            }

            @Override
            public long getEndMillis() {
                return 0;
            }

            @Override
            public void setEndMillis(long millis) {

            }

            @Override
            public String getName() {
                return "Demo Name";
            }

            @Override
            public boolean isSuccess() {
                return false;
            }

            @Override
            public String getHost() {
                return null;
            }

            @Override
            public Object getInstance() {
                return null;
            }


            @Override
            public String getTestName() {
                return null;
            }


            @Override
            public String getInstanceName() {
                return null;
            }

            @Override
            public ITestContext getTestContext() {
                return context;
            }

            @Override
            public int compareTo(ITestResult o) {
                return 0;
            }

            @Override
            public Object getAttribute(String name) {
                return null;
            }

            @Override
            public void setAttribute(String name, Object value) {

            }

            @Override
            public Set<String> getAttributeNames() {
                return null;
            }

            @Override
            public Object removeAttribute(String name) {
                return null;
            }
        };
    }

    @Test
    public void testOnTestFailure() {
        driver.get("https://www.google.com");
        r.onTestFailure(getDummyITestResult());
    }

    @Test
    public void testOnTestFailedButWithinSuccessPercentage() {
        r.onTestFailedButWithinSuccessPercentage(getDummyITestResult());
    }
}
