package es.madrid.redmetro.cgf.manejar;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import es.madrid.redmetro.cgf.vo.Tren;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "trenes")
public class TrenWrapper {

    @JacksonXmlElementWrapper(useWrapping = false) 
    @JacksonXmlProperty(localName = "tren") 
    private List<Tren> trenes;

    public TrenWrapper() {
        this.trenes = new ArrayList<>();
    }

   
    public TrenWrapper(List<Tren> trenes) {
        this.trenes = trenes;
    }

    
    public List<Tren> getTrenes() {
        return trenes;
    }

    public void setTrenes(List<Tren> trenes) {
        this.trenes = trenes;
    }

    
}
