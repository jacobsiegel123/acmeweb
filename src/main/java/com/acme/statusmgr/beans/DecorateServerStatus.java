package com.acme.statusmgr.beans;

import com.acme.Details.DetailsGetter;
import com.acme.Details.Facade;

public abstract class DecorateServerStatus implements ServerStatusInterface{
    private ServerStatusInterface statusInter;
    Facade facade = new Facade();

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
