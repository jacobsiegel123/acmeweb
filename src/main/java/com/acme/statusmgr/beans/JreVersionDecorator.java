package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;
/**
 * decorator to add the JreVersionDecorator to the description
 */
public class JreVersionDecorator extends DecorateServerStatus {
    public JreVersionDecorator(ServerStatusInterface decoratedStatus) {
        super(decoratedStatus);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + facade.getJreVersion();
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
