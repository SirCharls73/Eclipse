package es.madrid.redmetro.cgf.manejar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NodoRaiz {

	@JacksonXmlProperty(localName = "trenes")
	private TrenWrapper trenes;

	public TrenWrapper getTrenes() {
		return trenes;
	}

	public void setTrenes(TrenWrapper trenes) {
		this.trenes = trenes;
	}

}
