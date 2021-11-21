package entity;

import java.io.Serializable;

public class Ctrl_usuarios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -131191910656954720L;
	
	private Integer id_usu;
	private String cpf_usu;
	private String login_usu;
	private String nome_usu;
	private String datanasc_usu;
	private String tipo_usu;
	private String senha_usu;
	
	public Ctrl_usuarios() {
		super();
	}

	public Ctrl_usuarios(Integer id_usu, String cpf_usu, String login_usu, String nome_usu,
			String datanasc_usu, String tipo_usu, String senha_usu) {
		super();
		this.id_usu = id_usu;
		this.cpf_usu = cpf_usu;
		this.login_usu = login_usu;
		this.nome_usu = nome_usu;
		this.datanasc_usu = datanasc_usu;
		this.tipo_usu = tipo_usu;
		this.senha_usu = senha_usu;
	}

	public String getCpf_usu() {
		return cpf_usu;
	}

	public void setCpf_usu(String cpf_usu) {
		this.cpf_usu = cpf_usu;
	}

	public Integer getId_usu() {
		return id_usu;
	}

	public void setId_usu(Integer id_usu) {
		this.id_usu = id_usu;
	}

	public String getLogin_usu() {
		return login_usu;
	}

	public void setLogin_usu(String login_usu) {
		this.login_usu = login_usu;
	}

	public String getNome_usu() {
		return nome_usu;
	}

	public void setNome_usu(String nome_usu) {
		this.nome_usu = nome_usu;
	}

	public String getDatanasc_usu() {
		return datanasc_usu;
	}

	public void setDatanasc_usu(String datanasc_usu) {
		this.datanasc_usu = datanasc_usu;
	}

	public String getTipo_usu() {
		return tipo_usu;
	}

	public void setTipo_usu(String tipo_usu) {
		this.tipo_usu = tipo_usu;
	}

	public String getSenha_usu() {
		return senha_usu;
	}

	public void setSenha_usu(String senha_usu) {
		this.senha_usu = senha_usu;
	}

	@Override
	public String toString() {
		return "Ctrl_usuarios [id_usu=" + id_usu + ", cpf_usu=" + cpf_usu + ", login_usu=" + login_usu + ", nome_usu="
				+ nome_usu + ", datanasc_usu=" + datanasc_usu + ", tipo_usu=" + tipo_usu
				+ ", senha_usu=" + senha_usu + "]";
	}

}
