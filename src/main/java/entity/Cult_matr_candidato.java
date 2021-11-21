package entity;

public class Cult_matr_candidato {
	
	private Integer id_candidato;
	private Integer id_responsavel;
	private String nome_candidato;
	private String mae_candidato;
	private String pai_candidato;
	private String nascimento_candidato;
	private String estciv_candidato;
	private String sexo_candidato;
	private String nacionalidade_candidato;
	private String email_candidato;
	private String celular_candidato;
	private String fixo_candidato;
	private String bairro_candidato;
	private Integer ano_candidato;
	
	private String nome_responsavel;
	private String tipo_responsavel;
	private String cpf_responsavel;
	private String email_responsavel;
	private String celular_responsavel;
	private String identidade_responsavel;
	private String emissoridt_responsavel;
	
	private String tipo_endereco;
	private String identidade_endereco;
	private String cep_endereco; 
	private String uf_endereco; 
	private String logradouro_endereco;
	private String numero_endereco;
	private String complemento_endereco;
	private String codigo_municipio;
	private String bairro_endereco;
	
	private String tipo_candidato;
	private String necespec_candidato;
	private String cid_candidato;
	
	private String descricao_cid10;
	
	private Integer id_segmento1; // primeira opção
	private Integer id_segmento2; // primeira opção
	private Integer id_segmento3; // primeira opção
	private Integer id_segmento4; // primeira opção
	private Integer id_segmento5; // primeira opção
	private Integer id_segmento;  // Opção na qual foi selecionado
	
	private String descricao_segmento1;
	private String dia_segmento1;	
	private String turno_segmento1;	
	
	private String descricao_segmento2;
	private String dia_segmento2;	
	private String turno_segmento2;	
	
	private String descricao_segmento3;
	private String dia_segmento3;	
	private String turno_segmento3;	
	
	private String descricao_segmento4;
	private String dia_segmento4;	
	private String turno_segmento4;	
	
	private String descricao_segmento5;
	private String dia_segmento5;	
	private String turno_segmento5;
	
	private String cpf_candidato;
	
	private String datainscricao_candidato;
	
	private String data_ini;
	private String data_fim;	
	
	public Cult_matr_candidato() {
		super();
	}

	public Cult_matr_candidato(Integer id_candidato, Integer id_responsavel, String nome_candidato,
			String mae_candidato, String pai_candidato, String nascimento_candidato, String estciv_candidato,
			String sexo_candidato, String nacionalidade_candidato, String email_candidato, String celular_candidato,
			String fixo_candidato, String bairro_candidato, Integer ano_candidato, String nome_responsavel,
			String tipo_responsavel, String cpf_responsavel, String email_responsavel, String celular_responsavel,
			String identidade_responsavel, String emissoridt_responsavel, String tipo_endereco,
			String identidade_endereco, String cep_endereco, String uf_endereco, String logradouro_endereco,
			String numero_endereco, String complemento_endereco, String codigo_municipio, String bairro_endereco,
			String tipo_candidato, String necespec_candidato, String cid_candidato, String descricao_cid10,
			Integer id_segmento1, Integer id_segmento2, Integer id_segmento3, Integer id_segmento4,
			Integer id_segmento5, Integer id_segmento, String descricao_segmento1, String dia_segmento1,
			String turno_segmento1, String descricao_segmento2, String dia_segmento2, String turno_segmento2,
			String descricao_segmento3, String dia_segmento3, String turno_segmento3, String descricao_segmento4,
			String dia_segmento4, String turno_segmento4, String descricao_segmento5, String dia_segmento5,
			String turno_segmento5, String cpf_candidato, String datainscricao_candidato) {
		super();
		this.id_candidato = id_candidato;
		this.id_responsavel = id_responsavel;
		this.nome_candidato = nome_candidato;
		this.mae_candidato = mae_candidato;
		this.pai_candidato = pai_candidato;
		this.nascimento_candidato = nascimento_candidato;
		this.estciv_candidato = estciv_candidato;
		this.sexo_candidato = sexo_candidato;
		this.nacionalidade_candidato = nacionalidade_candidato;
		this.email_candidato = email_candidato;
		this.celular_candidato = celular_candidato;
		this.fixo_candidato = fixo_candidato;
		this.bairro_candidato = bairro_candidato;
		this.ano_candidato = ano_candidato;
		this.nome_responsavel = nome_responsavel;
		this.tipo_responsavel = tipo_responsavel;
		this.cpf_responsavel = cpf_responsavel;
		this.email_responsavel = email_responsavel;
		this.celular_responsavel = celular_responsavel;
		this.identidade_responsavel = identidade_responsavel;
		this.emissoridt_responsavel = emissoridt_responsavel;
		this.tipo_endereco = tipo_endereco;
		this.identidade_endereco = identidade_endereco;
		this.cep_endereco = cep_endereco;
		this.uf_endereco = uf_endereco;
		this.logradouro_endereco = logradouro_endereco;
		this.numero_endereco = numero_endereco;
		this.complemento_endereco = complemento_endereco;
		this.codigo_municipio = codigo_municipio;
		this.bairro_endereco = bairro_endereco;
		this.tipo_candidato = tipo_candidato;
		this.necespec_candidato = necespec_candidato;
		this.cid_candidato = cid_candidato;
		this.descricao_cid10 = descricao_cid10;
		this.id_segmento1 = id_segmento1;
		this.id_segmento2 = id_segmento2;
		this.id_segmento3 = id_segmento3;
		this.id_segmento4 = id_segmento4;
		this.id_segmento5 = id_segmento5;
		this.id_segmento = id_segmento;
		this.descricao_segmento1 = descricao_segmento1;
		this.dia_segmento1 = dia_segmento1;
		this.turno_segmento1 = turno_segmento1;
		this.descricao_segmento2 = descricao_segmento2;
		this.dia_segmento2 = dia_segmento2;
		this.turno_segmento2 = turno_segmento2;
		this.descricao_segmento3 = descricao_segmento3;
		this.dia_segmento3 = dia_segmento3;
		this.turno_segmento3 = turno_segmento3;
		this.descricao_segmento4 = descricao_segmento4;
		this.dia_segmento4 = dia_segmento4;
		this.turno_segmento4 = turno_segmento4;
		this.descricao_segmento5 = descricao_segmento5;
		this.dia_segmento5 = dia_segmento5;
		this.turno_segmento5 = turno_segmento5;
		this.cpf_candidato = cpf_candidato;
		this.datainscricao_candidato = datainscricao_candidato;
	}

