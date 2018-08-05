package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class QuestRepository {
  Random rand = new Random();

  Map<Integer, Quest> quests = new HashMap<>();

  public void createQuest(String description) {
    int newId = Ids.generateNewId(quests.keySet());
    Quest newQuest = new Quest(newId, description);
    quests.put(newId, newQuest);
  }

  public List<Quest> getAll() {
    return new ArrayList<>(quests.values());
  }

  @PostConstruct
  public void init() {
  }

  public void deleteQuest(Quest quest) {
    quests.remove(quest.getId());
  }

  @Scheduled(fixedDelayString = "${questDelay}")
  public void createRandomQuest() {
    List<String> descriptions = new ArrayList<>();

    descriptions.add("Uratuj księżniczkę");
    descriptions.add("Weź udział w turnieju");
    descriptions.add("Zabij bande goblinów");
    descriptions.add("Zabij smoka");

    String description = descriptions.get(rand.nextInt(descriptions.size()));
    createQuest(description);
  }



  @Override
  public String toString() {
    return "QuestRepository{" +
        "quests=" + quests +
        '}';
  }

  public void update(Quest quest) {
    quests.put(quest.getId(),quest);
  }

  public Quest getQuest(Integer id) {
    return quests.get(id);
  }
}
