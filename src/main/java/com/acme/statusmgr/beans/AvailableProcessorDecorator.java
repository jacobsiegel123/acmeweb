package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class AvailableProcessorDecorator extends DecorateServerStatus {
    public AvailableProcessorDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ServerManager.getAvailableProcessors();
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
