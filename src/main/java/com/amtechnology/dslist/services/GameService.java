package com.amtechnology.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amtechnology.dslist.dto.GameDTO;
import com.amtechnology.dslist.dto.GameMinDTO;
import com.amtechnology.dslist.entities.Game;
import com.amtechnology.dslist.repositories.GameRepository;

@Service //para registrar o componete, poderia usar o @Componet
public class GameService {
	
	@Autowired //injeção de dependência
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //faz com que o metodo fique transacional para obdecer o ACID
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
