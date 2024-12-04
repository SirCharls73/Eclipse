package es.madrid.redmetro.cgf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.madrid.redmetro.cgf.dao.ICocheraDAO;
import es.madrid.redmetro.cgf.util.GestorConexion;
import es.madrid.redmetro.cgf.vo.Cochera;

public class CocheraDaoImpl implements ICocheraDAO{

	GestorConexion gC = new GestorConexion();
	
	@Override
	public void insertarCochera(Cochera c) {
		Connection conexion = gC.obtenerConexion();
		String query = "INSERT INTO t_cochera (cod_cochera, nombre, direccion, deposito) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement pst = conexion.prepareStatement(query)) {
			pst.setInt(1, c.getCod_cochera());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getDireccion());
			pst.setInt(4, c.getDeposito());
			int insertado = pst.executeUpdate();
			
			if (insertado == 1) System.out.println("Insertado correctamente");
			else System.out.println("Error en la inserción");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


		
	

	@Override
	public void actualizarCochera(Cochera c) {
		String query = "UPDATE t_cochera SET nombre = ?, direccion = ?, deposito = ? WHERE cod_cochera = ?";
		Connection conexion = gC.obtenerConexion();
		
		try (PreparedStatement pst = conexion.prepareStatement(query)) {
			pst.setString(1, c.getNombre());
			pst.setString(2, c.getDireccion());
			pst.setInt(3, c.getDeposito());
			pst.setInt(4, c.getCod_cochera());
			
			int actualizado = pst.executeUpdate();
			
			if (actualizado == 1) System.out.println("Actualizado correctamente");
			else System.out.println("Error en la actualización");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	@Override
	public void eliminarCochera(int codCochera) {
		String query = "DELETE FROM t_cochera WHERE cod_cochera = (?)";
		Connection conexion = gC.obtenerConexion();
		
		try (PreparedStatement pst = conexion.prepareStatement(query)){
			pst.setInt(1, codCochera);
			
			int eliminado = pst.executeUpdate();
			if (eliminado == 1) System.out.println("Eliminado correctamente");
			else System.out.println("Error en la eliminación");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

		
	





	@Override
	public boolean comprobarCochera(int codCochera) {
		String query = "SELECT * FROM t_cochera WHERE cod_cochera = (?)";
		Connection conexion = gC.obtenerConexion();
		ResultSet resultados = null;
		
		try (PreparedStatement pst = conexion.prepareStatement(query)) {
			 pst.setInt(1, codCochera);
			 resultados = pst.executeQuery();
			 if (resultados.next()) {
				 return true;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
				if (conexion != null) {
					try {
						conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultados != null) {
					try {
						resultados.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		 
		return false;
	}


	
}
