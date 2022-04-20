package ht.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GameTypeRepository extends CrudRepository<GameType, Long>{

	List<GameType> findByName(String name);
	
}

