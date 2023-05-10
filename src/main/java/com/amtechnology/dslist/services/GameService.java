package com.amtechnology.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amtechnology.dslist.dto.GameMinDTO;
import com.amtechnology.dslist.entities.Game;
import com.amtechnology.dslist.repositories.GameRepository;

@Service //para registrar o componete, poderia usar o @Componet
public class GameService {
	
	@Autowired //injeção de dependência
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
