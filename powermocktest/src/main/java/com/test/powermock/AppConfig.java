package com.test.powermock;

public class AppConfig
{


    public AppConfig() {

    }

    private String applicationName;


    private String serverPort;
    //getter and setter


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}