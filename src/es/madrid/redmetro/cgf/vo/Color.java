package es.madrid.redmetro.cgf.vo;

public class Color {

	private int cod_color;
	private String nombre;
	private String cod_hexadecimal;
	
	public Color() {
		
	}
	
	public Color(int cC, String n, String cH) {
		this.cod_color = cC;
		this.nombre = n;
		this.cod_hexadecimal = cH;
	}

	public int getCod_color() {
		return cod_color;
	}

	public void setCod_color(int cod_color) {
		this.cod_color = cod_color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCod_hexadecimal() {
		return cod_hexadecimal;
	}

	public void setCod_hexadecimal(String cod_hexadecimal) {
		this.cod_hexadecimal = cod_hexadecimal;
	}
	
	
}
