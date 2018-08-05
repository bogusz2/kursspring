package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

@Bean(name="inmemoryrepository")
@Profile("dev")
  public KnightRepository createInMemoryRepo(){
  KnightRepository repo = new InMemoryRepository();
  return repo;
}

@Bean(name="DBRepository")
@Profile("prod")
public KnightRepository createDBRepo(){
  KnightRepository repo = new DBKnightRepository();
  return repo;
}


}


