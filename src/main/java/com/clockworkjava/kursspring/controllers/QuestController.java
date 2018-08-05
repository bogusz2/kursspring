package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.services.KnightService;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

  @Autowired
  QuestService questService;

  @Autowired
  KnightService knightService;

  @Autowired
  PlayerInformation playerInformation;

  @RequestMapping("/assignQuest")
  public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
    Knight knight = knightService.getKnight(id);
    List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
    model.addAttribute("knight", knight);
    model.addAttribute("notStartedQuests", notStartedQuests);
    return "assignQuest";
  }

  @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
  public String assignQuest(Knight knight) {
    //System.out.println(result);
    knightService.updateKnight(knight);
    Quest quest = knight.getQuest();

    questService.update(quest);
    return "redirect:/knights";
  }

  @RequestMapping(value = "/checkQuests")
  public String checkQuests(Knight knight) {

    knightService.getMyGold();


    return "redirect:/knights";
  }
}
