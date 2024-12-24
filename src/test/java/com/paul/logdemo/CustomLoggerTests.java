package com.paul.logdemo;

import com.paul.logdemo.log.CustomLogger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class CustomLoggerTests {

  // Test card numbers:  https://www.paypalobjects.com/en_GB/vhelp/paypalmanager_help/credit_card_numbers.htm

  @Test
  void noMatchFoundTest() {
    Assertions.assertEquals("nothing to match here", CustomLogger.log("nothing to match here"));
  }

  @Test
  void matchVisaTest() {
    Assertions.assertEquals("This is a Visa card number: XXX", CustomLogger.log("This is a Visa card number: 4111111111111111"));
  }

  @Test
  void matchDiscoverTest() {
    Assertions.assertEquals("This is a Master card number: XXX", CustomLogger.log("This is a Master card number: 5555555555554444"));
  }

}
