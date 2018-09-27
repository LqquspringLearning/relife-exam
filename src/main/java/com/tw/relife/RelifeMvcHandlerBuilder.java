package com.tw.relife;


import java.util.ArrayList;
import java.util.List;

public class RelifeMvcHandlerBuilder {

    public static List<RelifeMvcHandlerBuilderHolder> getContainer() {
        return container;
    }

    static List<RelifeMvcHandlerBuilderHolder> container;

    protected RelifeMvcHandlerBuilder(String path, RelifeMethod relifeMethod, RelifeAppHandler handler) {
        this();
        container.add(new RelifeMvcHandlerBuilderHolder(new RelifeRequest(path, relifeMethod), handler));
    }

    public RelifeMvcHandlerBuilder() {
        container = new ArrayList<>();
    }

    public RelifeMvcHandlerBuilder addAction(String path, RelifeMethod relifeMethod, RelifeAppHandler handler) {
        return new RelifeMvcHandlerBuilder(path, relifeMethod, handler);
    }

    public RelifeAppHandler build() {
        return container.get(0).getHandler();
    }
}
