package edu.mum.scm.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scm.domain.Team;
import edu.mum.scm.service.TeamService;

@RequestMapping("/teams")
@Controller
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/team-add", method = RequestMethod.GET)
	public String getAddTeamForm(@ModelAttribute Team team) {
		
		return "team-add";
	}

	@RequestMapping(value = { "/team-add" }, method = RequestMethod.POST)
	public String processAddTeamForm(@Valid @ModelAttribute Team team, BindingResult bindingresult, HttpServletRequest request) {
		if (bindingresult.hasErrors()) {
			return "team-add";
		}
		
		MultipartFile image = team.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		if (image != null && !image.isEmpty()) {
			try {
				String imagePath = "team-" + team.getName() + System.currentTimeMillis() +".jpg";
				image.transferTo(new File(rootDirectory + "\\resources\\images\\" + imagePath));
				team.setImagePath(imagePath);
			} catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
			}
		}
		
		team = teamService.save(team);
		
		return "redirect:/teams";
	}
	
	@RequestMapping(value = "/team")
	public String getTeamDetails(@RequestParam("id") Long teamId, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		session.setAttribute("team", teamService.getById(teamId));
//		model.addAttribute("team", teamService.getById(teamId));
//		redirectAttributes.addFlashAttribute("team", teamService.getById(teamId));
		return "redirect:/listPlayer";
	}
	
	@RequestMapping
	public String getAll(Model model) {
		model.addAttribute("teams", teamService.getAll());
		return "team-list";
	}
}
