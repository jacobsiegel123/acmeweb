package com.acme.Details;

public interface DetailsGetter {
    public  String getAvailableProcessors();

    public String getFreeJVMMemory();
    public String getTotalJVMMemory();

    public String getJreVersion();

    public String getTempLocation();
    public String getCurrentServerStatus();
}
