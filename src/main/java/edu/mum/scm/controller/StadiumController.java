package edu.mum.scm.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scm.domain.Stadium;
import edu.mum.scm.service.StadiumService;

@Controller
@RequestMapping(value="/stadiums")
public class StadiumController {
	
	@Autowired
	StadiumService stadiumService;
	
	@RequestMapping(value= {"/","/list"}, method = RequestMethod.GET)
	public String listStadium(Model model) {
		List<Stadium> stadiums = stadiumService.getAllStadium();
		model.addAttribute("stadiums", stadiums);
		return "stadium_list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addStadium(@ModelAttribute("newStadium") Stadium stadium) {
		return "stadium_add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String editStadium(@Valid @ModelAttribute("newStadium") Stadium stadium, @RequestParam("type") String type, BindingResult bindingResult, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			if (type.equals("edit")) return "stadium_edit";
			return "stadium_add";
		}
		
		MultipartFile image = stadium.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory + "\\resources\\images\\" + stadium.getId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
			}
		}
		
		String path = rootDirectory + "\\resources\\images\\" + stadium.getId() + ".jpg";
		stadium.setImagePath(path);
		
//		stadium.setTeam((Team) model.asMap().get("team"));
		if (type.equals("edit")) {
			stadiumService.editStadium(stadium);
		} else {
			stadiumService.addStadium(stadium);
		}
		redirectAttributes.addFlashAttribute("stadium", stadium);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		
		return "redirect:/stadiums/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPlayer(@ModelAttribute("stadium") Stadium stadiumUpdated, Model model, @PathVariable("id") Long id) {
		Stadium stadium = stadiumService.getStadiumById(id);
		model.addAttribute("stadium", stadium);
		return "stadium_edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updatePlayer(@ModelAttribute("stadium") Stadium stadiumUpdated, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "stadium_edit";
		}
		stadiumService.editStadium(stadiumUpdated);
//		Stadium stadium = stadiumService.getStadiumById(id);
//		model.addAttribute("stadium", stadium);
		return "redirect:/stadiums/list";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public String deleteStadium(@PathVariable("id") Long id) {
		Stadium stadium = stadiumService.getStadiumById(id);
		stadiumService.deleteStadium(stadium);
		return "redirect:/stadiums/list";
	}
}
