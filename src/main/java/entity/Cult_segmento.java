package entity;

public class Cult_segmento {
	private Integer id_segmento;
	private Integer ano_segmento;
	private String descricao_segmento;
	private Integer idademin_segmento;	
	private Integer idademax_segmento;	
	private String dia_segmento;	
	private String turno_segmento;	
	private Integer vagas_segmento;
	
	private Integer idadebusca;

	public Cult_segmento(Integer id_segmento, Integer ano_segmento, String descricao_segmento,
			Integer idademin_segmento, Integer idademax_segmento, String dia_segmento, String turno_segmento,
			Integer vagas_segmento) {
		super();
		this.id_segmento = id_segmento;
		this.ano_segmento = ano_segmento;
		this.descricao_segmento = descricao_segmento;
		this.idademin_segmento = idademin_segmento;
		this.idademax_segmento = idademax_segmento;
		this.dia_segmento = dia_segmento;
		this.turno_segmento = turno_segmento;
		this.vagas_segmento = vagas_segmento;
	}

	public Cult_segmento() {
		super();
	}

	public Integer getIdadebusca() {
		return idadebusca;
	}

	public void setIdadebusca(Integer idadebusca) {
		this.idadebusca = idadebusca;
	}

	public Integer getAno_segmento() {
		return ano_segmento;
	}

	public void setAno_segmento(Integer ano_segmento) {
		this.ano_segmento = ano_segmento;
	}

	public Integer getIdademin_segmento() {
		return idademin_segmento;
	}

	public void setIdademin_segmento(Integer idademin_segmento) {
		this.idademin_segmento = idademin_segmento;
	}

	public Integer getIdademax_segmento() {
		return idademax_segmento;
	}

	public void setIdademax_segmento(Integer idademax_segmento) {
		this.idademax_segmento = idademax_segmento;
	}

	public String getDia_segmento() {
		return dia_segmento;
	}

	public void setDia_segmento(String dia_segmento) {
		this.dia_segmento = dia_segmento;
	}

	public String getTurno_segmento() {
		return turno_segmento;
	}

	public void setTurno_segmento(String turno_segmento) {
		this.turno_segmento = turno_segmento;
	}

	public Integer getVagas_segmento() {
		return vagas_segmento;
	}

	public void setVagas_segmento(Integer vagas_segmento) {
		this.vagas_segmento = vagas_segmento;
	}

	public Integer getId_segmento() {
		return id_segmento;
	}

	public void setId_segmento(Integer id_segmento) {
		this.id_segmento = id_segmento;
	}

	public String getDescricao_segmento() {
		return descricao_segmento;
	}

	public void setDescricao_segmento(String descricao_segmento) {
		this.descricao_segmento = descricao_segmento;
	}

	@Override
	public String toString() {
		return "Cult_segmento [id_segmento=" + id_segmento + ", ano_segmento=" + ano_segmento + ", descricao_segmento="
				+ descricao_segmento + ", idademin_segmento=" + idademin_segmento + ", idademax_segmento="
				+ idademax_segmento + ", dia_segmento=" + dia_segmento + ", turno_segmento=" + turno_segmento
				+ ", vagas_segmento=" + vagas_segmento + ", idadebusca=" + idadebusca + "]";
	}

}
