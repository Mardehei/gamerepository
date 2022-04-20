package ht.harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ht.harjoitustyo.domain.Game;
import ht.harjoitustyo.domain.GameRepository;
import ht.harjoitustyo.domain.GameType;
import ht.harjoitustyo.domain.GameTypeRepository;
import ht.harjoitustyo.domain.Genre;
import ht.harjoitustyo.domain.GenreRepository;
import ht.harjoitustyo.domain.User;
import ht.harjoitustyo.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository garepository, GenreRepository gerepository, UserRepository urepository, GameTypeRepository gatyrepository) {return (args) -> {
		
		log.info("save a genre");
		Genre strategy = new Genre("Strategy");
		Genre dicegame = new Genre("Dice game");
		Genre cardgame = new Genre("Card game");
		Genre levelgame = new Genre("Level up game");
		Genre puzzle = new Genre("Puzzle Game");
		Genre sologame = new Genre("Sologame");
		Genre fps = new Genre("First Person Shooter");
		Genre escape = new Genre("Escape game");
		Genre open = new Genre("Open World game");
		Genre mmo = new Genre("Massive multiplayer online");
		Genre race = new Genre("Multiplayer game");
		gerepository.save(strategy);
		gerepository.save(dicegame);
		gerepository.save(cardgame);
		gerepository.save(puzzle);
		gerepository.save(sologame);
		gerepository.save(levelgame);
		gerepository.save(fps);
		gerepository.save(escape);
		gerepository.save(open);
		gerepository.save(mmo);
		gerepository.save(race);
		
		log.info("save gametype");
		GameType videogame = new GameType("Videogame");
		GameType boardgame = new GameType("Boardgame");
		gatyrepository.save(videogame);
		gatyrepository.save(boardgame);
		
		log.info("save a game");
		Game g1 = new Game("Animal Crossing", "Build your own island", 1, 300, sologame, videogame);
		Game g2 = new Game("Legend of Zelda: Skyward Sword", "Go on an adventure to different worlds", 1, 200, sologame, videogame);
		Game g3 = new Game("Mario Kart", "Race in mario world with your friends", 4, 100, race, videogame);
		Game g4 = new Game("Spiderman", "Be your own hero and save the world as a spiderman", 1, 250, open, videogame);
		Game g5 = new Game("Legend of Zelda: Breath of the wild", "Battle your way to save princess Zelda", 1, 300, open, videogame);
		Game g6 = new Game("Mario Party", "Play minigames with your friends", 4, 50, race, videogame);
		Game g7= new Game("Search for planet X", "Try to locate Planet X in this sudoku-like game!", 4, 60, strategy, boardgame);
		Game g8= new Game("Terraforming Mars", "Populate Mars while compiting with your friends", 5, 90, strategy, boardgame);
		Game g9= new Game("Talisman", "Avoid obstacles while trying to rush as first to the goal", 4, 120, puzzle, boardgame);
		Game g10= new Game("7 Wonders", "Who builds the best empire?", 4, 70, strategy, boardgame);
		Game g11= new Game("Exit", "Try to escape before time runs out!", 4, 60, escape, boardgame);
		garepository.save(g1);
		garepository.save(g2);
		garepository.save(g3);
		garepository.save(g4);
		garepository.save(g5);
		garepository.save(g6);
		garepository.save(g7);
		garepository.save(g8);
		garepository.save(g9);
		garepository.save(g10);
		garepository.save(g11);
		

		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
		urepository.save(user1);
		
		log.info("fetch all games");
		for (Game game : garepository.findAll()) {
			log.info(game.toString());
		}
	};
	}

}
