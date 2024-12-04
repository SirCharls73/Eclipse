package es.madrid.redmetro.cgf.dao;

import java.util.List;

import es.madrid.redmetro.cgf.vo.Tren;

public interface ITrenDAO {

	void insertarTren(Tren t);
	
	List<Tren>obtenerTrenes();
}
