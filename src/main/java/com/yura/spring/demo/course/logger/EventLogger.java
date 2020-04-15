package com.yura.spring.demo.course.logger;

import com.yura.spring.demo.course.event.Event;

public interface EventLogger {
    void logEvent(Event event);
}
