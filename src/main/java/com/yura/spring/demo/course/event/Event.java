package com.yura.spring.demo.course.event;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {
    private Integer id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        id = new Random().nextInt(100);
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public static boolean isDay() {
        LocalTime after = LocalTime.of(8, 0);
        LocalTime before = LocalTime.of(17, 0);
        LocalTime now = LocalTime.now();

        return now.isAfter(after) && now.isBefore(before);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
