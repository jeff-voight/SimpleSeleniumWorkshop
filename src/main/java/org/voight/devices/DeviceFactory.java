package org.voight.devices;

import org.voight.exceptions.IVVRuntimeException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import static io.github.bonigarcia.wdm.DriverManagerType.OPERA;

/**
 * DeviceFactory builds your RemoteWebDriver devices for you.
 * By default, it handles HTMLUNIT, CHROME, INTERNETEXPLORER, EDGE, OPERA, SAFARI, ANDROID, IPHONE, IPAD
 * These values are capitalized to remind you that your choices are limited unless you choose to extend this class.
 */
public class DeviceFactory {
    private Logger log = Logger.getLogger("DeviceFactory.class");

    public DeviceFactory() {
        log.fine("Constructor");
    }

    /**
     * Fetches the specified configuration from the testautomation.properties
     * config file and instantiates a RemoteWebDriver based on that config.
     * This may be troublesome as in order to add more platforms, one would have
     * to add them to this file or extend this class. That is the reason that null is
     * included at the end is so that an extending class can determine whether or not
     * a webdriver is already implemented or not and in what order they want to do it
     * in.
     * <p>
     * Also of note is that the device capabilities defined in the testautomation.properties
     * for remote hubs must match what the remote hub is running. This is another way that
     * this approach is fragile.
     * <p>
     * Keep in mind, you are under no obligation to use this factory class. In fact, in many
     * cases, it is easier to create your own RemoteWebDriver right in the test setup
     * step. This way, you can use whatever capabilities you feel like passing in during
     * runtime instead of what Jeff thought you'd want to use forever until somebody updates
     * the code. That said, this code can be used as an example. The only difference
     * between doing it this way and doing it by hand is that I read and parse a permanent
     * config file to figure out what capabilities to use. It's nothing you couldn't do at
     * runtime on your own and use whatever configuration fits your needs.
     * <p>
     * This is all to say that the rest of the code doesn't care which RemoteWebDriver it's using.
     * If you mess it up, all that will happen is you'll lose some scrolling and device-specific
     * features.
     *
     * @param deviceName A String containing the name of the device to instantiate.
     *                   This is currently limited to Chrome, Firefox, Internetexplorer,
     *                   edge, opera, safari, android, iPhone, and iPad.
     * @return A RemoteWebDriver containing the capabilities defined in testautomation.properties
     * for that particular device. If a device can not be found or it hasn't been implemented yet,
     * this will return null.
     */
    public static RemoteWebDriver getDevice(String deviceName) {
        CapabilitiesReader capabilitiesReader = new CapabilitiesReader(deviceName);
        switch (deviceName.toLowerCase()) {
            case "chrome":
                return getChromeDriver(capabilitiesReader);
            case "firefox":
                return getFirefoxDriver(capabilitiesReader);
            case "internetexplorer":
            case "ie":
                return getInternetExplorerDriver(capabilitiesReader);
            case "edge":
                return getEdgeDriver(capabilitiesReader);
            case "opera":
                return getOperaDriver(capabilitiesReader);
            case "safari":
                return getSafariDriver(capabilitiesReader);
            case "android":
                return getAndroidDriver(capabilitiesReader);
            case "iPhone":
                return getIPhoneDriver(capabilitiesReader);
            case "iPad":
                return getIPadDriver(capabilitiesReader);
            default:
                return null;
        }
    }

    protected static RemoteWebDriver getIPadDriver(CapabilitiesReader capabilitiesReader) {
        return new IOSDriver<>(capabilitiesReader.getCapabilities());
    }

    protected static RemoteWebDriver getIPhoneDriver(CapabilitiesReader capabilitiesReader) {
        return new IOSDriver<>(capabilitiesReader.getCapabilities());
    }

    protected static RemoteWebDriver getAndroidDriver(CapabilitiesReader capabilitiesReader) {
        return new AndroidDriver(capabilitiesReader.getCapabilities());
    }

    protected static RemoteWebDriver getSafariDriver(CapabilitiesReader capabilitiesReader) {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.merge(capabilitiesReader.getCapabilities());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), safariOptions);
        } else {
            return new SafariDriver(safariOptions);
        }
    }

    protected static RemoteWebDriver getOperaDriver(CapabilitiesReader capabilitiesReader) {
        System.setProperty("webdriver.opera.driver", "/home/jeff/Downloads/operadriver_linux64/operadriver");
        OperaDriverManager.getInstance(OPERA).forceCache().setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.merge(capabilitiesReader.getCapabilities());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), operaOptions);
        } else {
            return new OperaDriver(operaOptions);
        }
    }

    private static RemoteWebDriver getEdgeDriver(CapabilitiesReader capabilitiesReader) {
        WebDriverManager.edgedriver().forceCache().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.merge(capabilitiesReader.getCapabilities());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), edgeOptions);
        } else {
            return new EdgeDriver(edgeOptions);
        }
    }

    protected static RemoteWebDriver getInternetExplorerDriver(CapabilitiesReader capabilitiesReader) {
        WebDriverManager.iedriver().forceCache().setup();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.merge(capabilitiesReader.getCapabilities());
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.addCommandSwitches(capabilitiesReader.getArgumentString());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), internetExplorerOptions);
        } else {
            return new InternetExplorerDriver(internetExplorerOptions);
        }
    }

    protected static RemoteWebDriver getFirefoxDriver(CapabilitiesReader capabilitiesReader) {
        WebDriverManager.firefoxdriver().forceCache().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilitiesReader.getCapabilities());
        firefoxOptions.addArguments(capabilitiesReader.getArguments());
        firefoxOptions.setHeadless(capabilitiesReader.getHeadless());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), firefoxOptions);
        } else {
            return new FirefoxDriver(firefoxOptions);
        }
    }

    protected static RemoteWebDriver getChromeDriver(CapabilitiesReader capabilitiesReader) {
        WebDriverManager.chromedriver().forceCache().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilitiesReader.getCapabilities());
        chromeOptions.addArguments(capabilitiesReader.getArguments());
        chromeOptions.setHeadless(capabilitiesReader.getHeadless());
        if (capabilitiesReader.isRemote()) {
            return getRemoteWebDriver(capabilitiesReader.getRemoteHub(), chromeOptions);
        } else {
            return new ChromeDriver(chromeOptions);
        }
    }

    private static RemoteWebDriver getRemoteWebDriver(String hub, Capabilities options) {
        try {
            URL url = new URL(hub);
            return new RemoteWebDriver(url, options);
        } catch (IOException ioe) {
            throw new IVVRuntimeException("**** URL \"" + hub + "\" was unreadable.");
        }
    }


}
