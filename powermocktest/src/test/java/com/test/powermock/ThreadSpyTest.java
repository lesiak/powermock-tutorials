package com.test.powermock;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;

public class ThreadSpyTest {
    @Test
    public void testThread() throws InterruptedException
    {
        Thread threada = spy( new Thread( new Runnable()

        {
            @Override
            public void run()
            {
                System.out.println( "on thread" );
            }
        } ) );
        threada.start();
        threada.join();
        System.out.println( "finished test" );
    }
}
