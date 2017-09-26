package edu.mum.scm.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String processAddTeamForm(@Valid @ModelAttribute Team team, BindingResult bindingresult,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
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
		
		
		redirectAttributes.addFlashAttribute("team", team);

		return "redirect:/teams/team-details";
	}
	
	@RequestMapping(value = "/team-details", method = RequestMethod.GET)
	public String getTeamDetails(@ModelAttribute Team team) {
		return "team-details";
	}
	
	
	@RequestMapping(value = "/team-list", method = RequestMethod.GET)
	public String getTeamDetails(Model model) {
		model.addAttribute("teams", teamService.getAll());
		return "team-list";
	}
}
