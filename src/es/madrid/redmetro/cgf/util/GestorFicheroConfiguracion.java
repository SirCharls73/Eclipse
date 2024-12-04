package es.madrid.redmetro.cgf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GestorFicheroConfiguracion {

	private static final String RUTAPROP = "conf/conf.properties";
	private static final Properties PROP = new Properties();
	
	
	public static String obtenerValor(String clave) {
		try (FileInputStream is = new FileInputStream(RUTAPROP)) {
			PROP.load(is);
			return PROP.getProperty(clave, "No se encontró la clave: " + clave);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
