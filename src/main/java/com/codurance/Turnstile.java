package com.codurance;

public class Turnstile {
  private boolean isLocked;
  private int ticketPrice;
  private int headCount;
  private int change;

  public Turnstile(int ticketPrice) {
    isLocked = true;
    this.ticketPrice = ticketPrice;
    this.headCount = 0;
    this.change = 0;
  }

  public boolean isLocked() {
    return isLocked;
  }

  public void insert(int coin) {
    change = coin - ticketPrice;
    if (change >= 0) {
      isLocked = false;
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

  public int getChange(){
    return change;
  }
}
