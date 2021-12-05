package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class JreVersionDecorator extends DecorateServerStatus {
    public JreVersionDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + ServerManager.getJreVersion();
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
