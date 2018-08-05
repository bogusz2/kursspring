package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class QuestTest {


  @Test
  public  void settingStartedFlagToFalseShouldSetStartDate(){
    Quest quest = new Quest(1,"Testowe zadanie");

    quest.setStarted(true);

    assertNotNull(quest.startDate);
  }

  @Test
  public void questShouldBeNotCompleted(){
    Quest quest = new Quest(1,"Testowe zadanie");

    quest.setStarted(true);

    quest.lenghtInSeconds = 100000;

    assertFalse(quest.isCompleted());
    assertFalse(quest.isCompleted());
  }

  @Test
  public void questShouldBeCompleted(){
    Quest quest = new Quest(1,"Testowe zadanie");

    quest.setStarted(true);

    quest.lenghtInSeconds = -60;

    assertTrue(quest.isCompleted());
    assertTrue(quest.isCompleted());
  }
}
