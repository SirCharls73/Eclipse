package es.madrid.redmetro.cgf.dao;


import java.util.List;

import es.madrid.redmetro.cgf.vo.Color;

public interface IColorDAO {

	List<Color>obtenerColores();
	
	Color obtenerColor(int cod_color);
	
	
}
