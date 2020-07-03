package org.voight.devices;

import org.voight.properties.TestingProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapabilitiesReader {
    protected List<String> arguments;
    private DesiredCapabilities desiredCapabilities;
    private Logger log = Logger.getLogger("CapabilitiesReader.class");
    private boolean headless = false;
    private boolean isRemote = false;
    private String remoteHub;

    public CapabilitiesReader(String device) {
        String deviceString = device.toLowerCase();
        HashMap<String, String> capabilitiesMap = new HashMap<>();
        TestingProperties t = new TestingProperties();
        List<String> keys = t.keys(deviceString);
        keys.forEach(key -> capabilitiesMap.put(key, t.get(key)));
        desiredCapabilities = new DesiredCapabilities();
        arguments = new ArrayList<>();
        Pattern c = Pattern.compile(".*capability\\.(.*)");
        Pattern a = Pattern.compile(".*argument\\.(.*)");
        Pattern headlessPattern = Pattern.compile(".*headless");
        Pattern remotePattern = Pattern.compile(".*hub.url");
        capabilitiesMap.keySet().forEach(key -> {
            Matcher cap = c.matcher(key);
            Matcher arg = a.matcher(key);
            Matcher headlessMatcher = headlessPattern.matcher(key);
            Matcher remoteMatcher = remotePattern.matcher(key);
            if (cap.find()) {
                log.fine("Adding capability " + key + " with value " + capabilitiesMap.get(key));
                desiredCapabilities.setCapability(cap.group(1), capabilitiesMap.get(key));
            }
            if (arg.find()) {
                log.fine("Adding argument " + key + " " + capabilitiesMap.get(key));
                arguments.add(capabilitiesMap.get(key));
            }
            if (headlessMatcher.find()) {
                log.fine("Setting headless to " + key + " " + capabilitiesMap.get(key));
                setHeadless(Boolean.parseBoolean(capabilitiesMap.get(key)));
            }
            if(remoteMatcher.find()) {
                isRemote = true;
                remoteHub = capabilitiesMap.get(key);
                log.fine("Setting remote hub to " + key + " " + remoteHub);
            }
        });
    }

    public boolean getHeadless() {
        return headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public DesiredCapabilities getCapabilities() {
        return desiredCapabilities;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public String getArgumentString() {
        return getArgumentString(arguments);
    }

    public String getArgumentString(List<String> argumentList) {
        StringBuilder argumentString = new StringBuilder();
        argumentList.forEach(argument -> argumentString.append(" ").append(argument));
        log.fine("Argument String: \"" + argumentString.toString());
        return argumentString.toString();
    }

    public boolean isRemote() {
        return isRemote;
    }

    public String getRemoteHub() {
        return remoteHub;
    }
}
