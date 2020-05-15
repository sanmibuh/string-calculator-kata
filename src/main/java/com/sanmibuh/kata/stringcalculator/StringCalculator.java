package com.sanmibuh.kata.stringcalculator;

import java.util.List;
import java.util.regex.Pattern;

public final class StringCalculator {

  private static final Pattern PATTERN = Pattern.compile("[,\n]");
  private static final String DELIMITER_PREFIX = "//";
  private static final String DELIMITER_SUFFIX = "\n";
  private static final int LIMIT = 1000;

  private StringCalculator() {
    //util class
  }

  public static int add(final String input) {
    if (input.isEmpty()) {
      return 0;
    }

    final var numbers = getNumbers(input);
    validateNumbers(numbers);

    return numbers.stream()
        .mapToInt(Integer::parseInt)
        .filter(StringCalculator::isInLimit)
        .sum();
  }

  private static List<String> getNumbers(final String input) {
    if (input.startsWith(DELIMITER_PREFIX)) {
      var delimiter = input.substring(DELIMITER_PREFIX.length(), input.indexOf(DELIMITER_SUFFIX));
      if (delimiter.length() > 1) {
        delimiter = delimiter.substring(1, delimiter.length() -1);
      }
      return List.of(input.substring(input.indexOf(DELIMITER_SUFFIX) +1).split(Pattern.quote(delimiter)));
    }

    return List.of(PATTERN.split(input));
  }

  private static void validateNumbers(final List<String> numbers) {
    if (numbers.stream()
        .mapToInt(Integer::parseInt)
        .anyMatch(StringCalculator::negative)) {
      throw new NegativesAreNotAllowed(numbers);
    }
  }

  private static boolean negative(final int number) {
    return number < 0;
  }

  private static boolean isInLimit(final int number) {
    return number <= LIMIT;
  }
}
