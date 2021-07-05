package com.codurance;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnstileShould {

  private Turnstile turnstile;

  @BeforeEach
  void setUp() {
    turnstile = new Turnstile(5);
  }

  @Test
  void be_locked() {
    assertTrue(turnstile.isLocked());
  }

  @Test
  void insert_coin_shouldUnlock() {
    int coin = 5;
    turnstile.insert(coin);

    assertFalse(turnstile.isLocked());
  }

  @Test
  void insert_twoCoins_shouldBeLocked() {
    int coin = 5;
    turnstile.insert(coin);
    turnstile.insert(coin);

    assertFalse(turnstile.isLocked());
  }

  @Test
  void lock_whenPassThrough() {
    int coin = 5;
    turnstile.insert(coin);

    turnstile.pass();

    assertTrue(turnstile.isLocked());
  }

  @Test
  void unlock_whenInsertCoin_AfterSomeoneElsePassed() {
    int coin = 5;
    turnstile.insert(coin);
    turnstile.pass();

    turnstile.insert(coin);
    assertFalse(turnstile.isLocked());
  }

  @Test
  void raiseError_whenInsertInsufficientMoney() {
    int coin = 4;

    assertThrows(IllegalArgumentException.class, () -> {
      turnstile.insert(coin);
    });
  }

  @Test
  void raiseError_whenPass_withoutCoin() {
    assertThrows(IllegalStateException.class, () -> {
      turnstile.pass();
    });
  }

  @Test
  void start_withZeroCount() {
    assertThat(turnstile.getHeadCount()).isEqualTo(0);
  }

  @Test
  void count_TwoPeoplePassingThrough() {
    int coin = 5;
    turnstile.insert(5);
    turnstile.pass();
    turnstile.insert(5);
    turnstile.pass();

    assertThat(turnstile.getHeadCount()).isEqualTo(2);
  }

  @Test
  void giveChange_whenPutTooMuchMoney() {
    int coin = 6;
    turnstile.insert(coin);
    final int change = turnstile.getChange();

    assertThat(change).isEqualTo(1);
  }
}
