package com.test.powermock;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;


@PrepareForTest(EnvironmentUtils.class)
@RunWith(PowerMockRunner.class)
public class EnvironmentUtilsTest {

    @Before
    public void setup() {
        PowerMockito.mockStatic(EnvironmentUtils.class);
    }


    @Test
    public void test_rule_create_rule() throws IOException {
        when(EnvironmentUtils.isCF()).thenReturn(true);

    }
}