package com.tw.relife;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelifeAppAC3Test {
    @Test
    void should_response_200_with_hello() {
        RelifeAppHandler handler = new RelifeMvcHandlerBuilder().addAction(
                "/path", RelifeMethod.GET,
                request -> new RelifeResponse(200, "Hello", "text/plain"))
                .build();
        RelifeApp app = new RelifeApp(handler);
        RelifeResponse response = app.process(
                new RelifeRequest("/path", RelifeMethod.GET));

        assertEquals(200, response.getStatus());
        assertEquals("Hello", response.getContent());
        assertEquals("text/plain", response.getContentType());

    }

    @Test
    void should_response_404() {
        RelifeAppHandler handler = new RelifeMvcHandlerBuilder().addAction(
                "/path", RelifeMethod.GET,
                request -> new RelifeResponse(200, "Hello", "text/plain"))
                .build();
        RelifeApp app = new RelifeApp(handler);
        RelifeResponse response = app.process(
                new RelifeRequest("/notAPath", RelifeMethod.GET));
        assertEquals(404, response.getStatus());

    }
}
