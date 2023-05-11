package com.amtechnology.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amtechnology.dslist.entities.Game;
import com.amtechnology.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	// o nativeQuery=true tem que ser usado para poder usar o SQL nativo e não a
	// JPQL porem o resultado da consulta tem que ser uma interface, no caso do
	// spring tem o nome de projection;
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);// o parametro do metodo tem que ser igual o que deja obter na
														// consulta, no caso usa :listId no where
}

//Esse é componete da camada de acesso ao banco de dados, toda consulta dever ser colacada aqui
//O repository faz consultas ao banco, aqui foi usado o JPA do Spring
