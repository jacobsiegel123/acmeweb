package com.acme.statusmgr.beans;

public abstract class DecorateServerStatus implements ServerStatusInterface{
    private ServerStatusInterface statusInter;

    public DecorateServerStatus(ServerStatusInterface decoratedStatus) {
        statusInter = decoratedStatus;
    }

    @Override
    public String getStatusDesc() {
        return statusInter.getStatusDesc();
    }

    @Override
    public long getId() {
        return statusInter.getId();
    }

    @Override
    public String getContentHeader() {
        return statusInter.getContentHeader();
    }
}
