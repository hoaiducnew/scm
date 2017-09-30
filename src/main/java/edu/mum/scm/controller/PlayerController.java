package edu.mum.scm.controller;

import java.io.File;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scm.domain.Player;
import edu.mum.scm.domain.Team;
import edu.mum.scm.service.PlayerService;

@Controller
@SessionAttributes({ "team" })
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@ModelAttribute("positions")
	public HashMap<String,String> getPosition(Model model){
		HashMap<String,String> positions = new HashMap<String,String>();
		positions.put("GO", "Goalkeeper");
		positions.put("DE", "Defenders");
		positions.put("MI", "Midfielders");
		positions.put("FO", "Forwards");
		model.addAttribute("positions", positions);
		return positions; 
	}

	@RequestMapping(value = "/listPlayer", method = RequestMethod.GET)
	public String allPlayers(Model model) {
		
		List<Player> players = playerService.getAllPlayer((Team) model.asMap().get("team"));
		model.addAttribute("players", players);
		
		return "player_list";
	}

	@RequestMapping(value = "/editPlayer/{id}", method = RequestMethod.GET)
	public String ediPlayer(@ModelAttribute("playerForUpdated") Player player, Model model, @PathVariable("id") Long id) {
		
		Player playerForUpdated = playerService.getPlayer(id);
		model.addAttribute("playerForUpdated", playerForUpdated);
		
		return "player_edit";
	}

	@RequestMapping(value = { "/editPlayer/{id}" }, method = RequestMethod.POST)
	public String editPlayer(@Valid @ModelAttribute("playerForUpdated") Player player, BindingResult bindingresult, Model model, @PathVariable("id") Long id) {

		if (bindingresult.hasErrors()) 
			return "player_edit";
		playerService.editPlayer(player);
		
		return "redirect:/listPlayer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPlayer(@ModelAttribute("addPlayer") Player player, Model model) {
		return "player_add";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addPlayer(@Valid @ModelAttribute("addPlayer") Player player, BindingResult bindingresult, Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		if (bindingresult.hasErrors()) 
			return "player_add";
		MultipartFile image = player.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory + "\\resources\\images\\" + player.getPlayerId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
			}
		}

		String path = rootDirectory + "\\resources\\images\\" + player.getFirstName() + ".jpg";
		player.setImagePath(path);
		player.setTeam((Team) model.asMap().get("team"));
		playerService.addPlayer(player);
		redirectAttributes.addFlashAttribute("player", player);
		redirectAttributes.addFlashAttribute("message", "Added successfully.");
		
		return "redirect:/listPlayer";
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@ModelAttribute("playerForUpdated") Player player, Model model, @PathVariable("id") Long id) {
		
		Player playerForUpdated = playerService.getPlayer(id);
		model.addAttribute("playerForUpdated", playerForUpdated);
		
		return "player_detail";
	}
	
	@RequestMapping(value = "/deletePlayer/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		playerService.deletePlayer(id);

		return "redirect:/listPlayer";
	}

}
