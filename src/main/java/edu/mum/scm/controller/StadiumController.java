package edu.mum.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.scm.domain.Stadium;
import edu.mum.scm.service.StadiumService;

@Controller
@RequestMapping(value="/stadium")
public class StadiumController {
	@Autowired
	StadiumService stadiumService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listStadium(Model model) {
		List<Stadium> stadiums = stadiumService.getAllStadium();
		model.addAttribute("stadiums", stadiums);
		return "listStadium";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addStadium(@ModelAttribute("newStadium") Stadium stadium) {
		return "addStadium";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String editStadium() {
		return "redirect:/listStadium";
	}
	
	public String deleteStadium() {
		return "";
	}
}
