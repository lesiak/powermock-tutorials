package com.test.powermock;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateTestJunit4.MyClass.class)
public class PrivateTestJunit4
{

    public static class MyClass {
        public String A() {
            System.out.println("A called");
            return "A";
        }

        private String B() {
            System.out.println("B called");
            return "B";
        }

       public String C() {
            System.out.println("C called");
            return "C" + B();
        }

    }

    @Test
    public void currencyValuesNBP() throws IOException
    {



        UrlWrapper url = PowerMockito.mock(UrlWrapper.class);
        HttpURLConnection httpURLConnection = Mockito.mock(HttpURLConnection.class);
        PowerMockito.when(url.openConnection()).thenReturn(httpURLConnection);
        assertTrue(url.openConnection() instanceof HttpURLConnection);
    }

    class UrlWrapper
    {
        private URL url;

        public UrlWrapper(String spec) throws MalformedURLException
        {
            url = new URL(spec);
        }

        private URLConnection openConnection() throws IOException
        {
            return url.openConnection();
        }
    }


    @Test
    public void testUnpreparedClassNotMockedMethods() {
        MyClass myClass = PowerMockito.mock(MyClass.class);
        System.out.println(myClass.A());
        //System.out.println(myClass.B());
    }

    @Test
    public void testUnpreparedClassMockPublicMethod() throws Exception {
        MyClass myClass = PowerMockito.mock(MyClass.class);
        PowerMockito.when(myClass.A()).thenReturn("mockA");
        //PowerMockito.when(myClass.B()).thenReturn("mockB");
        //PowerMockito.doReturn("mockB").when(myClass, "B");

        System.out.println(myClass.A());
       // System.out.println(myClass.B());
       // System.out.println(myClass.C());
    }

@org.junit.Test
public void testUnpreparedClassMockPrivateMethod() throws Exception {
    MyClass myClass = PowerMockito.mock(MyClass.class);
    PowerMockito.when(myClass.B()).thenReturn("mockB");
    //PowerMockito.when(myClass, "B").thenReturn("mockB");
    System.out.println(myClass.B());
}

    @Test
    public void testUnpreparedClassMockPrivateMethod2() throws Exception {
        MyClass myClass = PowerMockito.spy(new MyClass());
        //PowerMockito.when(myClass, "B").thenReturn("mockB");
       // PowerMockito.doReturn("mockB").when(myClass, "B");
        Point mockPoint = mock(Point.class);
       // PowerMockito.doReturn(new Point(1,2)).when(myClass, "C", anyObject());
        PowerMockito.doReturn(mockPoint).when(myClass, "C", anyObject());
        System.out.println("test starts");
        //System.out.println(myClass.B());
    }


}
