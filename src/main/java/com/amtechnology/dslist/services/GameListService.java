package com.amtechnology.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amtechnology.dslist.dto.GameListDTO;
import com.amtechnology.dslist.entities.GameList;
import com.amtechnology.dslist.repositories.GameListRepository;

@Service //para registrar o componete, poderia usar o @Componet
public class GameListService {
	
	@Autowired //injeção de dependência
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
}
