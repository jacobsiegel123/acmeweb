package com.acme.Details;

/**
 * class with methods to get the input for the descripiton
 */
public class BaseFacade implements DetailsGetter{

    public String getAvailableProcessors() {
        return ", and there are " + Runtime.getRuntime().availableProcessors() + " processors available";
    }

    public String getFreeJVMMemory() {
        return ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free";
    }

    public String getTotalJVMMemory() {
        return ", and there is a total of " + Runtime.getRuntime().totalMemory() + " bytes of JVM memory";
    }

    public String getJreVersion() {
        return ", and the JRE version is " + Runtime.version().toString();
    }

    public String getTempLocation() {
        return ", and the server's temp file location is " + System.getenv("TEMP");
    }
    public String getCurrentServerStatus() {
        return "up";  // The server is up
    }
}
