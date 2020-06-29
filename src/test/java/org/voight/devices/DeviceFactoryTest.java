package org.voight.devices;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeviceFactoryTest {

    @Test(groups = {"macos"})
    public void testGetOperaDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver opera = d.getDevice("OPERA");
        assert opera != null;
        opera.quit();
    }

    @Test(groups = {"macos"})
    public void testGetSafariDriver() {
        DeviceFactory d = new DeviceFactory();
        RemoteWebDriver safari = d.getDevice("SAFARI");
        assert safari != null;
        safari.quit();
    }

    @Test(groups = {"windows"})
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

    @Test(groups = {"android"})
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
