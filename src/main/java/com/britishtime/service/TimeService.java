package com.britishtime.service;



import com.britishtime.format.TimeFormatter;
import com.britishtime.format.TimeFormatterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    private final RedisTemplate<String, String> redisTemplate;
    private final TimeFormatterFactory formatterFactory;

    public TimeService(RedisTemplate<String, String> redisTemplate,
                       TimeFormatterFactory formatterFactory) {
        this.redisTemplate = redisTemplate;
        this.formatterFactory = formatterFactory;
    }

    public String getSpokenTime(int hour, int minute) {
        TimeFormatter formatter = formatterFactory.getFormatter(hour, minute);
        return formatter.format(hour, minute);
    }
}

