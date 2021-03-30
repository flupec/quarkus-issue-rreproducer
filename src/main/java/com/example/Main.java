package com.example;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.vertx.core.eventbus.EventBus;

import javax.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
    @Inject
    EventBus eventBus;

    @Override
    public int run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Add one arg to reproduce the issue");
            return 0;
        }
        if (args[0].equals("1")) {
            Event event = new Event("1");
            eventBus.publish("foo", event);
        }

        if (args[0].equals("2")) {
            Event event = new SubclassEvent("2");
            eventBus.publish("foo", event);
        }

        return 0;
    }
}
