package com.britishtime.format;


import org.springframework.stereotype.Component;

@Component
public class SpecialTimeFormatter implements TimeFormatter {

    @Override
    public String format(int hour, int minute) {
        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";
        return null;
    }
}

