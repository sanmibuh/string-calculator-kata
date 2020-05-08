package com.sanmibuh.kata.stringcalculator;

import java.util.Collection;

public class NegativesAreNotAllowed extends RuntimeException {

  private static final long serialVersionUID = 1378657903968052082L;

  private static final String TEMPLATE = "Negatives not allowed: %s";

  public NegativesAreNotAllowed(final Collection<String> numbers) {
    super(String.format(TEMPLATE, numbers));
  }

}
