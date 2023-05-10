package com.amtechnology.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amtechnology.dslist.dto.GameMinDTO;
import com.amtechnology.dslist.services.GameService;

@RestController //torna a classe um controlador
@RequestMapping(value = "/games")//caminho para acessar o recurso
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping //mapeando o metodo com o verbo http que no caso é para obter
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
