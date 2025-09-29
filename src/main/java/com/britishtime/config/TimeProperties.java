package com.britishtime.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "time")
public class TimeProperties {
    private Map<String, String> numberWords;

    public Map<String, String> getNumberWords() { return numberWords; }
    public void setNumberWords(Map<String, String> numberWords) { this.numberWords = numberWords; }
}

