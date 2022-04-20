package ht.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ht.harjoitustyo.domain.Game;
import ht.harjoitustyo.domain.GameRepository;
import ht.harjoitustyo.domain.GameType;
import ht.harjoitustyo.domain.GameTypeRepository;
import ht.harjoitustyo.domain.Genre;
import ht.harjoitustyo.domain.GenreRepository;

@CrossOrigin
@Controller
public class GameController {
	
	@Autowired 
	private GenreRepository gerepository;
	
	@Autowired 
	private GameRepository garepository;	
	
	@Autowired 
	private GameTypeRepository gatyrepository;	
	
	
	@RequestMapping(value = "/games", method = RequestMethod.GET) 
	public String Games(Model model) {	
		model.addAttribute("games", garepository.findAll());
		return "games";
	}
	
	@RequestMapping(value="/games", method = RequestMethod.POST)
	public @ResponseBody Game saveGameRest(@RequestBody Game game) {
		return garepository.save(game);
	}
	
	//Adding and saving a new game
    @RequestMapping(value = "/addgame")
    public String addGame(Model model){
        model.addAttribute("game", new Game());
        model.addAttribute("genre" , gerepository.findAll());
        model.addAttribute("gametype" , gatyrepository.findAll());
        return "addgame";
    } 
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Game game){
        garepository.save(game);
        return "redirect:games";
    }   
	
    //Delete Game
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('USER')")
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		garepository.deleteById(gameId);
		return "redirect:../games";
	}
	
	//Genrelist 
	@RequestMapping(value = "/genrelist", method = RequestMethod.GET)
	public String Genres(Model model) {
		model.addAttribute("genres", gerepository.findAll());
		return "genrelist";
	}
	
	//Adding and saving a new game
    @RequestMapping(value = "/addgenre")
    public String addGenre(Model model){
        model.addAttribute("genre" , gerepository.findAll());
        return "addgenre";
    } 
	
    @RequestMapping(value = "/savegenre", method = RequestMethod.POST)
    public String save(Genre genre){
        gerepository.save(genre);
        return "redirect:genrelist";
    }  
		
//REST-endpoints	
	//Gametype Rest
	@RequestMapping(value = "/gametypelistjson", method = RequestMethod.GET)
	public @ResponseBody List<GameType> getGametypeRest() {
		return (List<GameType>) gatyrepository.findAll();
	}

	//Genrelist Rest
	@RequestMapping(value = "/genrelistjson", method = RequestMethod.GET)
	public @ResponseBody List<Genre> getGenreRest() {
		return (List<Genre>) gerepository.findAll();
	}
	
	//Games Rest
	@RequestMapping(value="/gamesrest", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest() {
		return (List<Game>) garepository.findAll();
	}
	
	//Game Rest with an id
	@RequestMapping(value="/games/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long gameId) {
		return garepository.findById(gameId);
	}
	
}
