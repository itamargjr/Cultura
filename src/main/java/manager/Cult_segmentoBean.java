package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Cult_segmento;
import persistence.Cult_segmentoDao;

@ManagedBean
@ViewScoped
public class Cult_segmentoBean {
	
	public Cult_segmento segmento;
	
	public List<Cult_segmento> segmentolista;
	
	public List<String> descricaosegmentolista;
	public List<String> diassegmentolista;
	
	public Cult_segmentoBean() {
		
		segmento = new Cult_segmento();
		
		segmentolista = new ArrayList<Cult_segmento>();
		
	}

	public List<String> getDescricaosegmentolista() {
		return descricaosegmentolista;
	}

	public void setDescricaosegmentolista(List<String> descricaosegmentolista) {
		this.descricaosegmentolista = descricaosegmentolista;
	}

	public List<String> getDiassegmentolista() {
		return diassegmentolista;
	}

	public void setDiassegmentolista(List<String> diassegmentolista) {
		this.diassegmentolista = diassegmentolista;
	}

	public Cult_segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Cult_segmento segmento) {
		this.segmento = segmento;
	}

	public List<Cult_segmento> getSegmentolista() {
		return segmentolista;
	}

	public void setSegmentolista(List<Cult_segmento> segmentolista) {
		this.segmentolista = segmentolista;
	}
	
	public void preenchelistas() {
		if ((segmento.getAno_segmento()!=null) && (segmento.getAno_segmento()>0)) {
			try {
				
				Cult_segmentoDao sd = new Cult_segmentoDao(); 
				
				descricaosegmentolista = sd.retornaDescricaoSegmento(segmento.getAno_segmento());
				
				diassegmentolista = sd.retornaDiasSegmento(segmento.getAno_segmento());
				
				//System.out.println(edu_func_escolalista);
				
			} catch (Exception e) {
				e.printStackTrace();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			}
		}
	}
	
	public void buscar() {
		Cult_segmentoDao sd = new Cult_segmentoDao(); 
		
		try {
			
			segmentolista = sd.findAll(segmento);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

}
