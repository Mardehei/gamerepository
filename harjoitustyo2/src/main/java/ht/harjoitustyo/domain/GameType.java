package ht.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GameType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="gametype")
	@JsonIgnoreProperties("gametype")
	private List<Game> games;
	
	public Long getTypeId() {
		return typeId;
	}


	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public GameType() {
	}
	
	
	public GameType(String name) {
		super();
		this.name = name;
	}


	public List<Game> getGames() {
		return games;
	}


	public void setGames(List<Game> games) {
		this.games = games;
	}


	@Override
	public String toString() {
		return "GameType [typeId=" + typeId + ", name=" + name + "]";
	}




}