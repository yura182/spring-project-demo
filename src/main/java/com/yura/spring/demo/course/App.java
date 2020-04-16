package com.yura.spring.demo.course;

import com.yura.spring.demo.course.client.Client;
import com.yura.spring.demo.course.event.Event;
import com.yura.spring.demo.course.event.EventType;
import com.yura.spring.demo.course.logger.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    Client client;
    EventLogger defaultEventLogger;
    Map<EventType, EventLogger> loggerMap;

    public App(Client client, EventLogger defaultEventLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.defaultEventLogger = defaultEventLogger;
        this.loggerMap = loggerMap;
    }

    private void logEvent(Event event, EventType eventType) {
        EventLogger logger = loggerMap.getOrDefault(eventType, defaultEventLogger);

        String message = event.getMsg().replaceAll(client.getId().toString(), client.getFullName());
        event.setMsg(message);

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = applicationContext.getBean(App.class);
        Event event = applicationContext.getBean(Event.class);
        event.setMsg("Some event for user 1");

        System.out.println(app.client.getGreeting());

        app.logEvent(event, EventType.INFO);
        app.logEvent(event, EventType.ERROR);
        app.logEvent(event, null);
        applicationContext.close();
    }
}
