package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;
/**
 * decorator to add the TempLocationDecorator to the description
 */
public class TempLocationDecorator extends DecorateServerStatus {
    public TempLocationDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + facade.getTempLocation();
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getContentHeader() {
        return super.getContentHeader();
    }
}
