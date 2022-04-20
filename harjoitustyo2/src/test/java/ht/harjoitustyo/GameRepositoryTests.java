package ht.harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ht.harjoitustyo.domain.Game;
import ht.harjoitustyo.domain.GameRepository;
import ht.harjoitustyo.domain.GameType;
import ht.harjoitustyo.domain.GameTypeRepository;
import ht.harjoitustyo.domain.Genre;
import ht.harjoitustyo.domain.GenreRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GameRepositoryTests {
	
	@Autowired
	private GameRepository gamerepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Autowired
	private GameTypeRepository typerepository;
	
	//Test for games
	@Test
	public void findByNameShouldReturnGame() {
		List<Game> games = gamerepository.findByName("Mario Kart");
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getName()).isEqualTo("Mario Kart");
	}
	
	//Test for genres
	@Test
	public void findByNameShouldReturnGenre() {
		List<Genre> genres = genrerepository.findByName("Sologame");
        assertThat(genres).hasSize(1);
        assertThat(genres.get(0).getName()).isEqualTo("Sologame");
	}
	
	//Test for gametypes
	@Test
	public void findByNameShouldReturnGameType() {
		List<GameType> types = typerepository.findByName("Videogame");
        assertThat(types).hasSize(1);
        assertThat(types.get(0).getName()).isEqualTo("Videogame");
	}
	
	@Test
	public void createNewGame() {
	Game game = new Game("Hugo", "Be a Hugo", 1, 300, null, null);
	gamerepository.save(game);
	assertThat(game.getId()).isNotNull();
	} 
	
	@Test
	public void deleteGame() {
		List<Game> games = gamerepository.findByName("Mario Kart");
		Long id = games.get(0).getId();
		gamerepository.deleteById(id);
		assertThat(gamerepository.count()).isEqualTo(10);
	}

}
