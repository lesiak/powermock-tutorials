package com.test.powermock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AppConfig.class })
public class AppConfigTest {

    public AppConfigTest() {
    }

    @Mock
    private AppConfig appConfig;

@Before
public void setUp() throws Exception
{
    PowerMockito.when(appConfig.getApplicationName()).thenReturn("SomeValue");
    AppConfig beforeInitMocks = appConfig;
    MockitoAnnotations.initMocks(this);
    AppConfig afterInitMocks = appConfig;
    System.out.println("Same object?: " + (beforeInitMocks == afterInitMocks));
}

    @Test
    public final void testRegister() throws Exception
    {

        int aaa = 0;
        // myServiceRegistration.register();
    }

}