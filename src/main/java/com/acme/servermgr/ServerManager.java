package com.acme.servermgr;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project.
 * Treat this as a 'black box' that gives back indicators like 'up', true, or percentages like '95%' for
 * the various 'services' that are being managed.
 */
public class ServerManager {

    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
    static public String getCurrentServerStatus() {
        return "up";  // The server is up
    }

    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally()
    {
        return true;
    }

    static public String getAvailableProcessors(){
        return ", and there are 4 processors available";
    }
    static public String getFreeJVMMemory(){
        return ", and there are 127268272 bytes of JVM memory free";
    }
    static public String getTotalJVMMemory(){
        return ", and there is a total of 159383552 bytes of JVM memory";
    }
    static public String getJreVersion(){
        return ", and the JRE version is 15.0.2+7-27";
    }
    static public String getTempLocation(){
        return ", and the server's temp file location is " + System.getenv("TEMP");
    }

}
