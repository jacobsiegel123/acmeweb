package com.acme.Details;

/**
 * accepts the details from the basefacade or mockfacade
 */
public class Facade implements DetailsGetter {
   static protected DetailsGetter facade = new BaseFacade();


    public void setFacade(DetailsGetter facade) {
        Facade.facade = facade;
    }
    public String getAvailableProcessors() {
        return facade.getAvailableProcessors();
    }

    public String getFreeJVMMemory() {
        return facade.getFreeJVMMemory();
    }

    public String getTotalJVMMemory() {
        return facade.getTotalJVMMemory();
    }

    public String getJreVersion() {
        return facade.getJreVersion();
    }

    public String getTempLocation() {
        return facade.getTempLocation();
    }
    public String getCurrentServerStatus() {
        return "up";  // The server is up
    }
}
