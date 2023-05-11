package com.amtechnology.dslist.dto;

import com.amtechnology.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}
	//Como não foi usado o BeanUtils, fazer apenas os gets
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
}
