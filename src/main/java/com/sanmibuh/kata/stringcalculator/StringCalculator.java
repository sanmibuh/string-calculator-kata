package com.sanmibuh.kata.stringcalculator;

import java.util.List;
import java.util.regex.Pattern;

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

    final var numbers = getNumbers(input);
    if (numbers.stream()
        .mapToInt(Integer::parseInt)
        .anyMatch(number -> number < 0)) {
      throw new NegativesAreNotAllowed(numbers);
    }

    return numbers.stream()
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static List<String> getNumbers(final String input) {
    if (input.startsWith(DELIMITER_PREFIX)) {
      final var delimiterPrefixLength = DELIMITER_PREFIX.length();
      final var delimiter = input.substring(delimiterPrefixLength, delimiterPrefixLength + 1);
      return List.of(input.substring(delimiterPrefixLength + 2).split(delimiter));
    }

    return List.of(PATTERN.split(input));
  }
}
