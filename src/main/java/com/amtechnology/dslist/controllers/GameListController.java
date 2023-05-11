package com.amtechnology.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amtechnology.dslist.dto.GameListDTO;
import com.amtechnology.dslist.services.GameListService;

@RestController //torna a classe um controlador
@RequestMapping(value = "/lists")//caminho para acessar o recurso
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	

	@GetMapping //mapeando o metodo com o verbo http que no caso é para obter
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}