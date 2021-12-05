package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class FreeJVMMemoryDecorator extends DecorateServerStatus {
    public FreeJVMMemoryDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ServerManager.getFreeJVMMemory();
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
