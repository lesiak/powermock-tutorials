package com.test.powermock.partialinvocationcount;

public class ClassWithDependency {

    private UtilClass utilClass;

    public ClassWithDependency(UtilClass utilClass) {
        this.utilClass = utilClass;
    }

    public String welcome() {
        String msg = utilClass.hello();
        return msg;
    }

}
