package com.yura.spring.demo.course.logger;

import com.yura.spring.demo.course.event.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {
    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.forEach(e->e.logEvent(event));
    }
}
