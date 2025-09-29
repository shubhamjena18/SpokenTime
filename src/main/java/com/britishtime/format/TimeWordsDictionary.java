package com.britishtime.format;



import com.britishtime.config.TimeProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TimeWordsDictionary {

    private final RedisTemplate<String, String> redisTemplate;
    private final TimeProperties timeProperties;
    private HashOperations<String, String, String> hashOps;
    private static final String REDIS_KEY = "number-words";

    public TimeWordsDictionary(RedisTemplate<String, String> redisTemplate,
                               TimeProperties timeProperties) {
        this.redisTemplate = redisTemplate;
        this.timeProperties = timeProperties;
    }

    @PostConstruct
    public void init() {
        this.hashOps = redisTemplate.opsForHash();
        int attempts = 5;
        while (attempts > 0) {
            try {
                if (!Boolean.TRUE.equals(redisTemplate.hasKey(REDIS_KEY))) {
                    hashOps.putAll(REDIS_KEY, timeProperties.getNumberWords());
                }
                break; // success
            } catch (Exception e) {
                attempts--;
                System.err.println("Retrying Redis init, attempts left: " + attempts);
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            }
        }
    }



    public String numberToWord(int number) {
        String value = hashOps.get(REDIS_KEY, String.valueOf(number));
        if (value == null) throw new IllegalArgumentException("No mapping for number: " + number);
        return value;
    }
}

