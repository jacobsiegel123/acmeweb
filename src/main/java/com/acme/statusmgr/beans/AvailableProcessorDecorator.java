package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * decorator to add the AvailableProcessors to the description
 */
public class AvailableProcessorDecorator extends DecorateServerStatus {
    public AvailableProcessorDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + facade.getAvailableProcessors();
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
