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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scm.domain.FanClub;
import edu.mum.scm.service.FanClubService;

@Controller
@RequestMapping(value="/fanclubs")
public class FanClubController {
	
	@Autowired
	FanClubService fanclubService;
	
	@RequestMapping(value= {"/","/list"}, method = RequestMethod.GET)
	public String listfanclub(Model model) {
		List<FanClub> fanclubs = fanclubService.getAllFanClub();
		model.addAttribute("fanclubs", fanclubs);
		return "fanclub_list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addfanclub(@ModelAttribute FanClub fanClub) {
		return "fanclub_add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String editfanclub(@Valid @ModelAttribute("newfanclub") FanClub fanclub, BindingResult bindingResult, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "fanclub_add";
		}
		
		MultipartFile image = fanclub.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory + "\\resources\\images\\fanclub-" + fanclub.getName() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
			}
		}
		
		String path = rootDirectory + "\\resources\\images\\fanclub-" + fanclub.getName() + ".jpg";
		fanclub.setImagePath(path);
		
		fanclubService.addFanClub(fanclub);
		redirectAttributes.addFlashAttribute("fanclub", fanclub);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		
		return "redirect:/fanclubs/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPlayer(@ModelAttribute("fanclub") FanClub fanclubUpdated, Model model, @PathVariable("id") Long id) {
		FanClub fanclub = fanclubService.getFanClubById(id);
		model.addAttribute("fanclub", fanclub);
		return "fanclub_edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updatePlayer(@ModelAttribute("fanclub") FanClub fanclubUpdated, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "fanclub_edit";
		}
		fanclubService.editFanclub(fanclubUpdated);
//		fanclub fanclub = fanclubService.getfanclubById(id);
//		model.addAttribute("fanclub", fanclub);
		return "redirect:/fanclubs/list";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public String deletefanclub(@PathVariable("id") Long id) {
		FanClub fanclub = fanclubService.getFanClubById(id);
		fanclubService.deleteFanClub(fanclub);
		return "redirect:/fanclubs/list";
	}

}
