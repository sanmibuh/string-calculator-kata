package com.sanmibuh.kata.stringcalculator;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class StringCalculator {

  private static final Pattern PATTERN = Pattern.compile("[,\n]");
  private static final String DELIMITER_PREFIX = "//";

  private StringCalculator() {
    //util class
  }

  public static int add(final String input) {
    if (input.isEmpty()) {
      return 0;
    }
    
    return Stream.of(getNumbers(input))
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static String[] getNumbers(final String input) {
    if (input.startsWith(DELIMITER_PREFIX)) {
      final var delimiterPrefixLength = DELIMITER_PREFIX.length();
      final var delimiter = input.substring(delimiterPrefixLength, delimiterPrefixLength + 1);
      return input.substring(delimiterPrefixLength + 2).split(delimiter);
    }

    return PATTERN.split(input);
  }
}
