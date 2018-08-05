package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryRepository implements KnightRepository {


  Map<Integer, Knight> knights = new HashMap<>();

  public InMemoryRepository() {
  }

  @Override
  public void createKnight(String name, int age) {
    Knight newKnight = new Knight(name, age);
    newKnight.setId(Ids.generateNewId(knights.keySet()));
    knights.put(newKnight.getId(), newKnight);
  }

  @Override
  public Collection<Knight> getAllKnights() {
    return knights.values();
  }

  @Override
  public Optional<Knight> getKnight(String name) {
    Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
    return knightByName;
  }

  @Override
  public void deleteKnight(Integer id) {
    System.out.println(knights);
    System.out.println("Delete " + id);
    knights.remove(id);
  }

  @Override
  @PostConstruct
  public void build() {
    createKnight("Lancelot", 29);
    createKnight("Percival", 25);
    System.out.println("Wybudowano zamek");
  }

  @Override
  public void createKnight(Knight knight) {
    knights.put(Ids.generateNewId(knights.keySet()), knight);
  }

  @Override
  public Knight getKnightById(Integer id) {
    return knights.get(id);
  }

  @Override
  public void updateKnight(int id, Knight knight) {
    knights.put(id, knight);
  }

  @Override
  public String toString() {
    return "InMemoryRepository{" +
        "knights=" + knights +
        '}';
  }
}
