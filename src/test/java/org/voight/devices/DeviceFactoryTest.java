package org.voight.devices;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DeviceFactoryTest {

    @Ignore
    @Test
    public void testGetOperaDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver opera = d.getDevice("OPERA");
        assert opera != null;
        opera.quit();
    }

    @Ignore
    @Test
    public void testGetSafariDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver safari = d.getDevice("SAFARI");
        assert safari != null;
        safari.quit();
    }
    @Ignore
    @Test
    public void testGetInternetExplorerDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver ie = d.getDevice("INTERNETEXPLORER");
        assert ie != null;
        ie.quit();
    }

    @Test
    public void testGetChromeDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver chrome = d.getDevice("CHROME");
        assert chrome != null;
        chrome.quit();
    }

    @Test
    public void testGetFirefoxDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver firefox = d.getDevice("FIREFOX");
        assert firefox != null;
        firefox.quit();
    }

    @Ignore
    @Test
    public void testGetAndroidDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver androidDriver = d.getDevice("ANDROID");
        assert androidDriver != null;
        androidDriver.quit();
    }

    @Test
    public void testGetNoneexistentDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver empty = d.getDevice("NOTADEVICE");
        Assert.assertNull(empty);
    }
}
