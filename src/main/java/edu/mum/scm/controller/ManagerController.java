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

import edu.mum.scm.domain.Manager;
import edu.mum.scm.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping(value = "/listManager", method = RequestMethod.GET)
	public String allManagers(Model model) {
		
		List<Manager> Managers = managerService.getAllManager();
		model.addAttribute("Managers", Managers);
		
		return "manager_list";
	}
	
	@RequestMapping(value = "/addManager", method = RequestMethod.GET)
	public String addManager(@ModelAttribute("addManager") Manager manager, Model model) {
		
		return "manager_add";
	}
	

	@RequestMapping(value = { "/addManager" }, method = RequestMethod.POST)
	public String addManager(@Valid @ModelAttribute("addManager") Manager manager, BindingResult bindingresult, Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		if (bindingresult.hasErrors()) 
			return "manager_add";
		MultipartFile image = manager.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory + "\\resources\\images\\" + manager.getManagerId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
			}
		}

		String path = rootDirectory + "\\resources\\images\\" + manager.getFirstName() + ".jpg";
		manager.setImagePath(path);
		
		managerService.addManager(manager);
		redirectAttributes.addFlashAttribute("manager", manager);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		
		return "redirect:/listManager";
	}
	

	@RequestMapping(value = "/detail_manager/{id}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("managerForUpdated") Manager manager, Model model, @PathVariable("id") Long id) {
		
		Manager managerForUpdated = managerService.getManager(id);
		model.addAttribute("managerForUpdated", managerForUpdated);
		
		return "manager_detail";
	}
	
	@RequestMapping(value = "/editManager/{id}", method = RequestMethod.GET)
	public String ediManager(@ModelAttribute("managerForUpdated") Manager manager, Model model, @PathVariable("id") Long id) {
		
		Manager managerForUpdated = managerService.getManager(id);
		model.addAttribute("managerForUpdated", managerForUpdated);
		
		return "manager_edit";
	}
	
	@RequestMapping(value = { "/editManager/{id}" }, method = RequestMethod.POST)
	public String editManager(@Valid @ModelAttribute("ManagerForUpdated") Manager Manager, BindingResult bindingresult, Model model, @PathVariable("id") Long id) {

		if (bindingresult.hasErrors()) 
			return "Manager_edit";
		managerService.editManager(Manager);
		
		return "redirect:/listManager";
	}
	
	@RequestMapping(value = "/deleteManager/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		managerService.deleteManager(id);
		return "redirect:/listManager";
	}
}