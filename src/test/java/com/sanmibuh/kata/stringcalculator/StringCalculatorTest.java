package com.sanmibuh.kata.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void should_add_returns_zero_when_empty() {
    //when
    final var result = StringCalculator.add("");

    //then
    assertThat(result).isEqualTo(0);
  }

  @Test
  void should_add_returns_the_number() {
    //when
    final var result = StringCalculator.add("1");

    //then
    assertThat(result).isEqualTo(1);
  }

  @Test
  void should_add_sums_two_comma_separated_numbers() {
    //when
    final var result = StringCalculator.add("1,2");

    //then
    assertThat(result).isEqualTo(3);
  }

  @Test
  void should_add_any_comma_separated_numbers() {
    //when
    final var result = StringCalculator.add("1,2,6,8,10");

    //then
    assertThat(result).isEqualTo(27);
  }

  @Test
  void should_add_handles_new_line_as_separator() {
    //when
    final var result = StringCalculator.add("1\n2,3");

    //then
    assertThat(result).isEqualTo(6);
  }

  @Test
  void should_add_support_different_delimiters() {
    //when
    final var result = StringCalculator.add("//;\n1;2");

    //then
    assertThat(result).isEqualTo(3);
  }

  @Test
  void should_add_fails_with_negative_numbers() {
    //when
    assertThatThrownBy(() -> StringCalculator.add("-1\n-2"))
        .isInstanceOf(NegativesAreNotAllowed.class)
        .hasMessage("Negatives not allowed: [%d, %d]", -1, -2);
  }

}
