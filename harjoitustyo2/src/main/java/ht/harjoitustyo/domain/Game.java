package ht.harjoitustyo.domain;

import java.security.Principal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Game { 
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		private String name;
		private String description;
		private int maxNumberOfPlayers;
		private int timeOfGame;

		@ManyToOne
		@JsonIgnoreProperties("games")
		@JoinColumn(name = "genreId")
		private Genre genre;
		
		@ManyToOne
		@JsonIgnoreProperties("games")
		@JoinColumn(name = "typeId")
		private GameType gametype;
		
	    public Game() {
	    }
		
		public Game(String name, String description, int maxNumberOfPlayers, int timeOfGame, Genre genre, GameType gametype) {
			super();
			this.name = name;
			this.description = description;
			this.maxNumberOfPlayers = maxNumberOfPlayers;
			this.timeOfGame = timeOfGame;
			this.genre = genre;
			this.gametype = gametype;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getMaxNumberOfPlayers() {
			return maxNumberOfPlayers;
		}

		public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
			this.maxNumberOfPlayers = maxNumberOfPlayers;
		}

		public int getTimeOfGame() {
			return timeOfGame;
		}

		public void setTimeOfGame(int timeOfGame) {
			this.timeOfGame = timeOfGame;
		}

		public Genre getGenre() {
			return genre;
		}

		public void setGenre(Genre genre) {
			this.genre = genre;
		}
		
		public GameType getGametype() {
			return gametype;
		}

		public void setGametype(GameType gametype) {
			this.gametype = gametype;
		}

		@Override
		public String toString() {
			return "Game [id=" + id + ", name=" + name + ", description=" + description + ", maxNumberOfPlayers="
					+ maxNumberOfPlayers + ", timeOfGame=" + timeOfGame + "]";
		}
		
		
}
