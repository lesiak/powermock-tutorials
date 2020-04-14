package com.test.powermock.teststacitejb;

import javax.naming.InitialContext;

public class XYZClass {

    private static InitialContext ctx;

    private static InitialContext getCtx(){
        try{
            if(ctx == null)
                ctx = new InitialContext();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ctx;
    }
    public static IMFTPManagerService getIMFTPManagerFacade() {
        try {
            InitialContext ctx = getCtx();
            return (IMFTPManagerService) ctx.lookup("abc");
        } catch (Exception e) {
            return null;
        }
    }
}
