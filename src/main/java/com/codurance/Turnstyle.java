package com.codurance;

public class Turnstyle {
  private boolean isLocked;
  private int ticketPrice;
  private int headCount;

  public Turnstyle(int ticketPrice) {
    isLocked = true;
    this.ticketPrice = ticketPrice;
    this.headCount = 0;
  }

  public boolean isLocked() {
    return isLocked;
  }

  public int insert(int coin) {
    int change = coin - ticketPrice;
    if (change >= 0) {
      isLocked = false;
      return change;
    }else {
      isLocked = true;
      throw new IllegalArgumentException("Not enough funds");
    }
  }

  public void pass() {
    if (isLocked) {
      throw new IllegalStateException();
    }
    headCount++;
    isLocked = true;
  }

  public int getHeadCount() {
    return headCount;
  }
}
