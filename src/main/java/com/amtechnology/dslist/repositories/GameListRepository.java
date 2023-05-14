package com.amtechnology.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.amtechnology.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}

//Esse é componete da camada de acesso aos dados
//O repository faz consultas ao banco, aqui foi usado o JPA do Spring
