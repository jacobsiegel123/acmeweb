package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class TempLocationDecorator extends DecorateServerStatus {
    public TempLocationDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ServerManager.getTempLocation();
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
