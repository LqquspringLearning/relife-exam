package com.tw.relife;

import java.lang.annotation.Annotation;

public class RelifeApp implements RelifeAppHandler {
    private final RelifeAppHandler handler;

    public RelifeApp(RelifeAppHandler handler) {

        // TODO: You can start here
        if (handler == null) throw new IllegalArgumentException();
        this.handler = handler;
    }

    @Override
    public RelifeResponse process(RelifeRequest request) {

        // TODO: You can start here
        try {
            if (isRegisteredHandler(handler)) {
                RelifeMvcHandlerBuilderHolder holder = getActionHolder(request);
                if (holder != null)
                    return holder.getHandler().process(request);

                return new RelifeResponse(404);
            }
            return handler.process(request);
        } catch (Exception e) {

            for (Annotation annotation : e.getClass().getAnnotations()) {
                if (annotation.annotationType() == RelifeStatusCode.class) {
                    return new RelifeResponse(((RelifeStatusCode) annotation).value());
                }
            }
            return new RelifeResponse(500);
        }

    }

    private boolean isRegisteredHandler(RelifeAppHandler handler) {
        try {
            Boolean[] holder = {false};
            RelifeMvcHandlerBuilder.getContainer().forEach(containerHolder -> {
                if (containerHolder.getHandler().equals(handler)) {
                    holder[0] = true;
                }
            });
            return holder[0];
        } catch (Exception e) {
            return false;
        }

    }

    private RelifeMvcHandlerBuilderHolder getActionHolder(RelifeRequest request) {
        RelifeMvcHandlerBuilderHolder[] holder = new RelifeMvcHandlerBuilderHolder[1];
        RelifeMvcHandlerBuilder.getContainer().forEach(containerHolder -> {
            if (containerHolder.getRelifeRequest().equals(request)) {
                holder[0] = containerHolder;
            }
        });
        return holder[0];
    }
}
