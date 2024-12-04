package es.madrid.redmetro.cgf.dao;

import es.madrid.redmetro.cgf.vo.Cochera;

public interface ICocheraDAO {

	void insertarCochera(Cochera c);
	
	void actualizarCochera(Cochera c);
	
	void eliminarCochera(int codCochera);
	
	boolean comprobarCochera(int codCochera);
}
