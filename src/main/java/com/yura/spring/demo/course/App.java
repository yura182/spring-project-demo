package com.yura.spring.demo.course;

import com.yura.spring.demo.course.client.Client;
import com.yura.spring.demo.course.configuration.AppConfig;
import com.yura.spring.demo.course.configuration.LoggersConfig;
import com.yura.spring.demo.course.event.Event;
import com.yura.spring.demo.course.event.EventType;
import com.yura.spring.demo.course.logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class App {
    Client client;
    EventLogger defaultEventLogger;
    Map<EventType, EventLogger> loggerMap;

    @Autowired
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
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, LoggersConfig.class);
        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        event.setMsg("Some event for user 1");
//
        System.out.println(app.client.getGreeting());
//
        app.logEvent(event, EventType.INFO);
        app.logEvent(event, EventType.ERROR);
        app.logEvent(event, null);

        context.close();
    }
}
