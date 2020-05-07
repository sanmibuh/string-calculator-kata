package com.sanmibuh.kata.stringcalculator;

import java.util.stream.Stream;

public final class StringCalculator {

  private static final String SEPARATOR = ",";

  private StringCalculator() {
    //util class
  }

  public static int add(final String input) {
    if (input.isEmpty()) {
      return 0;
    }
    return Stream.of(input.split(SEPARATOR))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
