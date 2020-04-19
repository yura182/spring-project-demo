package com.yura.spring.demo.course.configuration;

import com.yura.spring.demo.course.event.EventType;
import com.yura.spring.demo.course.logger.CacheFileEventLogger;
import com.yura.spring.demo.course.logger.ConsoleEventLogger;
import com.yura.spring.demo.course.logger.EventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.yura.spring.demo.course")
public class LoggersConfig {

    @Bean
    public CacheFileEventLogger cacheFileEventLogger() {
        return new CacheFileEventLogger(4, "log.log");
    }

    @Bean
    public Map<EventType, EventLogger> loggerMap() {
        Map<EventType, EventLogger> map = new HashMap<>();
        map.put(EventType.INFO, new ConsoleEventLogger());
        map.put(EventType.ERROR, cacheFileEventLogger());

        return map;
    }
}
