package com.codurance;

public class Turnstyle {
  private boolean isLocked;

  public Turnstyle() {
    isLocked = true;
  }

  public boolean isLocked() {
    return isLocked;
  }

  public void insert(int coin) {
    isLocked = false;
  }
}
