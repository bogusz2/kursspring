package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

  @Autowired
  KnightRepository knightRepository;

  @Autowired
  PlayerInformation playerInformation;



  public List<Knight> getAllKnights() {
    return new ArrayList<>(knightRepository.getAllKnights());
  }

  public Knight getKnight(Integer id){
    return knightRepository.getKnightById(id);
  }

  public void saveKnight(Knight knight){
    knightRepository.createKnight(knight);
  }

  public void deleteKnight(Integer id) {
    knightRepository.deleteKnight(id);
  }

  public void updateKnight(Knight knight) {
    knightRepository.updateKnight(knight.getId(), knight);
  }

  public int collectRewards() {

    Predicate<Knight> knightPredicate = knight -> {
      if (knight.getQuest() != null) {
        return knight.getQuest().isCompleted();
      } else {
        return false;
      }
    };

    int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
        .mapToInt(knight -> knight.getQuest().getReward())
        .sum();

    knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> {
      knight.setQuest(null);
    });

    return sum;
  }

  public void getMyGold(){

    List<Knight> allKnights = getAllKnights();
    allKnights.forEach(knight -> {
          if (knight.getQuest() != null) {
            knight.getQuest().isCompleted();
          }
        }

    );
    int currentGold = playerInformation.getGold();
    playerInformation.setGold(currentGold + collectRewards());
  }
}
