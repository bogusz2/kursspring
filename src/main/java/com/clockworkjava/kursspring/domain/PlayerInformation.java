package com.clockworkjava.kursspring.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
public class PlayerInformation {

  private int gold = 0;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  public PlayerInformation() {
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }
}
