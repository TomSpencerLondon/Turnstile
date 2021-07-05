package com.codurance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnstyleShould {

  private Turnstyle turnstyle;

  @BeforeEach
  void setUp() {
    turnstyle = new Turnstyle();
  }

  @Test
  void be_locked() {
    assertTrue(turnstyle.isLocked());
  }

  @Test
  void insert_coin_shouldUnlock() {
    int coin = 1;
    turnstyle.insert(coin);

    assertFalse(turnstyle.isLocked());
  }
}
