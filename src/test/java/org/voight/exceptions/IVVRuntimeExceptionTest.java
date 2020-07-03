package org.voight.exceptions;

import org.junit.Test;

public class IVVRuntimeExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testIVVRuntimeExceptionTest(){
        throw new IVVRuntimeException("This message");
    }
}
