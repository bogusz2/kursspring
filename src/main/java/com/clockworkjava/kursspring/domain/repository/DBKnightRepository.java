package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {
  @Override
  public void createKnight(String name, int age) {
    System.out.println("Używam bazy danych");
  }

  @Override
  public Collection<Knight> getAllKnights() {
    System.out.println("Używam bazy danych");
    throw new NotImplementedException();
  }

  @Override
  public Optional<Knight> getKnight(String name) {
    System.out.println("Używam bazy danych");
    throw new NotImplementedException();
  }

  @Override
  public void deleteKnight(Integer id) {
    System.out.println("Używam bazy danych");
  }

  @Override
  public void build() {
    System.out.println("Używam bazy danych");
  }

  @Override
  public void createKnight(Knight knight) {
    System.out.println("Używam bazy danych");
  }

  @Override
  public Knight getKnightById(Integer id) {
    System.out.println("Używam bazy danych");
    throw new NotImplementedException();
  }

  @Override
  public String toString() {
    return "DBKnightRepository{}";
  }
}
