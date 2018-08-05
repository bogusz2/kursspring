package com.clockworkjava.kursspring.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight {

  @NotNull
  @Size(min = 2, max = 40, message = "Imie rycerza jest albo za długi albo za krótkie")
  private String name;
  @NotNull
  @Range(min = 18, max = 60, message = "Rycerz jest albo za młody albo za stary")
  private int age;
  private Quest quest;
  private int id;
  private int level;

  public Knight() {

    

  }

  public Knight(String name, int age) {
    this.name = name;
    this.age = age;
    this.level = 1;
  }

  public Quest getQuest() {
    return quest;
  }

  public void setQuest(Quest quest) {
    if (quest != null) {
      quest.setStarted(true);
    }
    this.quest = quest;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Rycerz o imieniu " + name + "(" + age + "). Ma za zadanie: " + quest;
  }
}
