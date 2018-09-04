package com.clockworkjava.kursspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="zadania")
public class Quest {

  protected LocalDateTime startDate;

  private String description;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int reward = 100;

  protected int lenghtInSeconds = 10;

  private boolean started = false;

  private boolean completed;

  public Quest() {
  }

  public Quest(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public Quest(String description) {
    this.description=description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getReward() {
    return reward;
  }

  public void setReward(int reward) {
    this.reward = reward;
  }

  public int getLenght() {
    return lenghtInSeconds;
  }

  public void setLenght(int lenght) {
    this.lenghtInSeconds = lenght;
  }

  public boolean isStarted() {
    return started;
  }

  public void setStarted(boolean started) {
    if (started) {
      this.startDate = LocalDateTime.now();
    }
    this.started = started;
  }

  public boolean isCompleted() {
    if(this.completed){
      return this.completed;
    }
    else {


      LocalDateTime now = LocalDateTime.now();
      LocalDateTime localDateTime = this.startDate.plusSeconds(this.lenghtInSeconds);
      boolean isAfter = now.isAfter(localDateTime);
      if (isAfter) {
        this.completed = true;
      }
      return isAfter;
    }

  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public String toString() {
    return description;
  }
}