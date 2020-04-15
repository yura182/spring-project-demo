package com.yura.spring.demo.course.logger;

import com.yura.spring.demo.course.event.Event;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
