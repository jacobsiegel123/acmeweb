package com.acme.servermgr;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project.
 * Treat this as a 'black box' that gives back indicators like 'up', true, or percentages like '95%' for
 * the various 'services' that are being managed.
 */
public class ServerManager{
    /**
     * Get the status of this server
     *
     * @return a descriptive string about the servers status
     */
   public static String getCurrentServerStatus() {
        return "up";  // The server is up
    }

    /**
     * Find out if this server is operating normally
     *
     * @return Boolean indicating if server is operating normally
     */
    public static Boolean isOperatingNormally() {
        return true;
    }

}
