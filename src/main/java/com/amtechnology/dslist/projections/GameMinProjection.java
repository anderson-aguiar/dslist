package com.amtechnology.dslist.projections;

public interface GameMinProjection {
	//aqui tem que colocar os gets correspondentes a consulta SQL
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
	
}
