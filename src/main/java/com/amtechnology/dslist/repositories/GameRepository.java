package com.amtechnology.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amtechnology.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	

}

//Esse é componete da camada de acesso aos dados
//O repository faz consultas ao banco, aqui foi usado o JPA do Spring
