package org.voight.exceptions;

import org.junit.Test;

public class PendingExceptionTest {

    @Test(expected = PendingException.class)
    public void constructorTest() {
        throw new PendingException("This is the exception.");
    }

    @Test(expected = PendingException.class)
    public void defaultConstructorTest(){
        throw new PendingException();
    }
}
