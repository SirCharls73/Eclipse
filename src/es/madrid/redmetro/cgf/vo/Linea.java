package es.madrid.redmetro.cgf.vo;

public class Linea {

	private int cod_linea;
	private String nombre_corto;
	private String nombre_largo;
	private Color color;
	private double kilometros;
	
	public Linea() {
		
	}
	
	public Linea(int cL, String nC, String nL, Color cC, double k) {
		this.cod_linea = cL;
		this.nombre_corto = nC;
		this.nombre_largo = nL;
		this.color = cC;
		this.kilometros = k;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		return cod_linea == other.cod_linea;
	}

	
	public int getCod_linea() {
		return cod_linea;
	}

	public void setCod_linea(int cod_linea) {
		this.cod_linea = cod_linea;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_largo() {
		return nombre_largo;
	}

	public void setNombre_largo(String nombre_largo) {
		this.nombre_largo = nombre_largo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color cod_color) {
		this.color = cod_color;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}
	
	
}
