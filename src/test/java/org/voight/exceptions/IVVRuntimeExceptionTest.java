package org.voight.exceptions;

import org.testng.annotations.Test;


public class IVVRuntimeExceptionTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void testIVVRuntimeExceptionTest(){
        throw new IVVRuntimeException("This message");
    }
}
