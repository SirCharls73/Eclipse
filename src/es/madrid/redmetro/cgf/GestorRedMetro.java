package es.madrid.redmetro.cgf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.madrid.redmetro.cgf.dao.ICocheraDAO;
import es.madrid.redmetro.cgf.dao.ILineaDAO;
import es.madrid.redmetro.cgf.dao.ITrenDAO;
import es.madrid.redmetro.cgf.dao.impl.CocheraDaoImpl;
import es.madrid.redmetro.cgf.dao.impl.LineaDaoImpl;
import es.madrid.redmetro.cgf.dao.impl.TrenDaoImpl;
import es.madrid.redmetro.cgf.manejar.NodoRaiz;
import es.madrid.redmetro.cgf.manejar.TrenWrapper;
import es.madrid.redmetro.cgf.util.GestorFicheroConfiguracion;
import es.madrid.redmetro.cgf.vo.Cochera;
import es.madrid.redmetro.cgf.vo.Linea;
import es.madrid.redmetro.cgf.vo.Tren;

public class GestorRedMetro {

	final String RUTAXML = GestorFicheroConfiguracion.obtenerValor("rutaxml");
	final String RUTACSV = GestorFicheroConfiguracion.obtenerValor("rutacsv");
	final String RUTAXMLESCRIBIR = GestorFicheroConfiguracion.obtenerValor("rutaxmlgenerar");
	
	public static void main(String[] args) {
		
		GestorRedMetro gRM = new GestorRedMetro();
		Scanner sc = new Scanner(System.in);
		
		//Comentario
		boolean seguir = true;
		
		do {
			
			String opc = gRM.menu(sc);
			
			switch(opc) {
				case "A":
					gRM.obtenerInformacionLinea(sc);
					break;
				case "B":
					gRM.cargarFicheroXML();
					break;
				case "C":
					gRM.tratarFicheroCocheras();
					break;
				case "D":
					gRM.generarFicheroXML();
					break;
				case "E":
					System.out.println("Fin del programa");
					seguir = false;
					break;
				default:
					System.out.println("Opción no válida, vuelva a intentarlo");
			}
		} while (seguir);
		
	}

	public String menu(Scanner sc) {
		System.out.println("Introduzca operación a realizar\nA: Información línea.\nB: Cargar fichero XML de trenes.\nC: Tratar fichero cocheras\nD: Generar fichero XML de trenes\nE: Salir");
		String opc = sc.nextLine();
		return opc.toUpperCase();
	}
	
	public void obtenerInformacionLinea(Scanner sc) {
		System.out.println("Introduce código de la línea:");
		ILineaDAO gestorLinea = new LineaDaoImpl();
		
		try {
			int cod = sc.nextInt();
			Linea l = gestorLinea.obtenerLinea(cod);
			if (l == null) {
				System.out.println("No se encontró la línea");
			} else {
				System.out.println("El color de la Línea " + l.getCod_linea() + " (" + l.getNombre_largo() + "), que tiene una longitud de " + l.getKilometros() + " Kilómetros, es " + l.getColor().getNombre() + " (" + l.getColor().getCod_hexadecimal() + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarFicheroXML() {
	    ITrenDAO gestorTrenes = new TrenDaoImpl();

	    try {
	        XmlMapper xmlMapper = new XmlMapper();

	        File xmlFile = new File(RUTAXML);
	        
	        NodoRaiz nodoRaiz = xmlMapper.readValue(xmlFile, NodoRaiz.class);
	        TrenWrapper trenesWrapper = nodoRaiz.getTrenes();
	        for (Tren tren : trenesWrapper.getTrenes()) {
	            System.out.println(tren); 
	            gestorTrenes.insertarTren(tren);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void tratarFicheroCocheras() {
		ICocheraDAO gestorCocheras = new CocheraDaoImpl();
		
		try (BufferedReader br = new BufferedReader(new FileReader(RUTACSV))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String [] partesLinea = linea.split(";");
				if (partesLinea[0].length() == 1) {
					if (Integer.parseInt(partesLinea[0]) == 1) {
						
						Cochera c = new Cochera(Integer.parseInt(partesLinea[1]), partesLinea[3], partesLinea[4], Integer.parseInt(partesLinea[2]));
						if (!gestorCocheras.comprobarCochera(c.getCod_cochera())) {
							gestorCocheras.insertarCochera(c);
						}
					} else if (Integer.parseInt(partesLinea[0]) == 2) {
						Cochera c = new Cochera(Integer.parseInt(partesLinea[1]), partesLinea[3], partesLinea[4], Integer.parseInt(partesLinea[2]));
						gestorCocheras.actualizarCochera(c);
					} else if (Integer.parseInt(partesLinea[0]) == 3) {
						Cochera c = new Cochera(Integer.parseInt(partesLinea[1]), partesLinea[3], partesLinea[4], Integer.parseInt(partesLinea[2]));
						gestorCocheras.eliminarCochera(c.getCod_cochera());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generarFicheroXML() {
		ITrenDAO gestorTrenes = new TrenDaoImpl();
		
		List<Tren> trenes = gestorTrenes.obtenerTrenes();
	    try {
	        XmlMapper xMpp = new XmlMapper();
	      
	        xMpp.writerWithDefaultPrettyPrinter().writeValue(new File(RUTAXMLESCRIBIR), new TrenWrapper(trenes));

	    } catch (IOException e) {
	        System.out.println("ERROR:");
	        e.printStackTrace();
	    }
	}
	
}
