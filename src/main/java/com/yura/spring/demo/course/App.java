package com.yura.spring.demo.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId().toString(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);

        app.logEvent("Some event for user 1");
    }
}
