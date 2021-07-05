package com.codurance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

  @Test
  void insert_twoCoins_shouldBeLocked() {
    int coin = 1;
    turnstyle.insert(coin);
    turnstyle.insert(coin);

    assertFalse(turnstyle.isLocked());
  }

  @Test
  void lock_whenPassThrough() {
    int coin = 1;
    turnstyle.insert(coin);

    turnstyle.pass();

    assertTrue(turnstyle.isLocked());
  }

  @Test
  void unlock_whenInsertCoin_AfterSomeoneElsePassed() {
    int coin = 1;
    turnstyle.insert(coin);
    turnstyle.pass();

    turnstyle.insert(coin);
    assertFalse(turnstyle.isLocked());
  }

  @Test
  void raiseError_whenPass_withoutCoin() {
    assertThrows(IllegalStateException.class, () -> {
      turnstyle.pass();
    });
  }
}
