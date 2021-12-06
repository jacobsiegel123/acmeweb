package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class TotalJVMMemoryDecorator extends DecorateServerStatus {
    public TotalJVMMemoryDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + facade.getTotalJVMMemory();
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
