package com.amtechnology.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amtechnology.dslist.dto.GameListDTO;
import com.amtechnology.dslist.dto.GameMinDTO;
import com.amtechnology.dslist.dto.ReplacementDTO;
import com.amtechnology.dslist.services.GameListService;
import com.amtechnology.dslist.services.GameService;

@RestController //torna a classe um controlador
@RequestMapping(value = "/lists")//caminho para acessar o recurso
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;

	@GetMapping //mapeando o metodo com o verbo http que no caso é para obter
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	@GetMapping(value="/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	@PostMapping(value="/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
}
