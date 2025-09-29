package com.britishtime.format;

import org.springframework.stereotype.Component;

@Component
public class SpokenTimeFormatter implements TimeFormatter {

    private final TimeWordsDictionary dict;

    public SpokenTimeFormatter(TimeWordsDictionary dict) {
        this.dict = dict;
    }

    @Override
    public String format(int hour, int minute) {
        int displayHour = hour % 12 == 0 ? 12 : hour % 12;
        String hourWord = dict.numberToWord(displayHour);

        if (minute == 0) return hourWord + " o'clock";
        if (minute == 15) return "quarter past " + hourWord;
        if (minute == 30) return "half past " + hourWord;
        if (minute == 45) return "quarter to " + dict.numberToWord((displayHour % 12) + 1);
        if (minute < 30) return dict.numberToWord(minute) + " past " + hourWord;
        else return dict.numberToWord(60 - minute) + " to " + dict.numberToWord((displayHour % 12) + 1);
    }
}

