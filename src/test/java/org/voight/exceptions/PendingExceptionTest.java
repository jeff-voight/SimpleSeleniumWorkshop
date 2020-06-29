package org.voight.exceptions;

import org.testng.annotations.Test;


public class PendingExceptionTest {

    @Test(expectedExceptions = PendingException.class)
    public void constructorTest() {
        throw new PendingException("This is the exception.");
    }

    @Test(expectedExceptions = PendingException.class)
    public void defaultConstructorTest(){
        throw new PendingException();
    }
}
