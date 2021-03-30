package com.example;

import io.quarkus.vertx.ConsumeEvent;

public class EventHandler {

    @ConsumeEvent("foo")
    public void handle(Event event) {
        System.out.println(event.getA());
    }
}
