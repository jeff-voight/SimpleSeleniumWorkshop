package org.voight.properties;


import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TestPropertiesTest {
    private TestingProperties testProperties = new TestingProperties();


    @Test(expected = FileNotFoundException.class)
    public void testStringConstructorException() throws IOException {
        TestingProperties dud = new TestingProperties(new FileReader("/src/blah"));
        Assert.fail("Unless you made a /src/blah file with a bunch of properties, this shouldn't have worked.");
    }

    @Test
    public void testKeys() {
        List<String> keys = testProperties.keys("chrome");
        assertTrue("There must be at least one chrome instance defined in the default properties.", !keys.isEmpty());
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
