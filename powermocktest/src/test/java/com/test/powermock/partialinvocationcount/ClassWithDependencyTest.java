package com.test.powermock.partialinvocationcount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilClass.class)
public class ClassWithDependencyTest {

    private static final Logger logger =  LoggerFactory.getLogger(UtilClass.class);

    private ClassWithDependency classWithDependency;

    private UtilClass utilClass;

    @Before
    public void init() throws Exception {
        utilClass = PowerMockito.spy(new UtilClass());
        classWithDependency = new ClassWithDependency(utilClass);
        PowerMockito.when(utilClass,"hi").thenReturn("Hi Java");
        // Dont call thenCallRealMethod on a spy
        // PowerMockito.when(utilClass.hello()).thenCallRealMethod();
    }


    @Test
    public void testMock() throws Exception {
        final String msg = classWithDependency.welcome();

        final String msgExpected = "Hello World,Hi Java";
        logger.info("welcome method called:{}",msg);

        PowerMockito.verifyPrivate(utilClass, Mockito.times(1)).invoke("hi");
        Mockito.verify(utilClass, Mockito.times(1)).hello();

        Assert.assertEquals(msgExpected, msg);
    }
}
