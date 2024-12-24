package com.paul.logdemo.controller;

import com.paul.logdemo.log.CustomLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MessageController {

  @GetMapping("/logMessage")
  String logMessage(@RequestParam(value = "message", required = false) String message) {

    return CustomLogger.log(message);
  }
}
