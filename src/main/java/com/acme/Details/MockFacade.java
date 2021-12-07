package com.acme.Details;

/**
 * hard coded the details this is to be used for the test
 */
public class MockFacade implements DetailsGetter{

    public String getAvailableProcessors() {
        return ", and there are 4 processors available";
    }

    public String getFreeJVMMemory() {
        return ", and there are 127268272 bytes of JVM memory free";
    }

    public String getTotalJVMMemory() {
        return ", and there is a total of 159383552 bytes of JVM memory";
    }

    public String getJreVersion() {
        return ", and the JRE version is 15.0.2+7-27";
    }

    public String getTempLocation() {
        return ", and the server's temp file location is " + System.getenv("TEMP");
    }
    public String getCurrentServerStatus() {
        return "up";  // The server is up
    }
}
