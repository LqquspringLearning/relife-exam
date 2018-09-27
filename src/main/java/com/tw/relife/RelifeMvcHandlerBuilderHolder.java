package com.tw.relife;

public class RelifeMvcHandlerBuilderHolder {

    public RelifeRequest getRelifeRequest() {
        return relifeRequest;
    }

    public RelifeAppHandler getHandler() {
        return handler;
    }

    private RelifeRequest relifeRequest;
    private RelifeAppHandler handler;

    public RelifeMvcHandlerBuilderHolder(RelifeRequest relifeRequest, RelifeAppHandler handler) {
        this.relifeRequest = relifeRequest;
        this.handler = handler;
    }
}
