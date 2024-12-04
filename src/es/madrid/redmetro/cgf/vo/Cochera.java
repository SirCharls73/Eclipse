package es.madrid.redmetro.cgf.vo;

public class Cochera {

	private int cod_cochera;
	private String nombre;
	private String direccion;
	private int deposito;
	
	public Cochera() {
		
	}
	
	public Cochera(int cC, String n, String d, int dp) {
		this.cod_cochera = cC;
		this.nombre = n;
		this.direccion = d;
		this.deposito = dp;
	}

	public int getCod_cochera() {
		return cod_cochera;
	}

	public void setCod_cochera(int cod_cochera) {
		this.cod_cochera = cod_cochera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDeposito() {
		return deposito;
	}

	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	
	
}
