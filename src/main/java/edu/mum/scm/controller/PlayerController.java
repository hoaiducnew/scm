package edu.mum.scm.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.scm.domain.Player;
import edu.mum.scm.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value = "/listPlayer", method = RequestMethod.GET)
	public String allPlayers(Model model) {
		List<Player> players = playerService.getAllPlayer();
		model.addAttribute("players", players);
		return "home";
	}
	
}
