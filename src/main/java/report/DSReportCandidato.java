package report;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import entity.Cult_matr_candidato;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DSReportCandidato implements JRDataSource {
	
	private Iterator<Cult_matr_candidato> dados;
	
	private Cult_matr_candidato registro;
	
	public DSReportCandidato(List<Cult_matr_candidato> lista) {
		dados = lista.iterator();
	}
	
	@Override
	public Object getFieldValue(JRField field) throws JRException {
		if(field.getName().equalsIgnoreCase("id_candidato")){
			return new BigDecimal(registro.getId_candidato());
		}
		
		if(field.getName().equalsIgnoreCase("id_responsavel")){
			return new BigDecimal(registro.getId_responsavel());
		}
		
		if(field.getName().equalsIgnoreCase("nome_candidato")){
			return registro.getNome_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("mae_candidato")){
			return registro.getMae_candidato();
		}

		if(field.getName().equalsIgnoreCase("pai_candidato")){
			return registro.getPai_candidato();
		}
		if(field.getName().equalsIgnoreCase("nascimento_candidato")){
			return registro.getNascimento_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("estciv_candidato")){
			return registro.getEstciv_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("sexo_candidato")){
			return registro.getSexo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("nacionalidade_candidato")){
			return registro.getNacionalidade_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("email_candidato")){
			return registro.getEmail_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("celular_candidato")){
			return registro.getCelular_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("fixo_candidato")){
			return registro.getFixo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("bairro_candidato")){
			return registro.getBairro_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("ano_candidato")){
			return new BigDecimal(registro.getAno_candidato());
		}
		
		if(field.getName().equalsIgnoreCase("nome_responsavel")){
			return registro.getNome_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("tipo_responsavel")){
			return registro.getTipo_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("cpf_responsavel")){
			return registro.getCpf_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("email_responsavel")){
			return registro.getEmail_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("celular_responsavel")){
			return registro.getCelular_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("identidade_responsavel")){
			return registro.getIdentidade_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("emissoridt_responsavel")){
			return registro.getEmissoridt_responsavel();
		}
		
		if(field.getName().equalsIgnoreCase("tipo_endereco")){
			return registro.getTipo_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("identidade_endereco")){
			return registro.getIdentidade_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("cep_endereco")){
			return registro.getCep_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("uf_endereco")){
			return registro.getUf_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("logradouro_endereco")){
			return registro.getLogradouro_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("numero_endereco")){
			return registro.getNumero_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("complemento_endereco")){
			return registro.getComplemento_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("codigo_municipio")){
			return registro.getCodigo_municipio();
		}
		
		if(field.getName().equalsIgnoreCase("bairro_endereco")){
			return registro.getBairro_endereco();
		}
		
		if(field.getName().equalsIgnoreCase("tipo_candidato")){
			return registro.getTipo_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("necespec_candidato")){
			return registro.getNecespec_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("cid_candidato")){
			return registro.getCid_candidato();
		}
		
		if(field.getName().equalsIgnoreCase("descricao_cid10")){
			return registro.getDescricao_cid10();
		}
		
		if(field.getName().equalsIgnoreCase("id_segmento1")){
			return new BigDecimal(registro.getId_segmento1());
		} 
		if(field.getName().equalsIgnoreCase("id_segmento2")){
			return new BigDecimal(registro.getId_segmento2());
		} 
		if(field.getName().equalsIgnoreCase("id_segmento3")){
			return new BigDecimal(registro.getId_segmento3());
		}
		if(field.getName().equalsIgnoreCase("id_segmento4")){
			return new BigDecimal(registro.getId_segmento4());
		} 
		if(field.getName().equalsIgnoreCase("id_segmento5")){
			return new BigDecimal(registro.getId_segmento5());
		} 
		if(field.getName().equalsIgnoreCase("id_segmento")){
			return new BigDecimal(registro.getId_segmento());
		}  
		
		if(field.getName().equalsIgnoreCase("descricao_segmento1")){
			return registro.getDescricao_segmento1();
		}
		if(field.getName().equalsIgnoreCase("dia_segmento1")){
			return registro.getDia_segmento1();
		}	
		if(field.getName().equalsIgnoreCase("turno_segmento1")){
			return registro.getTurno_segmento1();
		}	
		
		if(field.getName().equalsIgnoreCase("descricao_segmento2")){
			return registro.getDescricao_segmento2();
		}
		if(field.getName().equalsIgnoreCase("dia_segmento2")){
			return registro.getDia_segmento2();
		}	
		if(field.getName().equalsIgnoreCase("turno_segmento2")){
			return registro.getTurno_segmento2();
		}	
		
		if(field.getName().equalsIgnoreCase("descricao_segmento3")){
			return registro.getDescricao_segmento3();
		}
		if(field.getName().equalsIgnoreCase("dia_segmento3")){
			return registro.getDia_segmento3();
		}
		if(field.getName().equalsIgnoreCase("turno_segmento3")){
			return registro.getTurno_segmento3();
		}	
		
		if(field.getName().equalsIgnoreCase("descricao_segmento4")){
			return registro.getDescricao_segmento4();
		}
		if(field.getName().equalsIgnoreCase("dia_segmento4")){
			return registro.getDia_segmento4();
		}	
		if(field.getName().equalsIgnoreCase("turno_segmento4")){
			return registro.getTurno_segmento4();
		}	
		
		if(field.getName().equalsIgnoreCase("descricao_segmento5")){
			return registro.getDescricao_segmento5();
		}
		if(field.getName().equalsIgnoreCase("dia_segmento5")){
			return registro.getDia_segmento5();
		}	
		if(field.getName().equalsIgnoreCase("turno_segmento5")){
			return registro.getTurno_segmento5();
		}	
		if(field.getName().equalsIgnoreCase("cpf_candidato")){
			return registro.getCpf_candidato();
		}	
		if(field.getName().equalsIgnoreCase("datainscricao_candidato")){
			return registro.getDatainscricao_candidato();
		}
		
		return null;
	}

	@Override
	public boolean next() throws JRException {
		if(dados.hasNext()){
			registro = dados.next();
			return true;
		}
		return false;
	}

}
