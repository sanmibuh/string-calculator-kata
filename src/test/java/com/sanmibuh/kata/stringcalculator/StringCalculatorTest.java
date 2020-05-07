package com.sanmibuh.kata.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

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

}
