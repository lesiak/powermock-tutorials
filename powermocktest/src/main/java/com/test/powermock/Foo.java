package com.test.powermock;

public class Foo {
    public static String static1() {
        System.out.println("static1 called");
        return "1";
    }

    public static String static2() {
        System.out.println("static2 called");
        return "2";
    }

    public static String staticInput(int i) {
        System.out.println("staticInput called");
        return "static " + i;
    }

}
