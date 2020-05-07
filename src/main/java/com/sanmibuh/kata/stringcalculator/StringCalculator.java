package com.sanmibuh.kata.stringcalculator;

import java.util.stream.Stream;

public final class StringCalculator {

  public static int add(final String input) {
    if (input.isEmpty()) {
      return 0;
    }
    return Stream.of(input.split(","))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
