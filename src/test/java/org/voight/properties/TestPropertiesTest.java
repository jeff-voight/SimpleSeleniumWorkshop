package org.voight.properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertTrue;

public class TestPropertiesTest {
    private TestingProperties testProperties = new TestingProperties();


    @Test(expectedExceptions = {FileNotFoundException.class})
    public void testStringConstructorException() throws IOException {
        TestingProperties dud = new TestingProperties(new FileReader("/src/blah"));
        Assert.fail("Unless you made a /src/blah file with a bunch of properties, this shouldn't have worked.");
    }

    @Test
    public void testKeys() {
        List<String> keys = testProperties.keys("chrome");
        Assert.assertTrue(!keys.isEmpty(), "There must be at least one chrome instance defined in the default properties.");
        keys = testProperties.keys("");
        assertTrue(keys.isEmpty());
        keys = testProperties.keys(null);
        assertTrue(keys.isEmpty());
    }

    @Test
    public void testGetValue() {
        String key = testProperties.get("chrome.name");
        assertTrue(!key.isEmpty());
    }

    @Test
    public void testReaderConstructor() throws IOException {
        Reader f = mock(Reader.class);
        TestingProperties dud = new TestingProperties(f);
    }
}
