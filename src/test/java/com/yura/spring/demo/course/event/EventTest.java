package com.yura.spring.demo.course.event;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void isDay_ShouldReturnTrueForDay() {
        boolean expected = true;
        boolean actual = Event.isDay();

        assertEquals(expected, actual);
    }
}