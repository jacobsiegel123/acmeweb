package com.acme.Details;

public class Facade implements DetailsGetter {
    protected DetailsGetter facade = new BaseFacade();


    public void setFacade(DetailsGetter facade) {
        this.facade = facade;
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
