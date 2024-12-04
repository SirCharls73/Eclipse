package es.madrid.redmetro.cgf.vo;


import java.sql.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Tren {

    @JacksonXmlProperty(isAttribute = true) 
    private int id;

    @JacksonXmlProperty(localName = "modelo")
    private String modelo;

    @JacksonXmlProperty(localName = "anyo_incorporacion")
    private Date anioIncorporacion;

    @JacksonXmlProperty(localName = "empresa_constructora")
    private String empresaConstructora;

    @JacksonXmlProperty(localName = "cod_cochera")
    private int codCochera;

    @JacksonXmlProperty(localName = "id_linea")
    private int idLinea;
    
    
    public Tren() {
    }

    
    public Tren(int id, String modelo, Date anioIncorporacion, String empresaConstructora, int codCochera, int idLinea) {
        this.id = id;
        this.modelo = modelo;
        this.anioIncorporacion = anioIncorporacion;
        this.empresaConstructora = empresaConstructora;
        this.codCochera = codCochera;
        this.idLinea = idLinea;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(Date anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getEmpresaConstructora() {
        return empresaConstructora;
    }

    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }

    public int getCodCochera() {
        return codCochera;
    }

    public void setCodCochera(int codCochera) {
        this.codCochera = codCochera;
    }

    public int getLinea() {
        return idLinea;
    }

    public void setLinea(int idLinea) {
        this.idLinea = idLinea;
    }


	public int getIdLinea() {
		return idLinea;
	}


	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}


	@Override
	public String toString() {
		return "Tren [id=" + id + ", modelo=" + modelo + ", anioIncorporacion=" + anioIncorporacion
				+ ", empresaConstructora=" + empresaConstructora + ", codCochera=" + codCochera + ", idLinea=" + idLinea
				+ "]";
	}

   
}
