package com.sanmibuh.kata.stringcalculator;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class StringCalculator {

  private static final Pattern PATTERN = Pattern.compile("[,\n]");

  private StringCalculator() {
    //util class
  }

  public static int add(final String input) {
    if (input.isEmpty()) {
      return 0;
    }

    if (input.startsWith("//")) {
      final var delimiter = input.substring(2, 3);
      return Stream.of(input.substring(4).split(delimiter))
          .mapToInt(Integer::parseInt)
          .sum();
    }

    return Stream.of(PATTERN.split(input))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
