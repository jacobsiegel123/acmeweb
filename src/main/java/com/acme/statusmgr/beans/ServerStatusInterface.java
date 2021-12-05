package com.acme.statusmgr.beans;

/**
 * this is the interface for the server status decorators
 */
public interface ServerStatusInterface {
    String getStatusDesc();

    long getId();

    String getContentHeader();
}
