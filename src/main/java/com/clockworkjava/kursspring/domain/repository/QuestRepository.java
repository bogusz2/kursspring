package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

@Repository
public class QuestRepository {

  Random rand = new Random();

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public void createQuest(String description) {
    //int newId = Ids.generateNewId(quests.keySet());
    Quest newQuest = new Quest(description);
    //quests.put(newId, newQuest);
    em.persist(newQuest);
    System.out.println(newQuest);
  }

  public List<Quest> getAll() {
  return em.createQuery("from Quest", Quest.class).getResultList();
  }



  @Transactional
  public void deleteQuest(Quest quest) {
    em.remove(quest);
  }

  @Scheduled(fixedDelayString = "${questDelay}")
  @Transactional
  public void createRandomQuest() {
    List<String> descriptions = new ArrayList<>();

    descriptions.add("Uratuj księżniczkę");
    descriptions.add("Weź udział w turnieju");
    descriptions.add("Zabij bande goblinów");
    descriptions.add("Zabij smoka");

    String description = descriptions.get(rand.nextInt(descriptions.size()));
    createQuest(description);
  }

  @Transactional
  public void update(Quest quest) {
    em.merge(quest);
  }

  @Transactional
  public Quest getQuest(Integer id) {
    return em.find(Quest.class,id);
  }
}
