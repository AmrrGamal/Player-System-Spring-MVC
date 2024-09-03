package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Player;
import com.spring.service.PlayerService;
/*
 * in controller:
 *   inject PlayerService (field injection)
 *   use PlayerService to call functions 
 * 
 * 
 */
// http://localhost:8080/Player/ ==> base url 
@Controller
@RequestMapping("/fifa") // if he found "/fifa" in url he will enter this controller
//http://localhost:8080/Player/fifa
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	public PlayerController() {
	}


	//http://localhost:8080/Player/fifa/players
	@GetMapping("/players")
	public String  players(Model model){
		List<Player> players = playerService.allPlayers();
		model.addAttribute("players",players);
		return "fifa-players";
	}
	
	//http://localhost:8080/Player/fifa/add
	@GetMapping("/add")
	public String savePage(Model model) {
		model.addAttribute("player",new Player());// send empty obj to mvc form, name of obj is "player" like edit 
		return "addPlayer";
	}
	
	//http://localhost:8080/Player/fifa/savePayer
	@PostMapping("/savePayer") // post is default method in mvc form
	public String addorUpdateUser(@ModelAttribute("player") Player player) {//recieve filled obj from form after Done
		// the recieved obj سواء من  add or edit 
		//if from add the id is empty ==> add performed
		//if from edit the id is filled ==> update performed
		playerService.savePlayer(player);
		return "redirect:/fifa/players";
	}
	
	//http://localhost:8080/Player/fifa/showplayer
	@GetMapping("/showplayer")
	public String showPlayer(@RequestParam("playerId")int id,Model model) {// @RequestParam to capture playerId from edit url 
		Player p = playerService.showPlayer(id);
		model.addAttribute("player",p); //send filled obj to mvc form ,name of obj is "player" like add 
		return "addPlayer";
	}
	
	
	//http://localhost:8080/Player/fifa/removePlayer
	@GetMapping("/removePlayer")
	public String removePlayer(@RequestParam("playerId") int id) {  // @RequestParam to capture playerId from remove url 
		playerService.deletePlayer(id);
		return "redirect:/fifa/players"; // to display table again with new data ,
		// do not make this "return "fifa-players" this will not perform players fun in cont, this will display page only
	}
}
