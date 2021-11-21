package manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import entity.End_endereco;
import persistence.End_enderecoDao;

@ManagedBean
@ViewScoped
public class End_enderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1524754725472111625L;
	
	public End_endereco endereco;
	
	public List<End_endereco> enderecolista;
	
	public Integer idEntidade;
	public String tipoEntidade;
	
	public End_enderecoBean() {
		
	}	
	
	@PostConstruct
	public void init() {
		
		carregalistadasession();
		
//		limpalistadasession();		
	}
	
	public Integer getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(Integer idEntidade) {
		this.idEntidade = idEntidade;
	}

	public String getTipoEntidade() {
		return tipoEntidade;
	}

	public void setTipoEntidade(String tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
	}

	public void carregalistadasession() {					
		endereco = (End_endereco) new PaginasBean().GetPropriedadeSessionScope("endereco");
	}
	
	public void limpalistadasession() {					
		new PaginasBean().RemovePropriedadeSessionScope("endereco");
	}


	public End_endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(End_endereco endereco) {
		this.endereco = endereco;
	}

	public List<End_endereco> getEnderecolista() {
		return enderecolista;
	}

	public void setEnderecolista(List<End_endereco> enderecolista) {
		this.enderecolista = enderecolista;
	}
		
	public void AbreDialogoEndereco() {
		
		End_enderecoDao ed = new End_enderecoDao();
		
		try {
			
			endereco = ed.findOne(idEntidade, tipoEntidade);
			
			endereco.setIdentidade_endereco(idEntidade);
			endereco.setTipo_endereco(tipoEntidade);
			endereco.setUf_endereco("RJ");
			endereco.setCodigo_municipio("3303203");
			
			
			new PaginasBean().SetPropriedadeSessionScope("endereco", endereco);

			PrimeFaces.current().executeScript("PF('DialogoEndereco').show();");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}		
			
	}
	
	public void Cadastrar() {
		Integer linhas = 0;
		
		End_enderecoDao ed = new End_enderecoDao();
		
		try {
			
			linhas = ed.gravar(endereco);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso! " + linhas + " registro incluído", ""));
			
			endereco = new End_endereco();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
	}
	
	public void Atualizar() {
		Integer linhas = 0;
		
		End_enderecoDao ed = new End_enderecoDao();
		
		try {
			
			linhas = ed.alterar(endereco);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração efetuada com sucesso! " + linhas + " registros alterados", ""));
			
			endereco = new End_endereco();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public void Excluir(){
		Integer linhas = 0;
		
		End_enderecoDao ed = new End_enderecoDao();
		
		try {
			
			linhas = ed.excluir(endereco);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão efetuada com sucesso! " + linhas + " registros excluídos", ""));
			
			endereco = new End_endereco();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

}
