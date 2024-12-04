package es.madrid.redmetro.cgf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.madrid.redmetro.cgf.dao.IColorDAO;
import es.madrid.redmetro.cgf.util.GestorConexion;
import es.madrid.redmetro.cgf.vo.Color;

public class ColorDaoImpl implements IColorDAO{
	
	GestorConexion gC = new GestorConexion();
	
	@Override
	public List<Color> obtenerColores() {
		Connection conex = gC.obtenerConexion();
		String query = "SELECT * FROM t_color";
		List<Color> colores = new ArrayList<>();
		ResultSet resultados = null;
		
		try(PreparedStatement pst = conex.prepareStatement(query)) {
			resultados = pst.executeQuery();
			while(resultados.next()) {
				Color c = new Color();
				c.setCod_color(resultados.getInt(1));
				c.setNombre(resultados.getString(2));
				c.setCod_hexadecimal(resultados.getString(3));
				colores.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conex != null) {
				try {
					conex.close();
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
		
		return colores;
	}

	@Override
	public Color obtenerColor(int cod_color) {
		List<Color>colores = obtenerColores();
		Color color = new Color();
		for (Color c : colores) {
			if (c.getCod_color() == cod_color) {
				color = c;
			}
		}
		return color;
	}

	
}