	public String getData_ini() {
		return data_ini;
	}

	public void setData_ini(String data_ini) {
		this.data_ini = data_ini;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public String getDatainscricao_candidato() {
		return datainscricao_candidato;
	}

	public void setDatainscricao_candidato(String datainscricao_candidato) {
		this.datainscricao_candidato = datainscricao_candidato;
	}

	public String getCpf_candidato() {
		return cpf_candidato;
	}

	public void setCpf_candidato(String cpf_candidato) {
		this.cpf_candidato = cpf_candidato;
	}

	public String getDescricao_cid10() {
		return descricao_cid10;
	}

	public void setDescricao_cid10(String descricao_cid10) {
		this.descricao_cid10 = descricao_cid10;
	}

	public String getTipo_endereco() {
		return tipo_endereco;
	}

	public void setTipo_endereco(String tipo_endereco) {
		this.tipo_endereco = tipo_endereco;
	}

	public String getIdentidade_endereco() {
		return identidade_endereco;
	}

	public void setIdentidade_endereco(String identidade_endereco) {
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

	public String getDescricao_segmento1() {
		return descricao_segmento1;
	}

	public void setDescricao_segmento1(String descricao_segmento1) {
		this.descricao_segmento1 = descricao_segmento1;
	}

	public String getDia_segmento1() {
		return dia_segmento1;
	}

	public void setDia_segmento1(String dia_segmento1) {
		this.dia_segmento1 = dia_segmento1;
	}

	public String getTurno_segmento1() {
		return turno_segmento1;
	}

	public void setTurno_segmento1(String turno_segmento1) {
		this.turno_segmento1 = turno_segmento1;
	}

	public String getDescricao_segmento2() {
		return descricao_segmento2;
	}

	public void setDescricao_segmento2(String descricao_segmento2) {
		this.descricao_segmento2 = descricao_segmento2;
	}

	public String getDia_segmento2() {
		return dia_segmento2;
	}

	public void setDia_segmento2(String dia_segmento2) {
		this.dia_segmento2 = dia_segmento2;
	}

	public String getTurno_segmento2() {
		return turno_segmento2;
	}

	public void setTurno_segmento2(String turno_segmento2) {
		this.turno_segmento2 = turno_segmento2;
	}

	public String getDescricao_segmento3() {
		return descricao_segmento3;
	}

	public void setDescricao_segmento3(String descricao_segmento3) {
		this.descricao_segmento3 = descricao_segmento3;
	}

	public String getDia_segmento3() {
		return dia_segmento3;
	}

	public void setDia_segmento3(String dia_segmento3) {
		this.dia_segmento3 = dia_segmento3;
	}

	public String getTurno_segmento3() {
		return turno_segmento3;
	}

	public void setTurno_segmento3(String turno_segmento3) {
		this.turno_segmento3 = turno_segmento3;
	}

	public String getDescricao_segmento4() {
		return descricao_segmento4;
	}

	public void setDescricao_segmento4(String descricao_segmento4) {
		this.descricao_segmento4 = descricao_segmento4;
	}

	public String getDia_segmento4() {
		return dia_segmento4;
	}

	public void setDia_segmento4(String dia_segmento4) {
		this.dia_segmento4 = dia_segmento4;
	}

	public String getTurno_segmento4() {
		return turno_segmento4;
	}

	public void setTurno_segmento4(String turno_segmento4) {
		this.turno_segmento4 = turno_segmento4;
	}

	public String getDescricao_segmento5() {
		return descricao_segmento5;
	}

	public void setDescricao_segmento5(String descricao_segmento5) {
		this.descricao_segmento5 = descricao_segmento5;
	}

	public String getDia_segmento5() {
		return dia_segmento5;
	}

	public void setDia_segmento5(String dia_segmento5) {
		this.dia_segmento5 = dia_segmento5;
	}

	public String getTurno_segmento5() {
		return turno_segmento5;
	}

	public void setTurno_segmento5(String turno_segmento5) {
		this.turno_segmento5 = turno_segmento5;
	}

	public Integer getId_candidato() {
		return id_candidato;
	}

	public void setId_candidato(Integer id_candidato) {
		this.id_candidato = id_candidato;
	}

	public Integer getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Integer id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome_candidato() {
		return nome_candidato;
	}

	public void setNome_candidato(String nome_candidato) {
		this.nome_candidato = nome_candidato;
	}

	public String getMae_candidato() {
		return mae_candidato;
	}

	public void setMae_candidato(String mae_candidato) {
		this.mae_candidato = mae_candidato;
	}

	public String getPai_candidato() {
		return pai_candidato;
	}

	public void setPai_candidato(String pai_candidato) {
		this.pai_candidato = pai_candidato;
	}

	public String getNascimento_candidato() {
		return nascimento_candidato;
	}

	public void setNascimento_candidato(String nascimento_candidato) {
		this.nascimento_candidato = nascimento_candidato;
	}

	public String getEstciv_candidato() {
		return estciv_candidato;
	}

	public void setEstciv_candidato(String estciv_candidato) {
		this.estciv_candidato = estciv_candidato;
	}

	public String getSexo_candidato() {
		return sexo_candidato;
	}

	public void setSexo_candidato(String sexo_candidato) {
		this.sexo_candidato = sexo_candidato;
	}

	public String getNacionalidade_candidato() {
		return nacionalidade_candidato;
	}

	public void setNacionalidade_candidato(String nacionalidade_candidato) {
		this.nacionalidade_candidato = nacionalidade_candidato;
	}

	public String getEmail_candidato() {
		return email_candidato;
	}

	public void setEmail_candidato(String email_candidato) {
		this.email_candidato = email_candidato;
	}

	public String getCelular_candidato() {
		return celular_candidato;
	}

	public void setCelular_candidato(String celular_candidato) {
		this.celular_candidato = celular_candidato;
	}

	public String getFixo_candidato() {
		return fixo_candidato;
	}

	public void setFixo_candidato(String fixo_candidato) {
		this.fixo_candidato = fixo_candidato;
	}

	public String getBairro_candidato() {
		return bairro_candidato;
	}

	public void setBairro_candidato(String bairro_candidato) {
		this.bairro_candidato = bairro_candidato;
	}

	public Integer getAno_candidato() {
		return ano_candidato;
	}

	public void setAno_candidato(Integer ano_candidato) {
		this.ano_candidato = ano_candidato;
	}

	public String getTipo_candidato() {
		return tipo_candidato;
	}

	public void setTipo_candidato(String tipo_candidato) {
		this.tipo_candidato = tipo_candidato;
	}

	public String getNecespec_candidato() {
		return necespec_candidato;
	}

	public void setNecespec_candidato(String necespec_candidato) {
		this.necespec_candidato = necespec_candidato;
	}

	public String getCid_candidato() {
		return cid_candidato;
	}

	public void setCid_candidato(String cid_candidato) {
		this.cid_candidato = cid_candidato;
	}

	public Integer getId_segmento1() {
		return id_segmento1;
	}

	public void setId_segmento1(Integer id_segmento1) {
		this.id_segmento1 = id_segmento1;
	}

	public Integer getId_segmento2() {
		return id_segmento2;
	}

	public void setId_segmento2(Integer id_segmento2) {
		this.id_segmento2 = id_segmento2;
	}

	public Integer getId_segmento3() {
		return id_segmento3;
	}

	public void setId_segmento3(Integer id_segmento3) {
		this.id_segmento3 = id_segmento3;
	}

	public Integer getId_segmento4() {
		return id_segmento4;
	}

	public void setId_segmento4(Integer id_segmento4) {
		this.id_segmento4 = id_segmento4;
	}

	public Integer getId_segmento5() {
		return id_segmento5;
	}

	public void setId_segmento5(Integer id_segmento5) {
		this.id_segmento5 = id_segmento5;
	}

	public Integer getId_segmento() {
		return id_segmento;
	}

	public void setId_segmento(Integer id_segmento) {
		this.id_segmento = id_segmento;
	}

	@Override
	public String toString() {
		return "Cult_matr_candidato [id_candidato=" + id_candidato + ", id_responsavel=" + id_responsavel
				+ ", nome_candidato=" + nome_candidato + ", mae_candidato=" + mae_candidato + ", pai_candidato="
				+ pai_candidato + ", nascimento_candidato=" + nascimento_candidato + ", estciv_candidato="
				+ estciv_candidato + ", sexo_candidato=" + sexo_candidato + ", nacionalidade_candidato="
				+ nacionalidade_candidato + ", email_candidato=" + email_candidato + ", celular_candidato="
				+ celular_candidato + ", fixo_candidato=" + fixo_candidato + ", bairro_candidato=" + bairro_candidato
				+ ", ano_candidato=" + ano_candidato + ", nome_responsavel=" + nome_responsavel + ", tipo_responsavel="
				+ tipo_responsavel + ", cpf_responsavel=" + cpf_responsavel + ", email_responsavel=" + email_responsavel
				+ ", celular_responsavel=" + celular_responsavel + ", identidade_responsavel=" + identidade_responsavel
				+ ", emissoridt_responsavel=" + emissoridt_responsavel + ", tipo_endereco=" + tipo_endereco
				+ ", identidade_endereco=" + identidade_endereco + ", cep_endereco=" + cep_endereco + ", uf_endereco="
				+ uf_endereco + ", logradouro_endereco=" + logradouro_endereco + ", numero_endereco=" + numero_endereco
				+ ", complemento_endereco=" + complemento_endereco + ", codigo_municipio=" + codigo_municipio
				+ ", bairro_endereco=" + bairro_endereco + ", tipo_candidato=" + tipo_candidato
				+ ", necespec_candidato=" + necespec_candidato + ", cid_candidato=" + cid_candidato
				+ ", descricao_cid10=" + descricao_cid10 + ", id_segmento1=" + id_segmento1 + ", id_segmento2="
				+ id_segmento2 + ", id_segmento3=" + id_segmento3 + ", id_segmento4=" + id_segmento4 + ", id_segmento5="
				+ id_segmento5 + ", id_segmento=" + id_segmento + ", descricao_segmento1=" + descricao_segmento1
				+ ", dia_segmento1=" + dia_segmento1 + ", turno_segmento1=" + turno_segmento1 + ", descricao_segmento2="
				+ descricao_segmento2 + ", dia_segmento2=" + dia_segmento2 + ", turno_segmento2=" + turno_segmento2
				+ ", descricao_segmento3=" + descricao_segmento3 + ", dia_segmento3=" + dia_segmento3
				+ ", turno_segmento3=" + turno_segmento3 + ", descricao_segmento4=" + descricao_segmento4
				+ ", dia_segmento4=" + dia_segmento4 + ", turno_segmento4=" + turno_segmento4 + ", descricao_segmento5="
				+ descricao_segmento5 + ", dia_segmento5=" + dia_segmento5 + ", turno_segmento5=" + turno_segmento5
				+ ", cpf_candidato=" + cpf_candidato + ", datainscricao_candidato=" + datainscricao_candidato
				+ ", data_ini=" + data_ini + ", data_fim=" + data_fim + "]";
	} 
}
