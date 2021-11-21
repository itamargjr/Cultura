package entity;

import java.io.Serializable;

public class End_endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1357764661301875948L;
	
	private Integer id_endereco;
	private String tipo_endereco;
	private Integer identidade_endereco;
	private String cep_endereco;
	private String uf_endereco;
	private String logradouro_endereco;
	private String numero_endereco;
	private String complemento_endereco;
	private String codigo_municipio;
	private String bairro_endereco;
	
	public End_endereco(Integer id_endereco, String tipo_endereco, Integer identidade_endereco, String cep_endereco,
			String uf_endereco, String logradouro_endereco, String numero_endereco, String complemento_endereco,
			String codigo_municipio, String bairro_endereco) {
		super();
		this.id_endereco = id_endereco;
		this.tipo_endereco = tipo_endereco;
		this.identidade_endereco = identidade_endereco;
		this.cep_endereco = cep_endereco;
		this.uf_endereco = uf_endereco;
		this.logradouro_endereco = logradouro_endereco;
		this.numero_endereco = numero_endereco;
		this.complemento_endereco = complemento_endereco;
		this.codigo_municipio = codigo_municipio;
		this.bairro_endereco = bairro_endereco;
	}

	public End_endereco() {
		super();
	}

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getTipo_endereco() {
		return tipo_endereco;
	}

	public void setTipo_endereco(String tipo_endereco) {
		this.tipo_endereco = tipo_endereco;
	}

	public Integer getIdentidade_endereco() {
		return identidade_endereco;
	}

	public void setIdentidade_endereco(Integer identidade_endereco) {
		this.identidade_endereco = identidade_endereco;
	}

	public String getCep_endereco() {
		return cep_endereco;
	}

	public void setCep_endereco(String cep_endereco) {
		this.cep_endereco = cep_endereco;
	}

	public String getUf_endereco() {
		return uf_endereco;
	}

	public void setUf_endereco(String uf_endereco) {
		this.uf_endereco = uf_endereco;
	}

	public String getLogradouro_endereco() {
		return logradouro_endereco;
	}

	public void setLogradouro_endereco(String logradouro_endereco) {
		this.logradouro_endereco = logradouro_endereco;
	}

	public String getNumero_endereco() {
		return numero_endereco;
	}

	public void setNumero_endereco(String numero_endereco) {
		this.numero_endereco = numero_endereco;
	}

	public String getComplemento_endereco() {
		return complemento_endereco;
	}

	public void setComplemento_endereco(String complemento_endereco) {
		this.complemento_endereco = complemento_endereco;
	}

	public String getCodigo_municipio() {
		return codigo_municipio;
	}

	public void setCodigo_municipio(String codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}

	public String getBairro_endereco() {
		return bairro_endereco;
	}

	public void setBairro_endereco(String bairro_endereco) {
		this.bairro_endereco = bairro_endereco;
	}

	@Override
	public String toString() {
		return "End_endereco [id_endereco=" + id_endereco + ", tipo_endereco=" + tipo_endereco
				+ ", identidade_endereco=" + identidade_endereco + ", cep_endereco=" + cep_endereco + ", uf_endereco="
				+ uf_endereco + ", logradouro_endereco=" + logradouro_endereco + ", numero_endereco=" + numero_endereco
				+ ", complemento_endereco=" + complemento_endereco + ", codigo_municipio=" + codigo_municipio
				+ ", bairro_endereco=" + bairro_endereco + "]";
	}	

}
