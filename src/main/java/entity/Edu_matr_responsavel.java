package entity;

public class Edu_matr_responsavel {
	
	private Integer id_responsavel;
	private String nome_responsavel;
	private String tipo_responsavel;
	private String cpf_responsavel;
	private String email_responsavel;
	private String celular_responsavel;
	private String identidade_responsavel;
	private String emissoridt_responsavel;
	
	public Edu_matr_responsavel() {
		super();
	}

	public Edu_matr_responsavel(Integer id_responsavel, String nome_responsavel, String tipo_responsavel,
			String cpf_responsavel, String email_responsavel, String celular_responsavel, String identidade_responsavel,
			String emissoridt_responsavel) {
		super();
		this.id_responsavel = id_responsavel;
		this.nome_responsavel = nome_responsavel;
		this.tipo_responsavel = tipo_responsavel;
		this.cpf_responsavel = cpf_responsavel;
		this.email_responsavel = email_responsavel;
		this.celular_responsavel = celular_responsavel;
		this.identidade_responsavel = identidade_responsavel;
		this.emissoridt_responsavel = emissoridt_responsavel;
	}

	public Integer getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Integer id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public String getTipo_responsavel() {
		return tipo_responsavel;
	}

	public void setTipo_responsavel(String tipo_responsavel) {
		this.tipo_responsavel = tipo_responsavel;
	}

	public String getCpf_responsavel() {
		return cpf_responsavel;
	}

	public void setCpf_responsavel(String cpf_responsavel) {
		this.cpf_responsavel = cpf_responsavel;
	}

	public String getEmail_responsavel() {
		return email_responsavel;
	}

	public void setEmail_responsavel(String email_responsavel) {
		this.email_responsavel = email_responsavel;
	}

	public String getCelular_responsavel() {
		return celular_responsavel;
	}

	public void setCelular_responsavel(String celular_responsavel) {
		this.celular_responsavel = celular_responsavel;
	}

	public String getIdentidade_responsavel() {
		return identidade_responsavel;
	}

	public void setIdentidade_responsavel(String identidade_responsavel) {
		this.identidade_responsavel = identidade_responsavel;
	}

	public String getEmissoridt_responsavel() {
		return emissoridt_responsavel;
	}

	public void setEmissoridt_responsavel(String emissoridt_responsavel) {
		this.emissoridt_responsavel = emissoridt_responsavel;
	}

	@Override
	public String toString() {
		return "Edu_matr_responsavel [id_responsavel=" + id_responsavel + ", nome_responsavel=" + nome_responsavel
				+ ", tipo_responsavel=" + tipo_responsavel + ", cpf_responsavel=" + cpf_responsavel
				+ ", email_responsavel=" + email_responsavel + ", celular_responsavel=" + celular_responsavel
				+ ", identidade_responsavel=" + identidade_responsavel + ", emissoridt_responsavel="
				+ emissoridt_responsavel + "]";
	}
}
