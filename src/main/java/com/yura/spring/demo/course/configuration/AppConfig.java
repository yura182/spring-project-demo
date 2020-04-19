package com.yura.spring.demo.course.configuration;

import com.yura.spring.demo.course.event.Event;
import com.yura.spring.demo.course.logger.CacheFileEventLogger;
import org.springframework.context.annotation.*;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@ComponentScan(basePackages = "com.yura.spring.demo.course")
@PropertySource(value = "classpath:client.properties")
public class AppConfig {

    @Bean
    public CacheFileEventLogger cacheFileEventLogger() {
        return new CacheFileEventLogger(4, "log.log");
    }

    @Bean
    @Scope(value = "prototype")
    public Event event() {
        return new Event(new Date(), DateFormat.getDateTimeInstance());
    }
}
