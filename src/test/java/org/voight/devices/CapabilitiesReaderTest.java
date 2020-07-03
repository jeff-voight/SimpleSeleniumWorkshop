package org.voight.devices;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.List;
import static org.junit.Assert.*;


public class CapabilitiesReaderTest {

    @Test
    public void testSetGetHeadless() {
        CapabilitiesReader c = new CapabilitiesReader("");
        c.setHeadless(true);
        assertTrue(c.getHeadless());
        c.setHeadless(false);
        assertFalse(c.getHeadless());
    }

    @Test
    public void testGetCapabilities() {
        CapabilitiesReader c = new CapabilitiesReader("chrome");
        DesiredCapabilities capabilities = c.getCapabilities();
        assertEquals(capabilities.getCapability("maxDuration"), "100800");

    }

    @Test
    public void testGetArguments() {
        CapabilitiesReader c = new CapabilitiesReader("chrome");
        List<String> arguments = c.getArguments();
        assertFalse(arguments.isEmpty());
    }

    @Test
    public void testGetArgumentString() {
        CapabilitiesReader c = new CapabilitiesReader("");
        String argString = c.getArgumentString();
        assertEquals(argString, "");
    }
}
