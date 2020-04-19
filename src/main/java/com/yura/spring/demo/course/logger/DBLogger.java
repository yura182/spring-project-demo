package com.yura.spring.demo.course.logger;

import com.yura.spring.demo.course.event.Event;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBLogger implements EventLogger {
    private JdbcTemplate jdbcTemplate;

    public DBLogger(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void logEvent(Event event) {
        jdbcTemplate.update("INSERT INTO t_event (id, msg) VALUES(?,?)", event.getId(), event.toString());
    }
}
