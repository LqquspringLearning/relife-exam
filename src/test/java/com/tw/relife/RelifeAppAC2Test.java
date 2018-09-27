package com.tw.relife;

import com.tw.relife.Exceptions.SampleNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelifeAppAC2Test {

    @Test
    void should_return_404_when_given_a_not_fount_exception() {
        RelifeApp app = new RelifeApp(request -> {
            throw new SampleNotFoundException();
        });
        RelifeRequest whateverRequest = new RelifeRequest(
                "/any/path", RelifeMethod.GET);
        RelifeResponse response = app.process(whateverRequest);
        assertEquals(404, response.getStatus());
    }
}
