package com.test.powermock.partialinvocationcount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilClass {

    private static final Logger logger =  LoggerFactory.getLogger(UtilClass.class);

    public String hello() {
        logger.info("hello method invoked");
        return "Hello World,"+ hi();
    }

    private String hi() {
        logger.info("hi method invoked");
        return "Hi All";
    }
}
