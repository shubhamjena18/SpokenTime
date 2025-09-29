package com.britishtime.format;


import org.springframework.stereotype.Component;

@Component
public class TimeFormatterFactory {

    private final SpecialTimeFormatter specialFormatter;
    private final SpokenTimeFormatter spokenFormatter;

    public TimeFormatterFactory(SpecialTimeFormatter specialFormatter,
                                SpokenTimeFormatter spokenFormatter) {
        this.specialFormatter = specialFormatter;
        this.spokenFormatter = spokenFormatter;
    }

    public TimeFormatter getFormatter(int hour, int minute) {
        if (specialFormatter.format(hour, minute) != null) {
            return specialFormatter;
        }
        return spokenFormatter;
    }
}

