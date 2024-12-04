package es.madrid.redmetro.cgf.dao;

import java.util.List;

import es.madrid.redmetro.cgf.vo.Linea;

public interface ILineaDAO {

	List<Linea> obtenerLineas();
	
	Linea obtenerLinea(int cod_linea);
}
