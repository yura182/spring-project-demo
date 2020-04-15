package com.yura.spring.demo.course;

import com.yura.spring.demo.course.client.Client;
import com.yura.spring.demo.course.event.Event;
import com.yura.spring.demo.course.logger.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event) {
        String message = event.getMsg().replaceAll(client.getId().toString(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);
        Event event = applicationContext.getBean(Event.class);
        event.setMsg("Some event for user 1");

        app.logEvent(event);
        app.logEvent(event);
        app.logEvent(event);
        app.logEvent(event);
        app.logEvent(event);
        applicationContext.close();
    }
}
