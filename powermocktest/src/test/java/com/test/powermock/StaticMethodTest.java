package com.test.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Foo.class, File.class})
public class StaticMethodTest {

    @Test
    public void test() throws Exception {

        //PowerMockito.spy(Foo.class);
        PowerMockito.mockStatic(Foo.class);
        PowerMockito.doReturn("dummy").when(Foo.class, "static1");
        //PowerMockito.when(Foo.static2()).thenCallRealMethod();
        PowerMockito.when(Foo.staticInput(anyInt())).thenAnswer(invocation -> {
            System.out.println((int)invocation.getArgument(0));
            return "staticInput mock";
        });


        //PowerMockito.doReturn(4).when(Foo.class, "staticInput", anyInt());

        // PowerMockito.do

        /*PowerMockito.when(Foo.staticInput(anyInt())).thenAnswer(invocation -> {
            System.ou/


        //        PowerMockito.doAnswer(new Answer() {
        //            @Override
        //            public Object answer(InvocationOnMock invocation) throws Throwable {
        //                int i = (int) invocation.getArguments()[0];
        //                System.out.println(i);
        //                return i;
        //            }
        //
        //        }).when(Foo.staticInput(anyInt()));
     */

        System.out.println(Foo.static1());
        System.out.println(Foo.static2());
        System.out.println(Foo.staticInput(7));

    }

    @Test
    public void testFileTemp() throws Exception {


        PowerMockito.mockStatic(File.class);
       // PowerMockito.doReturn("dummy").when(Foo.class, "static1");
     //   PowerMockito.doReturn(new File("aaa")).when(File.createTempFile("aa", "bbb"));
//        PowerMockito.when(File.createTempFile(anyString(), anyString())).thenAnswer(invocation -> {
//            //System.out.println((int)invocation.getArgument(0));
////            return "staticInput mock";
//            return new File("aaa");
//        });

//        PowerMockito.mockStatic(File.class);
        File mockFile =  PowerMockito.mock(File.class);
        PowerMockito.when(File.createTempFile(anyString(), anyString())).thenReturn(mockFile);

        File f = File.createTempFile("aa", "bbb");

        //PowerMockito.doReturn(4).when(Foo.class, "staticInput", anyInt());

        // PowerMockito.do

        /*PowerMockito.when(Foo.staticInput(anyInt())).thenAnswer(invocation -> {
            System.ou/


        //        PowerMockito.doAnswer(new Answer() {
        //            @Override
        //            public Object answer(InvocationOnMock invocation) throws Throwable {
        //                int i = (int) invocation.getArguments()[0];
        //                System.out.println(i);
        //                return i;
        //            }
        //
        //        }).when(Foo.staticInput(anyInt()));
     */



    }


}
