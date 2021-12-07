package com.acme.Details;

/**
 * interface to get the methods of what to return for the description
 */
public interface DetailsGetter {
    public  String getAvailableProcessors();

    public String getFreeJVMMemory();
    public String getTotalJVMMemory();

    public String getJreVersion();

    public String getTempLocation();
    public String getCurrentServerStatus();
}
