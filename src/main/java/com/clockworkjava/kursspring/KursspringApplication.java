package com.clockworkjava.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@PropertySource("classpath:inMemoryRepository.properties")
//@ImportResource("classpath:config/spring-config.xml")
@EnableScheduling
public class KursspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursspringApplication.class, args);

	}
}
