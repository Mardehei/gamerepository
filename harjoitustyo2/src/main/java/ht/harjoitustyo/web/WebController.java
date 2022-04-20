package ht.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ht.harjoitustyo.domain.GameRepository;
import ht.harjoitustyo.domain.GameTypeRepository;
import ht.harjoitustyo.domain.GenreRepository;

@CrossOrigin
@Controller
public class WebController {
	@Autowired
	private GameRepository gamerepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Autowired
	private GameTypeRepository gatyrepository;
	
	/*
		@RequestMapping(value="/games")
		public String gamelist(Model model) {
			model.addAttribute("songs", gamerepository.findAll());
			model.addAttribute("albums", genrerepository.findAll());
			return "games";
		}*/
		
	//Guest Endpoints
		//Guest show database
		@RequestMapping(value = "/guestview", method = RequestMethod.GET)
			public String showDatabaseGuest(Model model) {
			model.addAttribute("games", gamerepository.findAll());
			model.addAttribute("genres", genrerepository.findAll());
			model.addAttribute("gametype", gatyrepository.findAll());
			return "guestview";
		}
		
	//Login and main page
		//Login 
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}
				
		//Index
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String showMainpage(Model model) {
			return "index";
		}
}