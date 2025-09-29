package com.britishtime.controller;


import com.britishtime.service.TimeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/spoken")
    public String getSpokenTime(@RequestParam int hour, @RequestParam int minute) {
        return timeService.getSpokenTime(hour, minute);
    }
}


