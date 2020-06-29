package org.voight.listeners;

import com.google.inject.Injector;
import com.google.inject.Module;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IAnnotationFinder;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestListenerTest {

    ITestContext c = new ITestContext() {
        @Override
        public Object getAttribute(String s) {
            return null;
        }

        @Override
        public void setAttribute(String s, Object o) {

        }

        @Override
        public Set<String> getAttributeNames() {
            return null;
        }

        @Override
        public Object removeAttribute(String s) {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public Date getStartDate() {
            return null;
        }

        @Override
        public Date getEndDate() {
            return null;
        }

        @Override
        public IResultMap getPassedTests() {
            return null;
        }

        @Override
        public IResultMap getSkippedTests() {
            return null;
        }

        @Override
        public IResultMap getFailedButWithinSuccessPercentageTests() {
            return null;
        }

        @Override
        public IResultMap getFailedTests() {
            return null;
        }

        @Override
        public String[] getIncludedGroups() {
            String[] includes = {"One", "Two"};
            return includes;
        }

        @Override
        public String[] getExcludedGroups() {
            return new String[0];
        }

        @Override
        public String getOutputDirectory() {
            return null;
        }

        @Override
        public ISuite getSuite() {
            ISuite i = new ISuite() {
                @Override
                public String getName() {
                    return "Dummy name";
                }

                @Override
                public Map<String, ISuiteResult> getResults() {
                    return null;
                }

                @Override
                public IObjectFactory getObjectFactory() {
                    return null;
                }

                @Override
                public IObjectFactory2 getObjectFactory2() {
                    return null;
                }

                @Override
                public String getOutputDirectory() {
                    return null;
                }

                @Override
                public String getParallel() {
                    return null;
                }

                @Override
                public String getParentModule() {
                    return null;
                }

                @Override
                public String getGuiceStage() {
                    return null;
                }

                @Override
                public String getParameter(String s) {
                    return null;
                }

                @Override
                public Map<String, Collection<ITestNGMethod>> getMethodsByGroups() {
                    return null;
                }

                /**
                 * @deprecated
                 */
                @Override
                public Collection<ITestNGMethod> getInvokedMethods() {
                    return null;
                }

                @Override
                public List<IInvokedMethod> getAllInvokedMethods() {
                    return null;
                }

                @Override
                public Collection<ITestNGMethod> getExcludedMethods() {
                    return null;
                }

                @Override
                public void run() {

                }

                @Override
                public String getHost() {
                    return null;
                }

                @Override
                public SuiteRunState getSuiteState() {
                    return null;
                }

                @Override
                public IAnnotationFinder getAnnotationFinder() {
                    return null;
                }

                @Override
                public XmlSuite getXmlSuite() {
                    return null;
                }

                @Override
                public void addListener(ITestNGListener iTestNGListener) {

                }

                @Override
                public Injector getParentInjector() {
                    return null;
                }

                @Override
                public void setParentInjector(Injector injector) {

                }

                @Override
                public List<ITestNGMethod> getAllMethods() {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public Set<String> getAttributeNames() {
                    return null;
                }

                @Override
                public Object removeAttribute(String s) {
                    return null;
                }
            };
            return i;
        }

        @Override
        public ITestNGMethod[] getAllTestMethods() {
            return new ITestNGMethod[0];
        }

        @Override
        public String getHost() {
            return null;
        }

        @Override
        public Collection<ITestNGMethod> getExcludedMethods() {
            return null;
        }

        @Override
        public IResultMap getPassedConfigurations() {
            return null;
        }

        @Override
        public IResultMap getSkippedConfigurations() {
            return null;
        }

        @Override
        public IResultMap getFailedConfigurations() {
            return null;
        }

        @Override
        public XmlTest getCurrentXmlTest() {
            return null;
        }

        @Override
        public List<Module> getGuiceModules(Class<? extends Module> aClass) {
            return null;
        }

        @Override
        public Injector getInjector(List<Module> list) {
            return null;
        }

        @Override
        public Injector getInjector(IClass iClass) {
            return null;
        }

        @Override
        public void addInjector(List<Module> list, Injector injector) {

        }
    };
    private TestListener r = new TestListener();

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
                return null;
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
        r.onTestFailure(getDummyITestResult());
    }

    @Test
    public void testOnTestSkipped() {
        r.onTestSkipped(getDummyITestResult());
    }

    @Test
    public void testOnTestFailedButWithinSuccessPercentage() {
        r.onTestFailedButWithinSuccessPercentage(getDummyITestResult());
    }

    @Test
    public void testIncludedGroups() {
        r.onStart(c);
    }
}
