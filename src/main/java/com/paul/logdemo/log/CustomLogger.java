package com.paul.logdemo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomLogger {

  private static Logger log = LoggerFactory.getLogger(CustomLogger.class);

  public static String log(String message) {

    //String result = message;
    Marker marker = MarkerFactory.getMarker("PII-CLEAR");

    // Regex source list:  https://stackoverflow.com/questions/9315647/regex-credit-card-number-tests
    String[] privateRegexMatchers = new String[] {
        "4[0-9]{12}(?:[0-9]{3})?", //Visa Credit Card
        "(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))", //Mastercard
        "test"
    };

    //Could have multiple PII violations so need to loop through entire list
    for(String privateRegexMatcher : privateRegexMatchers) {

      Pattern pattern = Pattern.compile(privateRegexMatcher);

      Matcher matcher = pattern.matcher(message);

      while (matcher.find()) {
        if (matcher.hasMatch()) {
          message = message.replaceAll(privateRegexMatcher, "XXX");
          marker = MarkerFactory.getMarker("PII-EXCEPTION");
        }
      }
    }

    log.info(marker, message);

    return message;
  }

}
